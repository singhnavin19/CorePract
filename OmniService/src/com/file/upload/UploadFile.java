package com.file.upload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.xml.soap.AttachmentPart;
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

import org.apache.axiom.attachments.ByteArrayDataSource;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class UploadFile {

	public JSONObject fileUpload(JSONObject jsonObjectInput) {

		JSONObject jsonObject = new JSONObject();

		SOAPConnection connection = null;
		InputStream input = null;
		Properties prop = new Properties();

		try {

			input = DownloadFile.class.getClassLoader().getResourceAsStream("com/file/upload/omniservice.properties");
			if (input != null) {
				prop = new Properties();
				prop.load(input);
			} else {
				jsonObject.put("result", "-1");
				jsonObject.put("soapenv:Envelope", "Error while reading Java config file");
			}
			if (!jsonObjectInput.has("fileName")) {
				throw new Exception("fileName is mandatory.");

			}
			if (!jsonObjectInput.has("cabinetName")) {
				throw new Exception("cabinetName is mandatory.");

			}
			if (!jsonObjectInput.has("userPassword")) {
				throw new Exception("userPassword is mandatory.");

			}
			if (!jsonObjectInput.has("indexType11")) {
				throw new Exception("indexType11 is mandatory.");

			}
			if (!jsonObjectInput.has("fileByteStream")) {
				throw new Exception("fileByteStream is mandatory.");

			}
			if (!jsonObjectInput.has("folderIndex")) {
				throw new Exception("folderIndex is mandatory.");

			}
			if (!jsonObjectInput.has("userName")) {
				throw new Exception("userName is mandatory.");

			}
			if (!jsonObjectInput.has("indexId11")) {
				throw new Exception("indexId11 is mandatory.");

			}
			if (!jsonObjectInput.has("volumeId")) {
				throw new Exception("volumeId is mandatory.");

			}
			if (!jsonObjectInput.has("indexValue11")) {
				throw new Exception("indexValue11 is mandatory.");

			}

			try {

				HashMap<String, String> propMap = new HashMap<String, String>();
				propMap.put("jtsAddress", prop.getProperty("jtsAddress"));
				propMap.put("portId", prop.getProperty("portId"));
				propMap.put("cabinetName", jsonObjectInput.getString("cabinetName"));
				propMap.put("volumeId", jsonObjectInput.getString("volumeId"));
				propMap.put("folderIndex", jsonObjectInput.getString("folderIndex"));
				propMap.put("userName", jsonObjectInput.getString("userName"));
				propMap.put("userPassword", jsonObjectInput.getString("userPassword"));

				String nameSpace1 = prop.getProperty("nameSpace1");
				String nameSpaceUri1 = prop.getProperty("nameSpaceUri1");
				String nameSpace2 = prop.getProperty("nameSpace2");
				String nameSpaceUri2 = prop.getProperty("nameSpaceUri2");

				SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
				connection = soapConnectionFactory.createConnection();
				SOAPFactory soapFactory = SOAPFactory.newInstance();

				MessageFactory factory = MessageFactory.newInstance();
				SOAPMessage message = factory.createMessage();
				SOAPHeader header = message.getSOAPHeader();
				SOAPBody body = message.getSOAPBody();
				header.detachNode();

				Name bodyName = soapFactory.createName("addDocument_Ext", nameSpace1, nameSpaceUri1);
				SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
				bodyElement.addNamespaceDeclaration(nameSpace2, nameSpaceUri2);

				Name paramName = soapFactory.createName("param0", nameSpace1, nameSpaceUri1);
				SOAPElement paramEle = bodyElement.addChildElement(paramName);

				Name name = soapFactory.createName("name", nameSpace1, nameSpaceUri1);
				SOAPElement symbol = paramEle.addChildElement(name);
				symbol.addTextNode(jsonObjectInput.getString("fileName"));

				Iterator<String> iter = propMap.keySet().iterator();
				while (iter.hasNext()) {
					String propKey = iter.next();
					String propVal = propMap.get(propKey);
					Name propNm = soapFactory.createName(propKey, nameSpace1, nameSpaceUri1);
					SOAPElement propEle = paramEle.addChildElement(propNm);
					propEle.addTextNode(propVal);
				}

				Name dataDefCriName = soapFactory.createName("dataDefCriterionBDO", nameSpace1, nameSpaceUri1);
				SOAPElement dataDefCriEle = paramEle.addChildElement(dataDefCriName);

				Name dataDefCriArrNm1 = soapFactory.createName("dataDefCriteriaArr", nameSpace2, nameSpaceUri2);
				SOAPElement dataDefCriArrEle1 = dataDefCriEle.addChildElement(dataDefCriArrNm1);

				Name indexIdNm1 = soapFactory.createName("indexId", nameSpace2, nameSpaceUri2);
				SOAPElement indexIsEle1 = dataDefCriArrEle1.addChildElement(indexIdNm1);
				indexIsEle1.addTextNode(jsonObjectInput.getString("indexId11"));

				Name indexTypeNm1 = soapFactory.createName("indexType", nameSpace2, nameSpaceUri2);
				SOAPElement indexTypeEle1 = dataDefCriArrEle1.addChildElement(indexTypeNm1);
				indexTypeEle1.addTextNode(jsonObjectInput.getString("indexType11"));

				Name indexValueNm1 = soapFactory.createName("indexValue", nameSpace2, nameSpaceUri2);
				SOAPElement indexValueEle1 = dataDefCriArrEle1.addChildElement(indexValueNm1);
				indexValueEle1.addTextNode(jsonObjectInput.getString("indexValue11"));

				ByteArrayDataSource rawData = new ByteArrayDataSource(
						Base64.decodeBase64(jsonObjectInput.getString("fileByteStream").getBytes()));
				DataHandler dataHandler = new DataHandler(rawData);

				AttachmentPart attachment = message.createAttachmentPart(dataHandler);
				attachment.setContentId("CLICK_PSS");
				message.addAttachmentPart(attachment);

				System.out.println("Generated SOAP Message :: \n");
				URL endpoint = new URL(prop.getProperty("wsdlUrl"));
				message.saveChanges();
				message.writeTo(System.out);

				try {
					SOAPMessage response = connection.call(message, endpoint);
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					response.writeTo(out);
					String strMsgResponse = new String(out.toByteArray(), "ISO-8859-1");
					jsonObject = XML.toJSONObject(strMsgResponse);
					jsonObject.put("result", "0");
					System.out.println(jsonObject);
					out.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
				try {
					jsonObject.put("result", "-1");
					jsonObject.put("soapenv:Envelope", e.getMessage());
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
			try {
				jsonObject.put("result", "-1");
				jsonObject.put("soapenv:Envelope", e.getMessage());
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		System.out.println("Response:-" + jsonObject);
		return jsonObject;
	}

	public static void main(String[] args) throws Exception {
		UploadFile fileUpload = new UploadFile();
		File file = new File("E:\\abc.pdf");
		byte[] bytesArray = new byte[(int) file.length()];

		// read file into bytes[]
		FileInputStream fileInputStream = new FileInputStream(file);
		fileInputStream.read(bytesArray);
		fileInputStream.close();
		String byteStr = new String(Base64.encodeBase64(bytesArray));
		JSONObject jsonInputGetIncidentStatus = new JSONObject();
		jsonInputGetIncidentStatus.put("fileByteStream", byteStr);
		// jsonInputGetIncidentStatus.put("fileName", "Oct31.pdf");
		jsonInputGetIncidentStatus.put("cabinetName", "abhi_uat");
		// jsonInputGetIncidentStatus.put("userName", "ABHI_INTGR2");
		jsonInputGetIncidentStatus.put("userPassword", "abhi_int@123");
		jsonInputGetIncidentStatus.put("volumeId", "1");
		jsonInputGetIncidentStatus.put("folderIndex", "1797");
		jsonInputGetIncidentStatus.put("indexId11", "1");
		jsonInputGetIncidentStatus.put("indexType11", "S");
		jsonInputGetIncidentStatus.put("indexValue11", "TestCLICK");

		JSONObject out = fileUpload.fileUpload(jsonInputGetIncidentStatus);
		System.out.println(out);

	}

}
