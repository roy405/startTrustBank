
package Controller;

import Models.MessageManagerModel;
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

@WebServlet(name = "MessageManager", urlPatterns = {"/MessageManager"})
public class MessageManager extends PageBase {

    String username;
 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        super.doGet(request, response);
        HttpSession session = request.getSession();
        username = (String) session.getAttribute("username");
        List <MessageManagerModel> list2;
        list2=getm(username);
         
         
                session = request.getSession(true);
                session.setMaxInactiveInterval(1000);
                session.setAttribute("ListO", list2);
               
        
        
        
        RequestDispatcher RequestDispatcherObj =request.getRequestDispatcher("/ManagerMessage.jsp");
        RequestDispatcherObj.forward(request, response);
        
        
    }
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
            }



public List<MessageManagerModel> getm(String username){

        Statement  statement;
        ResultSet rs ;
        List <MessageManagerModel> list1 = new ArrayList<>();  
        
        try{ 
            
           String sql = "SELECT * FROM Message WHERE receiver='" +username+ "'";
           statement = connection.createStatement();
            
           rs = statement.executeQuery(sql);

           while(rs.next()){
                MessageManagerModel mmm = new MessageManagerModel();
                mmm.setEmail(rs.getString("email"));
                mmm.setReceiver(rs.getString("receiver"));
                mmm.setMsubject(rs.getString("msubject"));
                mmm.setMessage(rs.getString("message"));
                mmm.setBankUserName(rs.getString("BankUserName"));
                list1.add(mmm);
           }  
             connection.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list1;  

 

}

}