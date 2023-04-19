package mail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/MailClt")
public class MailClt extends HttpServlet {
    public static final String OP_GO = "Send";
    //constructor
    public MailClt(){
        super();
    }
    //Get request is used to fetch data from server
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req,res);
    }
    //Post request is used to send data to a server
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String subject = req.getParameter("subject");
        String message = req.getParameter("message");

        String op = req.getParameter("operation");
        if(OP_GO.equalsIgnoreCase(op)){
            EmailMessage msg  = new EmailMessage();
            msg.setTo(email);
            msg.setSubject(subject);
            msg.setMessage(message);
            msg.setMessageType(EmailMessage.HTML_MSG);
            EmailUtility.sendMail(msg);

            req.setAttribute("msg","Mail has been sent successfully");
        }

        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req,res);
    }
}

