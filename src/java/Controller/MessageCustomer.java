package Controller;


import Models.MessageCustomerModel;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MessageCustomer", urlPatterns = {"/MessageCustomer"})
public class MessageCustomer extends PageBase{
    String username;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
            super.doGet(request, response);
        
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/CustMessage.jsp");
            requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
                 HttpSession session = request.getSession();
                 username = session.getAttribute("username").toString();
                 
              
              String email = request.getParameter("email");
              String receiver = request.getParameter("receiver");
              String msubject =request.getParameter("msubject");
              String message=request.getParameter("message");
              String BankUserName=username;
              
            
            MessageCustomerModel mcm = new MessageCustomerModel(email, receiver, msubject, message, BankUserName);
            
            if(addAccount(mcm)==true){
                response.sendRedirect("AccountSummary");
            }else{
                response.sendRedirect("OpenAccount");
            }
    }

    public boolean addAccount(MessageCustomerModel mcm){
        boolean flag = false;
        Statement statement;
  
     String sql = "INSERT INTO Message(email,receiver,msubject, message) VALUES ('" + mcm.getEmail()+ "','" + mcm.getReceiver() + "','" + mcm.getMsubject() + "','" + mcm.getMessage() + "');" ;
                  try 
                  {
               statement = connection.createStatement();
                if((statement.executeUpdate(sql))>0)
                {
                flag = true;
            }
          } 
          catch(SQLException e)
          {
             e.printStackTrace();
          }
          return flag;
}
    

}