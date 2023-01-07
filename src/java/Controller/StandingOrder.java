package Controller;

import Models.StandingOrderModel;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "StandingOrder", urlPatterns = {"/StandingOrder"})
public class StandingOrder extends PageBase{
    
    String  username;
    StandingOrderModel som;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
             super.doGet(request, response);
        
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/StandingOrder.jsp");
            requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
             
                
            HttpSession session = request.getSession();
            username = session.getAttribute("username").toString();
            
            
            
             String paymentType= request.getParameter("paymentType");
             String paymentDate= request.getParameter("paymentDate");
             float stdamount=Float.parseFloat(request.getParameter("stdamount"));
             String amount = getAmount(username);
             float f = Float.parseFloat(amount);
             float updatedAmount= f - stdamount;
             String clientFname= username;
             som = new StandingOrderModel(paymentType,paymentDate,stdamount,username);
             boolean chk=standingInfo(som,clientFname);
           
            if(chk==true)
            {
                response.sendRedirect("AccountSummary");
            }else
            {
                response.sendRedirect("StandingOrder");
            }
            } 


    



    public boolean standingInfo (StandingOrderModel som, String clientFname)
    {
            boolean fleg = false;
          Statement statement;
          ResultSet rs;
          String getPaymentType=som.getPaymentType();
          String getPaymentDate=som.getPaymentDate();
          float s=som.getStdamount();
          String ss = Float.toString(s);
        
          
          String sql = "INSERT INTO StandingOrder(paymentType,paymentDate,amount, clientFname) VALUES ('" + getPaymentType+ "','" + getPaymentDate + "','" + ss + "','" + clientFname +"');" ;
                  try 
                  {
               statement = connection.createStatement();
                if((statement.executeUpdate(sql))>0)
                {
                fleg = true;
            }
          } 
          catch(SQLException e)
          {
             e.printStackTrace();
          }
          return fleg;
    }
    
    public String getAmount(String username){

          Statement statement;
          ResultSet rs;
          String amm="no value";
          String sql = "SELECT amount FROM Accounts WHERE clientFname = '" + username + "'";
          
          try {
               statement = connection.createStatement();
               rs=statement.executeQuery(sql);
               
               while(rs.next()){
                amm=rs.getString("amount");
               }
          } 
          catch(SQLException e)
          {
             e.printStackTrace();
          }
          return amm;
    }
     public boolean transferReducable(int username, float updatedAmount){
        boolean flag = false;
        
        String sql = "UPDATE Accounts SET amount = '"+ updatedAmount +"' WHERE clientFname = '"+ username +"'";
        
         try{
            stmt = connection.createStatement();
            if(stmt.executeUpdate(sql)>0){
                flag = true;
            }
        }catch (SQLException ex){
            
        }
                
        return flag;
    }


} 