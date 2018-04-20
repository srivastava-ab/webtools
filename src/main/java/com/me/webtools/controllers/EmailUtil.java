package com.me.webtools.controllers;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class EmailUtil {

	
	public void email() {
	    String smtpHost = "smtp.gmail.com"; //replace this with a valid host
	    int smtpPort = 587; //replace this with a valid port
   	    final  String password ="2halfblood";
	    
	    final String sender = "grtabhinav@gmail.com"; //replace this with a valid sender email address
	    String recipient = "23abhinavs@gmail.com"; //replace this with a valid recipient email address
	    String content = "dummy content"; //this will be the text of the email
	    String subject = "dummy subject"; //this will be the subject of the email

	    Properties properties = new Properties();
/*	    properties.put("mail.smtp.host", smtpHost);
	    properties.put("mail.smtp.port", 465); 
	    properties.put("mail.smtp.port", "465");  
	    properties.put("mail.debug", "true");  
	    properties.put("mail.smtp.socketFactory.port", "465"); 
	    */
	    properties.setProperty("mail.transport.protocol", "smtp");     
	    properties.setProperty("mail.host", "smtp.gmail.com");  
	    properties.put("mail.smtp.auth", "true");  
	    properties.put("mail.smtp.port", "465");  
	    properties.put("mail.debug", "true");  
	    properties.put("mail.smtp.socketFactory.port", "465");  
	    properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	    properties.put("mail.smtp.socketFactory.fallback", "false");  
	    
	    
	    Session session = Session.getDefaultInstance(properties,  
	    	    new javax.mail.Authenticator() {
	    	       protected PasswordAuthentication getPasswordAuthentication() {  
	    	       return new PasswordAuthentication(sender,password);  
	    	   }  
	    	   });

	    ByteArrayOutputStream outputStream = null;

	    try {           
	        //construct the text body part
	        MimeBodyPart textBodyPart = new MimeBodyPart();
	        textBodyPart.setText(content);

	        //now write the PDF content to the output stream
	        outputStream = new ByteArrayOutputStream();
	        writePdf(outputStream);
	        byte[] bytes = outputStream.toByteArray();

	        //construct the pdf body part
	        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
	        MimeBodyPart pdfBodyPart = new MimeBodyPart();
	        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
	        pdfBodyPart.setFileName("test.pdf");

	        //construct the mime multi part
	        MimeMultipart mimeMultipart = new MimeMultipart();
	        mimeMultipart.addBodyPart(textBodyPart);
	        mimeMultipart.addBodyPart(pdfBodyPart);

	        //create the sender/recipient addresses
	        InternetAddress iaSender = new InternetAddress(sender);
	        InternetAddress iaRecipient = new InternetAddress(recipient);

	        //construct the mime message
	        MimeMessage mimeMessage = new MimeMessage(session);
	        mimeMessage.setSender(iaSender);
	        mimeMessage.setSubject(subject);
	        mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
	        mimeMessage.setContent(mimeMultipart);

	        //send off the email
	        Transport.send(mimeMessage);

	        System.out.println("sent from " + sender + 
	                ", to " + recipient + 
	                "; server = " + smtpHost + ", port = " + smtpPort);         
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        //clean off
	        if(null != outputStream) {
	            try { outputStream.close(); outputStream = null; }
	            catch(Exception ex) { }
	        }
	    }
	}
	
	
	
	public void writePdf(OutputStream outputStream) throws Exception {
	    Document document = new Document();
	    PdfWriter.getInstance(document, outputStream);
	    document.open();
	    Paragraph paragraph = new Paragraph();
	    paragraph.add(new Chunk("hello!"));
	    document.add(paragraph);
	    document.close();
	}
	
}
