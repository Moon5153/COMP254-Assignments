package com.assignment3;
/*
 * Author: Najmun Nahar
 * COMP-254
 * Assignment-3
 * Exercise-3
 */
import java.io.File;
import java.util.Scanner;

public class Exercise3 {
	public static String find(File path, String filename){
		File[] list = path.listFiles();
		String filePath="";
		if (list != null)
			for (File file : list)
			{
				if (file.isDirectory())								//if it is directory
				{													//then compose full path to filePath
					filePath+=find(file, filename);
				}
				else if (filename.equalsIgnoreCase(file.getName()))
				{
					filePath+=file.getParentFile();
				}
			}
		return filePath;
}
/**
 * Sample usage: file name: Ruler.java
 * drive name to be searched C:\Users\Najmun\eclipse-workspca
 */
	public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Enter file name to be searched " );
	        String filename = scan.nextLine();
	        System.out.println("Enter drive name to be searched ");
	        String directory = scan.nextLine();
	        String path=find(new File(directory),filename);
	        if(!path.equals("")){
	        	System.out.println(filename+" found at path: "+path);
	        }
	        else
	        {
	        	System.out.println(filename+" not found");
	        }

	}

}
