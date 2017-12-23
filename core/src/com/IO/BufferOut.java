package com.IO;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferOut {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fos = new FileOutputStream("E://abcd.txt", true);
		FileOutputStream fos1 = new FileOutputStream("E://abcd.txt", true);
		ByteArrayOutputStream byos = new ByteArrayOutputStream();
		byte[] b = { 65, 34 };
		byos.write(b);
		byos.writeTo(fos);
		byos.writeTo(fos1);
		byos.flush();
		byos.close();

	}

}
