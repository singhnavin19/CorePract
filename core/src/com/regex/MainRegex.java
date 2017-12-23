package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "--MIMEBoundaryurn_uuid_06BAB3EE2E0B47B1881509700475975";
		s = s + "Content-Type: text/xml; charset=utf-8";
		s = s + "Content-Transfer-Encoding: 8bit";
		s = s + "Content-ID: <0.urn:uuid:06BAB3EE2E0B47B1881509700475976@apache.org>";

		s = s + "--MIMEBoundaryurn_uuid_06BAB3EE2E0B47B1881509700475975";
		s = s + "httpContent-Type: image/png";
		s = s + "Content-Transfer-Encoding: binary";
		s = s + "Content-ID: <urn:uuid:06BAB3EE2E0B47B1881509700475974>";
		s = s + "‰PNG";

		Pattern p = Pattern.compile("<urn.*>");
		Matcher m = p.matcher(s);
		System.out.println("Hello");
		int end = 0;
		while (m.find()) {
			end = m.end();
			System.out.println(m.start() + ".." + m.end() + ".." + m.group());
		}

		String finalS = s.substring(end, s.length());
		System.out.println("/n");
		System.out.println(finalS);
	}

}
