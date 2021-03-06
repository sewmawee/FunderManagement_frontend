package com.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/funderAPI")
public class funderAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	funder funder_ob = new funder();
       
  
    public funderAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String outputString = funder_ob.insertFunders(
				request.getParameter("funderCode"), 
				request.getParameter("funderName"),
				request.getParameter("funderAddress"), 
				request.getParameter("funderTel"),
				request.getParameter("funderEmail"),
				request.getParameter("funderGender"),
				request.getParameter("funderFund"),
				request.getParameter("funderTime"),
				request.getParameter("funderDes")
				);
		
		//funderID,funderCode,funderName,funderAddress,funderTel,funderEmail,funderGender,funderFund,funderTime,funderDes
		response.getWriter().write(outputString);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request); 
		
		String output = funder_ob.updateFunders(
			paras.get("funderID").toString(), 
			paras.get("funderCode").toString(), 
			paras.get("funderName").toString(), 
			paras.get("funderAddress").toString(), 
			paras.get("funderTel").toString(),
			paras.get("funderEmail").toString(),
			paras.get("funderGender").toString(),
			paras.get("funderFund").toString(),
			paras.get("funderTime").toString(),
			paras.get("funderDes").toString()); 
		
			response.getWriter().write(output); 
			
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		
		 String output = funder_ob.deleteFunders(paras.get("funderID").toString()); 
		 response.getWriter().write(output);
				
		
	}
	
	private static Map getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	 
	try
	 { 
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	 String queryString = scanner.hasNext() ? 
			 
	 scanner.useDelimiter("\\A").next() : ""; 
	 scanner.close();
	 
	 String[] params = queryString.split("&"); 
	 for (String param : params) 
	 { 
		 String[] p = param.split("=");
		 map.put(p[0], p[1]); 
		 } 
		 } 
		catch (Exception e) 
		 { 
			
		 } 
		return map; 
		}

	

}
