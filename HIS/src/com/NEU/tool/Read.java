package com.NEU.tool;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Read {       //文件信息读入列表
	
	//信息读入
	
	public static <T> List<T> read(String filePath) throws IOException, ClassNotFoundException {
		
		File file = new File(filePath);
		
		List<T> list = new ArrayList<T>();
		
		if (! file.exists()) {
			file.createNewFile();
		}
		
		InputStream in = new FileInputStream(file);
		
		try {
			ObjectInputStream ois = new ObjectInputStream(in);
			
			try {
				while (true) {
					@SuppressWarnings("unchecked")
					T t = (T) ois.readObject();
					list.add(t);
				}
			}catch(EOFException e) {
				// e.printStackTrace();
				System.out.println("正常");
			}finally {
				ois.close();
				in.close();
			}
			
		}catch(IOException e) {
			System.out.println("文件夹为空");
		}
		
		return list;
		
	}
	
}
