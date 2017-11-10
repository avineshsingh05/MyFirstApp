package com.login;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class AuthenticLogin extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		@SuppressWarnings("unused")
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		if (uname!=null) {
			request.getSession().setAttribute("uname1", uname);	
		}
		
		String pass=request.getParameter("pass");
		boolean userExist=doesUserExist(uname,pass);
		
		if(userExist)
		{
			response.sendRedirect("Welcomemessage.jsp");
		}
		else
		{
			response.sendRedirect("Incorrect.jsp");
		}
		
	  

	    }

	//private static void showExcelData(data sheetData) {
		  
		private boolean doesUserExist(String uname, String pass) throws IOException {
			String excelFilePath = "C:\\AuthenticationData\\Logindocument.xlsx";
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	         
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	        ArrayList<String> userName=new ArrayList<String>();
	        ArrayList<String> password=new ArrayList<String>();
	        int itr=0;
	        while (iterator.hasNext()) {
	        	
	            Row nextRow = iterator.next();
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	                        
	            int column=0;
	            while (cellIterator.hasNext()) {
	            	Cell cell = cellIterator.next();
	            	
	                if(itr==0)
	                {
	                	continue;
	                }
	                else
	                {
	                	if(column==0)
	                	{
	                		userName.add(String.valueOf((int)cell.getNumericCellValue()).trim());
	                		column=1;
	                	}
	                	else {
	                		
							password.add((String)cell.getStringCellValue().trim());
								
						}
	                }
	                     

	            }
	            
	            itr++;
	            
	        }
	      
	        
	         
	        workbook.close();
	        inputStream.close();
	        System.out.println(userName);
	        System.out.println(password);
			if(userName.contains(uname) && password.contains(pass))
			{
				return true;
			}
		    
		return false;
	}
}