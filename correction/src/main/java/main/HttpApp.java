package main;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import fi.iki.elonen.NanoHTTPD;
import main.data.readers.BulletinReader;
import main.objectmapper.ObjectMapperProvider;

public class HttpApp extends NanoHTTPD {
	public HttpApp() throws IOException {
        super(8080);
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("\nRunning! Point your browsers to http://localhost:8080/ \n");
    }

    public static void main(String[] args) {
        try {
            new HttpApp();
        } catch (IOException ioe) {
            System.err.println("Couldn't start server:\n" + ioe);
        }
    }

    @Override
    public Response serve(IHTTPSession session) {
    	try {
			String msg = "";
			Map<String, String> parms = session.getParms();
			
			String mimeType = null;
			
			String query = parms.get("query");
			String file = parms.get("file");
			if (query != null) {
				try {
					msg += ObjectMapperProvider.get().writeValueAsString(InputHandler.handleInput(query));
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}
				mimeType = "application/json";
			} else if (file != null) {
				msg += BulletinReader.readBulletin(file);
				mimeType = "text/html";
			}
			
			Response resp = newFixedLengthResponse(msg);
			if (mimeType != null) {
				resp.setMimeType(mimeType);
			}

			return resp;
    	} catch (Throwable t) {
    		t.printStackTrace();
    		throw new RuntimeException(t);
    	}
    }
}
