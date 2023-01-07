package Controller;

import Models.FundTransferModel;
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

@WebServlet(name = "FundTransfer", urlPatterns = {"/FundTransfer"})
public class FundTransfer extends PageBase{
    
    String  username;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
             super.doGet(request, response);
        
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/FundTransfer.jsp");
            requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
             
                
            HttpSession session = request.getSession();
            username = session.getAttribute("username").toString();
            
            
            int accID = Integer.parseInt(request.getParameter("accID"));
            float amountToTransfer = Float.parseFloat(request.getParameter("amountToTransfer"));
            int beneficiaryId = Integer.parseInt(request.getParameter("beneficiaryId"));
            String BankName = request.getParameter("BankName");   
            float amount = getAmount(accID);
            float updatedAmount = amount - amountToTransfer;          
          
                          
           FundTransferModel fml = new FundTransferModel(Integer.parseInt(request.getParameter("accID")),Float.parseFloat(request.getParameter("amountToTransfer")), 
                Integer.parseInt(request.getParameter("beneficiaryId")), request.getParameter("amount"),updatedAmount, request.getParameter("BankName"));
            
            if(transferReducable(fml.getAccID(), fml.getUpdatedAmount())){
                response.sendRedirect("AccountSummary");
            }else{
                response.sendRedirect("FundTransfer");
            }
            }
    

 
    public boolean transferReducable(int accID, float updatedAmount){
        boolean flag = false;
        
        String sql = "UPDATE Accounts SET amount = '"+ updatedAmount +"' WHERE accID = '"+ accID +"'";
        
         try{
            stmt = connection.createStatement();
            if(stmt.executeUpdate(sql)>0){
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


}