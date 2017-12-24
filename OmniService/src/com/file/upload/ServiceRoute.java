package com.file.upload;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

@Path("")
public class ServiceRoute {

	@POST
	@Path("/FileUpload")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String docsFileUpload(String jsonInput) {
		JSONObject object = new JSONObject();
		System.out.println("ServiceRoute.docsFileUpload() " + jsonInput);
		try {

			JSONObject jsonInputObj = new JSONObject(jsonInput);

			UploadFile file = new UploadFile();
			object = file.fileUpload(jsonInputObj);

		} catch (Exception e) {
			try {
				object.put("result", "-1");
				object.put("soapenv:Envelope", e.getMessage());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		return object.toString();

	}

	@POST
	@Path("/FileDownload")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String docsFileDownload(String jsonInput) {

		System.out.println("ServiceRoute.docsFileUpload() " + jsonInput);
		JSONObject jsonObjResp = null;
		try {

			DownloadFile file = new DownloadFile();
			jsonObjResp = file.download(jsonInput);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjResp.toString();

	}

}
