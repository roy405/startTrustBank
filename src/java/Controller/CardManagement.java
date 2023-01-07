
package Controller;

import Models.CardManagementModel;
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

@WebServlet(name = "CardManagement", urlPatterns = {"/CardManagement"})
public class CardManagement extends PageBase {

    String username;
 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        super.doGet(request, response);
        HttpSession session = request.getSession();
        username = (String) session.getAttribute("username");
        List <CardManagementModel> list2;
        list2=getCardInfo(username);
         
         
                session = request.getSession(true);
                session.setMaxInactiveInterval(1000);
                session.setAttribute("ListCard", list2);
               
        
        
        
        RequestDispatcher RequestDispatcherObj =request.getRequestDispatcher("/CardManagement.jsp");
        RequestDispatcherObj.forward(request, response);
        
        
    }
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
            }



public List<CardManagementModel> getCardInfo(String username){

        CardManagementModel cmm = new CardManagementModel();
        Statement  statement;
         List <CardManagementModel> list1=new ArrayList<CardManagementModel>();  
        ResultSet rs ;
        try{ 
            
           String sql = "SELECT * FROM Cards WHERE clientFname='" +username+ "'";
           statement = connection.createStatement();
            
           rs = statement.executeQuery(sql);

           while(rs.next()){ 
                cmm.setCardID(Integer.parseInt(rs.getString("cardID")));
                cmm.setCardType(rs.getString("cardType"));  
                cmm.setCardNumber(rs.getString("cardNumber"));
                cmm.setCardHolderNIC(rs.getString("cardHolderNIC"));
                cmm.setCardStatus(rs.getString("cardStatus"));
                cmm.setExpiryDate(rs.getString("expiryDate"));
                cmm.setAmountDue(Float.parseFloat(rs.getString("amountDue")));
                cmm.setClientFname(rs.getString("clientFname"));
                cmm.setCcmID(Integer.parseInt(rs.getString("ccmID")));  
                list1.add(cmm);
           }  
             connection.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list1;  

 

}

}