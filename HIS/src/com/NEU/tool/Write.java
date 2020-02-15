package com.NEU.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

public class Write {
	
	// 将信息存入文件
	
	public static <T> void write(List<T> list,String filePath) throws IOException {
		
		OutputStream out = null;
		ObjectOutputStream oos = null;
		
		try {
			
			File file = new File(filePath);
			
			if (! file.exists()) {
				file.createNewFile();
			}
			out = new FileOutputStream(file);
				
			oos = new ObjectOutputStream(out);
			
			if (list == null) {
				
				throw new IllegalArgumentException("list不能为空");

			}
			
			for (int i = 0;i < list.size();i ++) {
				oos.writeObject(list.get(i));
			}
			
		}finally {
			
			out.close();
			oos.close();
			
		}
	}
	
	
}