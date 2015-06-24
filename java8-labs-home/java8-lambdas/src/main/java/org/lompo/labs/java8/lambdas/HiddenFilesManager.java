package org.lompo.labs.java8.lambdas;
import java.io.File;

public class HiddenFilesManager {
	
	/**
	 * Example of using the :: syntax.
	 * for each file in the directory it will use the isHidden method to check
	 * weither or not the file has the hidden attribute
	 * @param args
	 */
	public static void main(String[] args) {
		File[] hiddenFiles = new File("C:\\Hypernovae\\Technical\\RD\\All_Java")
		.listFiles(File::isHidden);
		for (File f: hiddenFiles) {
			System.out.println(f.getPath());
		}
	}

}
