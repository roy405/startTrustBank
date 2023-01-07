package Controller;

import Models.MessageAdminModel;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MessageAdmin", urlPatterns = {"/MessageAdmin"})
public class MessageAdmin extends PageBase {

    String username;
 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        super.doGet(request, response);
        HttpSession session = request.getSession();
        username = (String) session.getAttribute("username");
        List <MessageAdminModel> list2;
        list2=getm(username);
         
         
                session = request.getSession(true);
                session.setMaxInactiveInterval(1000);
                session.setAttribute("ListM", list2);
               
        
        
        
        RequestDispatcher RequestDispatcherObj =request.getRequestDispatcher("/AdminInbox.jsp");
        RequestDispatcherObj.forward(request, response);
        
        
    }
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
            }



public List<MessageAdminModel> getm(String username){

        MessageAdminModel mam = new MessageAdminModel();
        Statement  statement;
        ResultSet rs ;
        List <MessageAdminModel> list1=new ArrayList<MessageAdminModel>();  
        
        try{ 
            
           String sql = "SELECT * FROM Message WHERE receiver='" +username+ "'";
           statement = connection.createStatement();
            
           rs = statement.executeQuery(sql);

           while(rs.next()){ 
              
                
        mam.setEmail(rs.getString("email"));
        mam.setReceiver(rs.getString("receiver"));
        mam.setMsubject(rs.getString("msubject"));
        mam.setMessage(rs.getString("message"));
        mam.setBankUserName(rs.getString("BankUserName"));

                list1.add(mam);
           }  
             connection.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list1;  

 

}

}