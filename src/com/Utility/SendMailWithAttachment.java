package com.Utility;
 
import java.util.Properties;
 
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import com.PageFactory.ElementFactory;
import com.Utility.ReadExcel;

public class SendMailWithAttachment {
	protected static ConfigReader config = new ConfigReader();
	
	static String from = ReadExcel.getData(ElementFactory.LoginEmail, 1, 1);
	static String host = ReadExcel.getData(ElementFactory.LoginEmail, 1, 0);
	static String to = ReadExcel.getData(ElementFactory.LoginEmail, 1, 2);
	static String cc = ReadExcel.getData(ElementFactory.LoginEmail, 1, 5);
	static String setText = ReadExcel.getData(ElementFactory.LoginEmail, 1, 3);
	static String fileName1 = System.getProperty("user.dir")+ReadExcel.getData(ElementFactory.LoginEmail, 1, 4);
	static String fileName2 = System.getProperty("user.dir")+ReadExcel.getData(ElementFactory.LoginEmail, 1, 6);
	static String fileName3 = System.getProperty("user.dir")+ReadExcel.getData(ElementFactory.LoginEmail, 1, 8);
	static String fileName4 = System.getProperty("user.dir")+ReadExcel.getData(ElementFactory.LoginEmail, 1, 9);
	static String subject1 = ReadExcel.getData(ElementFactory.LoginEmail, 1, 7);
	static String subject;
	public static String testType;
	
	public static void email() {
		System.out.println("=== Email Details ===");
		System.out.println("TO: "+to);
		System.out.println("CC: "+cc);
		System.out.println("Mail Body: "+setText);
		System.out.println("Attachment1: "+fileName1);
		System.out.println("Attachment2: "+fileName2);
		System.out.println("Attachment3: "+fileName3);
		System.out.println("Attachment4: "+fileName4);
		System.out.println("From: "+from);
		System.out.println("Host: "+host);
		//testType  = ReadXml.readTestNG("TestingType", "Value");
		if(Listener.flag==0)
			testType =config.getTestingType();
		if(Listener.flag==1)
			testType ="Sanity";
		System.out.println("Testing Type: "+testType);

		if(config.getAppUrl().contains("ciostage"))
   	 {
   		subject = "STAGE : "+testType+" "+subject1+" - "+ReadExcel.reportStatus;
   	 }
		
  	 if(config.getAppUrl().contains("ciodev"))
   	 {
  		subject = "DEV : "+testType+" "+subject1+" - "+ReadExcel.reportStatus;
   	 }
  	 
  	 if(config.getAppUrl().contains("ciotest"))
   	 {
  		subject = "TEST : "+testType+" "+subject1+" - "+ReadExcel.reportStatus;
   	 }
		System.out.println("Mail Subject: "+subject);
	
		
		System.out.println("=====Started Emailling Report ======");
		//Get the session object  
		Properties properties = System.getProperties();  
		properties.setProperty("mail.smtp.host", host);  
		Session session = Session.getDefaultInstance(properties);  
		
			// Create object of MimeMessage class
		try{  
			Message message = new MimeMessage(session);
			// Set the from address
			message.setFrom(new InternetAddress(from));
			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			// Set the recipient CC address
			message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(cc));
            // Add the subject link
			message.setSubject(subject);
 
			
			// create MimeBodyPart object and set your message text     
			BodyPart messageBodyPart1 = new MimeBodyPart();  
			
		 	// Set the body of email
			messageBodyPart1.setText(setText);

			// Mention the file which you want to send
			String filename = fileName1;
			String filename1 = fileName2;
			String filename2 = fileName3;
			String filename3 = fileName4;
		
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
					
			//adding the attachment 
			addAttachment(multipart,filename,"emailable-report.html");
			addAttachment(multipart,filename1,"ExtendReport.html");
			addAttachment(multipart,filename2,"Check-in History.html");
			addAttachment(multipart,filename3,"ExcelReport.xlsx");
			// add body part 1
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);
 
			// finally send the email
			Transport.send(message);
			

			
			System.out.println("=====Email Sent With Attachment======");
		}catch  (MessagingException e) {e.printStackTrace();}  
 
		
	}
 
   private static void addAttachment(Multipart multipart, String filename,String name) throws MessagingException
   
   {
	
	   DataSource source = new FileDataSource(filename);

	   // Create object to add multimedia type content
 	
	   BodyPart messageBodyPart1 = new MimeBodyPart();

	   // set the handler
	
       messageBodyPart1.setDataHandler(new DataHandler(source));
    
       //set the filename
    
       messageBodyPart1.setFileName(name);
    
       // add Body part
      
       multipart.addBodyPart(messageBodyPart1);
   	}
}