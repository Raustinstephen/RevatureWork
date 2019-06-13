package com.revature.banking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
//this class is almost entirely unused in the current iteration, with the small 
//exception of reading the Admin username and password from the .properties file
public class IO {
	private static final String outfile = "Users.txt";
	private static final String outApps = "Applicants.txt";
	private static final String inFile = "Users.txt";
	private static final String inApps = "Applicants.txt";
	
	public void writeOutputStreamContents(String contents, String filename) {
		OutputStream os = null;
		File file = new File(filename);
		
		//false would overwrite. true appends to end of file
		try {
			os = new FileOutputStream(file, true);
			os.write(contents.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (os!=null) {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	//read a String from a file method
	public String readInputStreamContents(String filename) {
		InputStream is = null;
		File file = new File(filename);
		StringBuilder s = new StringBuilder();
		
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int b = 0;
		try {
			while((b = is.read()) != -1) {
				char c = (char)b;
				s.append(c);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s.toString();
		
	}
	@SuppressWarnings("null")
	//overwriter method
	public static void overwriter(String filename, String newString, String oldString, int fileLength) {
		File file = new File(filename);
		String old = "";
		BufferedReader reader = null;
		FileWriter writer = null;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			
			//reads every line of an array
			String line = reader.readLine();
			for (int i = 0; i <fileLength; i++) {
			while(line != null) {
				if(i == fileLength-1) {
					old = old + line;
					line = reader.readLine();
				}
				else {
					//and replaces until you get to the new line
				old = old + line + System.lineSeparator();
				line = reader.readLine();
				}
			}
			
			String newContent = old.replaceAll(oldString, newString);
			writer = new FileWriter(file);
			writer.write(newContent);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {

				reader.close();
				writer.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//fixer algorithm
	public static class Fixer {
		//as said in other places, all it does is ignore blank lines
		   public static String[] fixingList(String[] array) {
			   int length = array.length;
			   for (int i = 0; i<length; i++) {
		      if (array[i].equals("")) {
		    	  array[i]=array[1];
		    	  i=i+1;
		    	  continue;
		    	  
		    	  

		      }
		   }//And returns array
			return array;
		   }
		   
		  
		}
}
