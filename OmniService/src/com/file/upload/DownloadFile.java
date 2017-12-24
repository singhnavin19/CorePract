package com.file.upload;
/**
 * @author Navin Singh
 */

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownloadFile {

	public JSONObject download(String jsonObjInput) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObjectRes = new JSONObject();

		JSONObject jsonObjectInput = new JSONObject(jsonObjInput);
		InputStream input = null;
		Properties prop = new Properties();

		try {
			input = DownloadFile.class.getClassLoader().getResourceAsStream("com/file/upload/omniservice.properties");
			if (input != null) {
				prop = new Properties();
				prop.load(input);
			} else {
				throw new Exception("Error while reading Java config file");
			}

			if (!jsonObjectInput.has("cabinetName")) {
				throw new Exception("cabinetName is mandatory.");

			}

			if (!jsonObjectInput.has("volumeId")) {

				throw new Exception("volumeId is mandatory.");
			}

			if (!jsonObjectInput.has("fileName")) {

				throw new Exception("fileName is mandatory.");
			}

			if (!jsonObjectInput.has("siteId")) {

				throw new Exception("siteId is mandatory.");

			}
			if (!jsonObjectInput.has("docIndex")) {

				throw new Exception("docIndex is mandatory.");
			}

			HashMap<String, String> propMap = new HashMap<String, String>();
			propMap.put("fileName", jsonObjectInput.getString("fileName"));
			propMap.put("cabinetName", jsonObjectInput.getString("cabinetName"));
			propMap.put("jtsAddress", prop.getProperty("jtsAddress"));
			propMap.put("portId", prop.getProperty("portId"));
			propMap.put("volumeId", jsonObjectInput.getString("volumeId"));
			propMap.put("siteId", jsonObjectInput.getString("siteId"));
			propMap.put("docIndex", jsonObjectInput.getString("docIndex"));
			SOAPConnection connection = null;
			try {
				SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
				connection = soapConnectionFactory.createConnection();
				SOAPFactory soapFactory = SOAPFactory.newInstance();
				MessageFactory factory = MessageFactory.newInstance();
				SOAPMessage message = factory.createMessage();
				SOAPHeader header = message.getSOAPHeader();
				SOAPBody body = message.getSOAPBody();
				header.detachNode();
				Name bodyName = soapFactory.createName("downloadDocInFile", prop.getProperty("nameSpace1"),
						prop.getProperty("nameSpaceUri1"));
				SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
				bodyElement.addNamespaceDeclaration(prop.getProperty("nameSpace2"), prop.getProperty("nameSpaceUri2"));
				Name paramName = soapFactory.createName("param0", prop.getProperty("nameSpace1"),
						prop.getProperty("nameSpaceUri1"));
				SOAPElement paramEle = bodyElement.addChildElement(paramName);

				Iterator iter = propMap.keySet().iterator();
				while (iter.hasNext()) {
					String propKey = (String) iter.next();
					String propVal = propMap.get(propKey);
					Name propNm = soapFactory.createName(propKey, prop.getProperty("nameSpace1"),
							prop.getProperty("nameSpaceUri1"));
					SOAPElement propEle = paramEle.addChildElement(propNm);
					propEle.addTextNode(propVal);
				}

				message.writeTo(System.out);

				URL endpoint = new URL(prop.getProperty("wsdlUrl"));
				SOAPMessage response = connection.call(message, endpoint);

				ByteArrayOutputStream out = new ByteArrayOutputStream();
				response.writeTo(out);
				String strMsgResponse = new String(out.toByteArray(), "ISO-8859-1");
				Matcher m = Pattern
						.compile(Pattern.quote("<swa:fileName xmlns:swa=\"http://provider.ws.jts.omni.newgen.com\">")
								+ "(.*?)" + Pattern.quote("</swa:fileName>"))
						.matcher(strMsgResponse);
				String match = "";
				while (m.find()) {
					match = m.group(0);
				}

				DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = dfactory.newDocumentBuilder();
				Document doc = builder.parse(new InputSource(new StringReader(match)));
				NodeList user = doc.getElementsByTagName("*");

				for (int i = 1; i < user.getLength(); i++) {
					Node child = user.item(i);
					jsonObject.put(child.getNodeName(), child.getTextContent());

				}

				if (jsonObject.getString("swa:message").equalsIgnoreCase("file download on server successfully")) {

					Pattern p = Pattern.compile("Content-ID: <urn:.*>");
					Matcher matcher = p.matcher(strMsgResponse);
					int end = 0;
					System.out.println();
					while (matcher.find()) {
						System.out.println(matcher.start() + ".." + matcher.end() + ".." + matcher.group());
						end = matcher.end();
					}

					String FinalData = new String(Base64.encodeBase64(
							strMsgResponse.substring(end, strMsgResponse.length()).trim().getBytes("ISO-8859-1")));

					jsonObjectRes.put("result", "Success");
					jsonObjectRes.put("serviceResponse", FinalData);
					jsonObjectRes.put("resultCode", "000");

				} else {

					jsonObjectRes.put("result", "Failure");
					jsonObjectRes.put("serviceResponse", "OmniDoc Services Error");
					jsonObjectRes.put("resultCode", "001");

				}

			} catch (Exception e) {
				e.printStackTrace();
				try {
					jsonObjectRes.put("result", "Failure");
					jsonObjectRes.put("serviceResponse", e.getMessage());
					jsonObjectRes.put("resultCode", "001");
				} catch (JSONException ex) {
					ex.printStackTrace();
				}

			} finally {

				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {

			jsonObjectRes.put("result", "Failure");
			jsonObjectRes.put("resultCode", "301");
			jsonObjectRes.put("serviceResponse", e.getMessage());

		}
		System.out.println("JsonRespose:-" + jsonObjectRes);
		return jsonObjectRes;
	}

	public static void main(String[] args) throws JSONException, FileNotFoundException, IOException {
		JSONObject jsonInput = new JSONObject();
		jsonInput.put("cabinetName", "abhi_uat");
		jsonInput.put("volumeId", "1");
		// jsonInput.put("fileName", "COI_GHI_CS-0000000191-01.pdf");
		jsonInput.put("siteId", "1");
		jsonInput.put("docIndex", "980");
		DownloadFile df = new DownloadFile();
		JSONObject jsonOutPut = df.download(jsonInput.toString());

		String data1 = jsonOutPut.get("serviceResponse").toString();
		byte[] data = Base64.decodeBase64(data1.trim().getBytes("ISO-8859-1"));
		try (OutputStream stream = new FileOutputStream("abc.txt")) {
			stream.write(data);
		}
	}

}
