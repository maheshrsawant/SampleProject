package com.Utility;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import com.Utility.DBConnectionNew;


@Test
public class ReadXml {
	
	public static DBConnectionNew connection;
	

	
	public static String value;
	

	static Connection con;
	
	public static int j=0;

public static String readXML(String nodeList,String tag) {
	



      try {
    	  //FileName
         File inputFile = new File(System.getProperty("user.dir")+"/input.xml/");
         
         
         //Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents.THis is an abstract class
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         
         doc.getDocumentElement().normalize();
        
         NodeList nList = doc.getElementsByTagName(nodeList);
      
      
         NodeList nodes = doc.getElementsByTagName(tag);
         
         
         System.out.println("----------------------------");
        
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
        	
        	 
        	 NodeList subList = nList.item(0).getChildNodes();
        	 
        	

            Node nNode = nList.item(temp);

         
            Element eElement = (Element) nNode;
            //Length/child nodes of xml
            connection.length=eElement.getElementsByTagName(tag).getLength();
           
            if(tag.equals("Query"))
            {
            
            for(j=0;j<connection.length;j++)
            {
            
                  
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement1 = (Element) nNode;
               
           
               connection.arr[j]=(eElement1.getElementsByTagName(tag).item(j).getTextContent()).toString();  
                
                System.out.println("xml value : "  + eElement1.getElementsByTagName(tag).item(j).getTextContent());
               
           
            }
            }
         }
            else
            {
            	 if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                     Element eElement1 = (Element) nNode;
                     
                 
                     value=eElement1.getElementsByTagName(tag).item(0).getTextContent();
                      
                     System.out.println("xml value : "  + eElement1.getElementsByTagName(tag).item(0).getTextContent());

                     
                 
                  }
            }
         }
      }
        
       catch (Exception e) {
         e.printStackTrace();
      }
  
   
    return value;
	
   }


public static String readTestNG(String nodeList,String tag) {
	



    try {
  	  //FileName
       File inputFile = new File(System.getProperty("user.dir")+"/testng.xml/");
       
       //Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents.THis is an abstract class
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(inputFile);
       
       doc.getDocumentElement().normalize();
      
       NodeList nList = doc.getElementsByTagName(nodeList);
    
       NodeList nodes = doc.getElementsByTagName(tag);
      
       
       for (int temp = 0; temp < nList.getLength(); temp++) {
      	
      	 
      	 NodeList subList = nList.item(0).getChildNodes();
      	 
      	

          Node nNode = nList.item(temp);

       
          Element eElement = (Element) nNode;
          //Length/child nodes of xml
          connection.length=eElement.getElementsByTagName(tag).getLength();
         
          if(tag.equals("Value"))
          {
          
          for(j=0;j<connection.length;j++)
          {
          
                
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement1 = (Element) nNode;
             
              value=eElement1.getElementsByTagName(tag).item(j).getTextContent();
              System.out.println("xml value : " + value);
             
         
          }
          }
       }
       }
    }
      
     catch (Exception e) {
       e.printStackTrace();
    }
  return value;
}

    
   
}
