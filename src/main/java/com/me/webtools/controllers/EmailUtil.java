package com.me.webtools.controllers;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
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
import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.me.webtools.dao.UserDaoImpl;
import com.me.webtools.pojo.Job;

public class EmailUtil {

	public void email(HttpServletRequest req, final String sender, final String password, final String recipient) {
		String smtpHost = "smtp.gmail.com"; // replace this with a valid host
		int smtpPort = 587; // replace this with a valid port
		// final String password ="*********";

		// final String sender = "grtabhinav@gmail.com"; //replace this with a
		// valid sender email address
		// String recipient = "23abhinavs@gmail.com"; //replace this with a
		// valid recipient email address
		String content = "dummy content"; // this will be the text of the email
		String subject = "dummy subject"; // this will be the subject of the
											// email

		Properties properties = new Properties();

		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.host", "smtp.gmail.com");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.debug", "true");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, password);
			}
		});

		ByteArrayOutputStream outputStream = null;

		try {
			// construct the text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(content);

			// now write the PDF content to the output stream
			outputStream = new ByteArrayOutputStream();
			writePdf(req,outputStream);
			byte[] bytes = outputStream.toByteArray();

			// construct the pdf body part
			DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
			MimeBodyPart pdfBodyPart = new MimeBodyPart();
			pdfBodyPart.setDataHandler(new DataHandler(dataSource));
			pdfBodyPart.setFileName("test.pdf");

			// construct the mime multi part
			MimeMultipart mimeMultipart = new MimeMultipart();
			mimeMultipart.addBodyPart(textBodyPart);
			mimeMultipart.addBodyPart(pdfBodyPart);

			// create the sender/recipient addresses
			InternetAddress iaSender = new InternetAddress(sender);
			InternetAddress iaRecipient = new InternetAddress(recipient);

			// construct the mime message
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setSender(iaSender);
			mimeMessage.setSubject(subject);
			mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
			mimeMessage.setContent(mimeMultipart);

			// send off the email
			Transport.send(mimeMessage);

			System.out.println(
					"sent from " + sender + ", to " + recipient + "; server = " + smtpHost + ", port = " + smtpPort);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// clean off
			if (null != outputStream) {
				try {
					outputStream.close();
					outputStream = null;
				} catch (Exception ex) {
				}
			}
		}
	}

	public void writePdf(HttpServletRequest req, OutputStream outputStream) throws Exception {
		Document document = new Document();
		UserDaoImpl daoImpl = new UserDaoImpl();
		String jobID = (String) req.getSession().getAttribute("jobID");

		Job job = daoImpl.getJobByID(Integer.valueOf(jobID));
		PdfWriter.getInstance(document, outputStream);

		PdfPTable table = new PdfPTable(7);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell("Task ID");
		table.addCell("Task Description");
		table.addCell("Task Status");
		table.addCell("Task Raised on");

		table.addCell("Task Start Date");
		table.addCell("Task Compltetion Date");
		table.addCell("Task Complteted by");

		table.setHeaderRows(1);
		PdfPCell[] cells = table.getRow(0).getCells();
		for (int j = 0; j < cells.length; j++) {
			cells[j].setBackgroundColor(BaseColor.PINK);
		}
		for (int i = 1; i < 2; i++) {
			table.addCell(String.valueOf(job.getJobID()));
			table.addCell(job.getJobDetails());
			table.addCell(job.getJobStatus().toUpperCase().toString());
			table.addCell(job.getJobRaisedDate().toString());
			table.addCell(job.getJobProcessingStartDate().toString());
			table.addCell(job.getJobProcessingEndDate().toString());
			table.addCell(job.getJobProcessedBy());
		}
		//PdfWriter.getInstance(document, new FileOutputStream("C://users//grtab//Onedrive//Desktop//AAAA.pdf"));
		document.open();
		Paragraph paragraph = new Paragraph();
		paragraph.add(new Chunk("hello " + job.getJobRaisedBy() + ", below is the job details!!!"));

		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);
		document.add(table);
		document.close();
		System.out.println("Done");
	}

}
