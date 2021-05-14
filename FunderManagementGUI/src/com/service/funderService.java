package com.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.model.funder;



@Path("/Funders")

public class funderService {
	
	
	
	funder funder_ob = new funder(); 
	
	
	//Reading the funder details
	
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String viewFunders() {
	 return funder_ob.viewFunders();
	 } 
	
	
	
	//Inserting funder details
	
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertFunders(@FormParam("funderCode") String funderCode,
			 @FormParam("funderName") String funderName, 
			 @FormParam("funderAddress") String funderAddress, 
			 @FormParam("funderTel") String funderTel,
			 @FormParam("funderEmail") String funderEmail, 
			 @FormParam("funderGender") String funderGender,
			 @FormParam("funderFund") String funderFund, 
			 @FormParam("funderTime") String funderTime, 
			 @FormParam("funderDes") String funderDes)
			
			  
	{ 
		String output = funder_ob.insertFunders(funderCode,funderName,funderAddress,funderTel,funderEmail,funderGender,funderFund,funderTime,funderDes); 
		return output; 
	}
	
	
	
	
	//Deleting funder details
	
		
		@DELETE
		@Path("/") 
		@Consumes(MediaType.APPLICATION_XML) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String deleteFunders(String funderData) 
		{ 
			//Convert the input string to an XML document
			Document doc = Jsoup.parse(funderData, "", Parser.xmlParser()); 
		 
			//Read the value from the element <productID>
			String funderID = doc.select("funderID").text(); 
			String output = funder_ob.deleteFunders(funderID); 
			return output; 
		}
	
		
		
		//Updating funder details
		
		
		@PUT
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String updateFunders(String funderData) 
		{ 
			//Convert the input string to a JSON object 
			JsonObject funderObject = new JsonParser().parse(funderData).getAsJsonObject(); 
			
			//Read the values from the JSON object
			String funderID = funderObject.get("funderID").getAsString();
			String funderCode = funderObject.get("funderCode").getAsString(); 
			String funderName = funderObject.get("funderName").getAsString(); 
			String funderAddress = funderObject.get("funderAddress").getAsString(); 
			String funderTel = funderObject.get("funderTel").getAsString(); 
			String funderEmail = funderObject.get("funderEmail").getAsString();
			String funderGender = funderObject.get("funderGender").getAsString();
			String funderFund = funderObject.get("funderFund").getAsString();
			String funderTime = funderObject.get("funderTime").getAsString();
			String funderDes = funderObject.get("funderDes").getAsString();
			
			
			String output = funder_ob.updateFunders(funderID,funderCode,funderName,funderAddress,funderTel,funderEmail,funderGender,funderFund,funderTime,funderDes); 
		
			return output; 
		}

}
	
	
	


