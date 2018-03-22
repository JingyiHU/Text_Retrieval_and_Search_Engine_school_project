package main.data.readers;

import java.nio.file.Files;
import java.util.function.Function;
import java.util.stream.Stream;

public class GenericLineReaderUtil {
	public static <T> T readAndProcess(String file, Function<Stream<String>, T> function)  {
		T result = null;
		try {
            Stream <String> lines = Files.lines(ReaderUtil.getFilePath(file));
            
            result = function.apply(lines);
            
            lines.close();
 
        } catch (Throwable e) {
        	throw new RuntimeException(e);
		}	
		
		return result;
	}
}
