package com.NEU.tool;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.NEU.model.Disease;

public class DiseaseIO {
	
public static void Write(Disease d, String filePath) throws IOException {
		
		OutputStream out = null;
		ObjectOutputStream oos = null;
		
		try {
			
			File file = new File(filePath);
			
			if (! file.exists()) {
				file.createNewFile();
			}
			
			out = new FileOutputStream(file);
				
			oos = new ObjectOutputStream(out);
			
			oos.writeObject(d);
			
		}finally {
			
			out.close();
			oos.close();
		}
	}
	
	public static Disease read(String filePath) throws IOException, ClassNotFoundException {
		
		Disease d = null;
		
		File file = new File(filePath);
		
		if (! file.exists()) {
			file.createNewFile();
		}
		
		InputStream in = new FileInputStream(file);
		
		try {
			ObjectInputStream ois = new ObjectInputStream(in);
			
			try {
				d = (Disease) ois.readObject();
			}catch(EOFException e) {
				// e.printStackTrace();
				System.out.println("正常");
			}finally {
				ois.close();
				in.close();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return d;
	}

}
