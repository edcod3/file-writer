package io.github.edcod3.basic;

import java.util.Scanner;
import java.io.File;

public class FileMain {
	
	public static boolean filedone = false;

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Text to write to file:");
		String text = input.nextLine();		
		System.out.println("Enter Path:");
		String path = input.nextLine();
		if (path == "") {
			System.out.println("No Path given..."+System.lineSeparator()+"Defaulting to current directory");
			path = System.getProperty("user.dir");
		}
		File chkfile = new File(path);
		if (chkfile.isDirectory()) {
			//Ask for file (& extension)
			//System.out.println("Path is a directory");
			String filename = getFile(input);
			String filepath = path + filename;
			if ((path.substring(path.length() - 1) != "/" || path.substring(path.length() - 1) != "\\") && !System.getProperty("os.name").startsWith("Windows")) {
				filepath = path + "/" + filename;
			} else {
				filepath = path + "\\" + filename;
			}
			filedone = FileHandler.writeNewFile(filepath, text);
		} else if (chkfile.exists()){
			filedone = FileHandler.writeNewFile(path, text);
		} else {
			//Create directory & ask for file
			System.out.println("Path doesnt exists.");
			if (chkfile.mkdirs()) {
				String filename = getFile(input);
				System.out.println("Created new directory at specified path.");
				String filepath = path + filename;
				filedone = FileHandler.writeNewFile(filepath, text);
			} else {
				System.out.println("Couldn't create new directory...");
			}
		}
		
		if (filedone) {
			System.out.println("Wrote output to file successfully!");
		} else {
			System.out.println("Couldn't write output to file...");
		}

		return;
	}
	
	
	public static String getFile(Scanner input_scanner) {
		System.out.println("Enter Filename & Extension:");
		String file = input_scanner.nextLine();
		return file;
	}

}
