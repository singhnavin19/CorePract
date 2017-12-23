package com.Json;

import org.json.JSONObject;

public class Xml_to_Json {

	public static void main(String[] args) throws Exception {

		JSONObject obj = new JSONObject();
		obj.put("Nname", "FName and Lname");
		obj.put("Fname", "Navin Singh");
		obj.put("Lname", "Navin Singh");

		JSONObject objparent = new JSONObject();
		objparent.put("Person", obj);

		System.out.println(obj);
		System.out.println(objparent);

	}

}
