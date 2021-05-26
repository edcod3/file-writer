package io.github.edcod3.basic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	public static boolean writeNewFile(String filepath, String text) {
		try {
			File f = new File(filepath);
			if (f.exists()) {
				f.createNewFile();
			}
			FileWriter fWriter = new FileWriter(f);
			fWriter.write(text);
			fWriter.close();
			return true;
		} catch (IOException e) {
			System.out.println("Couldn't create/write file.");
			return false;
		}
	}
}
