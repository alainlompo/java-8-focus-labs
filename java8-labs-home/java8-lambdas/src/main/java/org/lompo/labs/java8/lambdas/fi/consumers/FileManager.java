package org.lompo.labs.java8.lambdas.fi.consumers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.function.Consumer;

public class FileManager {
	
	public static void processFile(File file, Consumer<File> consummer) {
		
		consummer.accept(file);
		
	}
	
	
	public static void processFolder(File folder, Consumer<File> consumer) {
		if (!folder.isDirectory()) {
			return;
		}
		File[] subFiles = folder.listFiles();
		
		for (File f: subFiles) {
			processFile(f, consumer);
		}
	}
	
	public static final Consumer<File> LINE_COUNTING_CONSUMER = (File f) -> {
		if (f.isDirectory()) {
			return;
		}
		try {
			BufferedReader bR = new BufferedReader (new FileReader(f));
			int counter = 0;
			String line = null;
			while((line = bR.readLine()) != null) {
				counter ++;
			}
			System.out.println(f.getName() + " :" + counter + " lines");
		} catch (FileNotFoundException fNE) {
			
		} catch (IOException ioEx) {
			
		}
	};
	
	public static void main(String[] args) throws IOException {
		
		File folder = new File("C:\\Hypernovae\\Technical\\TestDatas");
		processFolder(folder, LINE_COUNTING_CONSUMER);
		
	}

}
