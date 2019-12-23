package algos;

import java.io.File;

public class ListFiles {
	public static void main(String[] args) {
		File directory = new File("../");
		File[] files = directory.listFiles();
		
		for (File file: files)
			System.out.println(file.getName());
	}
}