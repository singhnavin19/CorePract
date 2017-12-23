package com.saaj;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class SaajPract1 {

	public static void main(String[] args) 
	{
		try {
			
			SOAPConnectionFactory sfc=SOAPConnectionFactory.newInstance();
			SOAPConnection con=sfc.createConnection();
			System.out.println("connectione created");
			
			MessageFactory msgfact=MessageFactory.newInstance();
		    SOAPMessage msg=msgfact.createMessage();
		    System.out.println("messgae created with part,envolope,header body");
		    
		    SOAPHeader Soap_header		=msg.getSOAPHeader();
		    SOAPPart Soap_part			=msg.getSOAPPart();
		    SOAPEnvelope Soap_Envolap	=Soap_part.getEnvelope();
			SOAPBody Soap_body	=msg.getSOAPBody();
		    Soap_header.detachNode();
		    Soap_part.detachNode();
		    
		    QName bodyname=new QName("add_document","add_doc","www.doc_url.com");
		    SOAPBodyElement body_element1=Soap_body.addBodyElement(bodyname);
		    //body_element1.addNamespaceDeclaration("add_doc","www.doc_url.com");
		    
		    QName name=new QName("node_1");
		    SOAPElement node_1=body_element1.addChildElement(name); 
		    node_1.addTextNode("first_node");
		    
		    QName name2=new QName("node_2");
		    SOAPElement node2=body_element1.addChildElement(name2);
		    node2.addTextNode("node2");
		    
		    URL docUrl = new URL("file:///E:/navin.txt");
		    //URL docUrl = new URL("file:///D:/test/NGOAddDocumentBDO.txt");
	        DataHandler dataHandler = new DataHandler(docUrl);
	        AttachmentPart attachment = msg.createAttachmentPart(dataHandler);
	        attachment.setContentId("CLICK_PSS");
	        msg.addAttachmentPart(attachment);
	        con.call(msg, args);
	        
	        FileOutputStream fos=new FileOutputStream("E://navinres.txt");
	       // fos.write(msg.writeTo(System.out));
		    
	        msg.writeTo(fos);
	        
	        //fos.write(1);
	        
			//String s=msg.WRITE_XML_DECLARATION	
			con.close();
			//ByteArrayInputStream bis new BufferedInputStream(bos);
			
			
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
