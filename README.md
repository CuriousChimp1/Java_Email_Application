# Email Application using JSP and Servlets  
#### Develop an email system to send emails using Java servlet technology.

## Software Platforms & Development tools
Programming Language : Java, JSP, CSS(Bootstrap)  
Development IDE : Intellij Idea Ultimate Edition  
Project Management Tool : Apache Maven  
Server : Apache Tomcat 

## Working of code by various files and classes
Index.jsp - For front end designing of our application  
MailClt.java - Is a Servlet which fetches the values from Index.jsp and sets the value to EmailMessage.java  
EmailMessage.java - Contains of getters and setters for required mail format  
EmailUtility.java :    
- Start a session  
- Create MIME message object using the session created  
- Use the methods of MIMEMessage to set the values in required format  
-  Finally call Transport.send(msg) to send the mail 