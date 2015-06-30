package org.lompo.labs.java8.lambdas.fi.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

	public static final  String FILE_PATH = "C:\\Hypernovae\\Technical\\Labs\\Test.txt";
	
	/**
	 * Classic approach without using the execute around pattern
	 * @return
	 * @throws IOException
	 */
	public static String processFile() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
			return br.readLine();
		}
		
	}
	
	
	/**
	 * Using the execute around pattern relying on behavior parameterization
	 * Therefore the processing can now be customized at will.
	 * @param processor
	 * @return
	 * @throws IOException
	 */
	public static String processFile(BufferedReaderProcessor processor) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
			return processor.process(br);
		}
	}
	
	
	// Another way to express it by using fields or variables
	public static final BufferedReaderProcessor oneLineProcessor = (BufferedReader bR) -> bR.readLine();
	public static final BufferedReaderProcessor twoLinesProcessor = (BufferedReader bR) -> bR.readLine()+ "\n" + bR.readLine();
	
	
	/**
	 * Example of applying the execute around pattern
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String oneLine = processFile((BufferedReader bR) -> bR.readLine());
		String twoLines = processFile((BufferedReader bR) -> bR.readLine() + "\n" + bR.readLine());
		
		System.out.println("Result from first processing :" + oneLine);
		System.out.println("Result from second processing :" + twoLines);
		
	}
	
	
	
}
