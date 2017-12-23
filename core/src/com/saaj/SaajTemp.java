package com.saaj;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

public class SaajTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			SOAPConnectionFactory ConFact=SOAPConnectionFactory.newInstance();
			SOAPConnection connection=ConFact.createConnection();
			
			MessageFactory msgfact=MessageFactory.newInstance();
			SOAPMessage msg=msgfact.createMessage();
			
			SOAPHeader head=msg.getSOAPHeader();
			
			
			
			
			
			
			
			
			
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
