
package Controller;

import Models.BillPaymentsModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "BillPayments", urlPatterns = {"/BillPayments"})
public class BillPayments extends PageBase {
   String username;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         super.doGet(request, response);
         
        RequestDispatcher RequestDispatcherObj =request.getRequestDispatcher("/BillPayments.jsp");
        RequestDispatcherObj.forward(request, response);
    
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
            HttpSession session = request.getSession();
            username = session.getAttribute("username").toString();
            
            
              int accID = getAccID(username);
              String BillType = request.getParameter("BillType");
              String CompanyName = request.getParameter("CompanyName");
              String BillAccountID = request.getParameter("BillAcccountID");
              float amount=getAmount(accID);
              float billAmount=Float.parseFloat(request.getParameter("billAmount"));
              float updatedAmount= amount - billAmount;
          
                          
           BillPaymentsModel bpm = new BillPaymentsModel(accID, BillType, CompanyName, BillAccountID, amount, billAmount, updatedAmount);
            
            if(billAmountDeduction(bpm.getAccID(), bpm.getUpdatedAmount())){
                response.sendRedirect("AccountSummary");
            }else{
                response.sendRedirect("FundTransfer");
            }
            }
        
    
  public boolean billAmountDeduction(int accID, float updatedAmount){
        boolean flag = false;
        
        Statement statement;
        ResultSet rs;
        
        String sql = "UPDATE Accounts SET amount = '"+ updatedAmount +"' WHERE accID = '"+ accID +"'";
        
         try{
            statement = connection.createStatement();
            if(statement.executeUpdate(sql)>0){
                flag = true;
            }
        }catch (SQLException ex){
            
        }
                
        return flag;
    }

    public float getAmount(int accID){

          Statement statement;
          ResultSet rs;
          
          String sql = "SELECT amount FROM Accounts WHERE accID = '" + accID + "'";
          try {
               statement = connection.createStatement();
               rs=statement.executeQuery(sql);
               
               while(rs.next()){
                    return Float.parseFloat(rs.getString("amount"));
               }
          } 
          catch(SQLException e)
          {
             e.printStackTrace();
          }
          return 0;
    }
    
     public int getAccID(String username){

          Statement statement;
          ResultSet rs;
          
          String sql = "SELECT accID FROM Accounts WHERE clientFname = '" + username + "'";
          try {
               statement = connection.createStatement();
               rs=statement.executeQuery(sql);
               
               while(rs.next()){
                    return Integer.parseInt(rs.getString("accID"));
               }
          } 
          catch(SQLException e)
          {
             e.printStackTrace();
          }
          return 0;
    }


}