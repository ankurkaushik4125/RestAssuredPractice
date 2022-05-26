package com.qa.CommonUtil;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;


public class SendEmail {
	

	//public void SendNewMail() throws EmailException 
public static void main(String aa[]) throws EmailException 
	{
	
	
	
		String path=System.getProperty("user.dir")+"/test-output/ExtentReportsTestNG.html";
		 EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath(path);
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Test Execution Report");
		  attachment.setName("Ankur Sharma");
		 
		
		  // Create the email message
		  String email_Add="ankurkaushik4125@gmail.com";
		  String pass="Ankur@123";
		  
		  MultiPartEmail email = new MultiPartEmail();

		  email.setHostName("smtp.googlemail.com");
		  email.setSmtpPort(465);
		  email.setAuthenticator(new DefaultAuthenticator(email_Add, pass));
		  email.setSSLOnConnect(true);
		  email.setFrom("ankurkaushik4125@gmail.com", "Ankur Sharma");
		  email.addTo("ankurkaushik4125@gmail.com", "Ankur Sharma");
		
		  email.setSubject("Test Execution result");
		  email.setMsg("Here is the report you wanted");

		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();
		 
}
}


