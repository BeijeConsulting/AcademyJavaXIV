package File;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CSVreader {

	public static void main(String[] args) {
		File file = new File("/Users/matteoprovezza/Desktop/Beije/AcademyJavaXIV/Turing/src/File/temp/File123.txt");
		File file2 = new File("/Users/matteoprovezza/Desktop/Beije/AcademyJavaXIV/Turing/src/File/temp");
		
		System.out.println("file exists? " + file.exists());
		System.out.println("file is file? " + file.isFile());
		System.out.println("is dir? "+ file2.isDirectory()
		);
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			while(bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				System.out.println(row);
				
				String[] rows = row.split(";");
				for (String r : rows)  System.out.println(r);
			}
			
			
		} catch (IOException IOex ) {
			IOex.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException fex) {
				// TODO Auto-generated catch block
				fex.printStackTrace();
			}
			
			
		}
		
		
		
		
		

	}

}
