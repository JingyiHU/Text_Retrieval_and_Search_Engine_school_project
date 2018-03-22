package main.data.readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BulletinReader {
	public static String readBulletin(String id) {
		Path filePath = ReaderUtil.getFilePath("/data/BULLETINS/" + id);
		
		try {
			return new String(Files.readAllBytes(filePath));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
