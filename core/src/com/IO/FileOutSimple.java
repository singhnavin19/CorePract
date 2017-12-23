package com.IO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutSimple {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileOutputStream fout = new FileOutputStream("E://abc.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fout);
		String S = "hello";
		String s1 = " java";

		byte[] b = S.getBytes();
		byte[] b1 = s1.getBytes();
		// byte[] b3=b+b1;
		fout.write(b);
		fout.write(b1);

	}

}
