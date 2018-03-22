package main.data.readers;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderUtil {
	public static Path getFilePath(String path) {
		try {
			return Paths.get(ReaderUtil.class.getResource(path).toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

}
