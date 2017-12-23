package com.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class FileIOut {

	public static void main(String[] args) throws IOException {

		System.out.println("Hello Start");
		String S = "fileS";
		FileOutputStream fos = new FileOutputStream("E://navin.txt");
		String s = "hi am don jshs sxij jskxh jwdhdjhwd";

		byte[] b = s.getBytes();
		System.out.println(b);
		// fos.write(b);
		Base64.Encoder encode = Base64.getMimeEncoder();
		String Sen = encode.encodeToString(b);
		System.out.println("Encoded" + Sen);

		Base64.Decoder decode = Base64.getMimeDecoder();
		String s1 = new String(decode.decode(Sen));
		System.out.println("decoded" + s1);
		fos.close();

	}

}
