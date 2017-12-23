package com.word;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class DocReader {

	public static void readDocFile(String fileName) {

		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());

			HWPFDocument doc = new HWPFDocument(fis);

			WordExtractor we = new WordExtractor(doc);

			String[] paragraphs = we.getParagraphText();

			System.out.println("Total no of paragraph " + paragraphs.length);
			for (String para : paragraphs) {
				System.out.println(para.toString());

			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void readDocxFile(String fileName) {

		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());

			XWPFDocument document = new XWPFDocument(fis);

			List<XWPFParagraph> paragraphs = document.getParagraphs();

			System.out.println("Total no of paragraph " + paragraphs.size());
			for (XWPFParagraph para : paragraphs) {
				String s = para.getText();
				/*
				 * System.out.println(para.getFirstLineIndent());
				 * System.out.println(para.toString());
				 * System.out.println(para.getElementType());
				 */
				System.out.println(para.getText());
			}
			fis.close();

			// File file = new File(fileName);
			// FileInputStream fis = new
			// FileInputStream(file.getAbsolutePath());
			//
			// // create office word 2007+ document object to wrap the word file
			// XWPFDocument docx = new XWPFDocument(fis);
			// // get all images from the document and store them in the list
			// // piclist
			// List<XWPFPictureData> piclist = docx.getAllPictures();
			// // traverse through the list and write each image to a file
			// Iterator<XWPFPictureData> iterator = piclist.iterator();
			// int i = 0;
			// while (iterator.hasNext()) {
			// XWPFPictureData pic = iterator.next();
			// byte[] bytepic = pic.getData();
			//
			// System.out.println(pic.getFileName());
			// BufferedImage imag = ImageIO.read(new
			// ByteArrayInputStream(bytepic));
			// // ImageIO.write(imag, "jpg", new File("D:/imagefromword" + i +
			// // ".jpg"));
			// i++;
			// }

		}

		// File file = new File(fileName);
		// FileInputStream fis = new FileInputStream(file.getAbsolutePath());
		//
		// XWPFDocument document = new XWPFDocument(fis);
		//
		// List<XWPFParagraph> paragraphs = document.getParagraphs();
		//
		// System.out.println("Total no of paragraph " + paragraphs.size());
		// for (XWPFParagraph para : paragraphs) {
		// String s = para.getText();
		// System.out.println(para.getFirstLineIndent());
		// System.out.println(para.toString());
		// System.out.println(para.getElementType());
		// System.out.println(para.getText());
		// }
		// fis.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		readDocxFile("E:\\ManikandanPanneerselvam_Seo2016.docx");

		// readDocFile("C:\\Test.docx");

	}
}