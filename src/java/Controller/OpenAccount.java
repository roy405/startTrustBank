package Controller;

import Models.OpenAccountModel;
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

@WebServlet(name = "OpenAccount", urlPatterns = {"/OpenAccount"})
public class OpenAccount extends PageBase{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
            super.doGet(request, response);
        
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/OpenAccount.jsp");
            requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
            HttpSession session = request.getSession();
            OpenAccountModel account = new OpenAccountModel(request.getParameter("accountType"), request.getParameter("branch"), Float.parseFloat("15000"), 
                    0, session.getAttribute("username").toString(), getBankUserName(session.getAttribute("username").toString()), getClientFname(session.getAttribute("username").toString()));
            
            if(addAccount(account)){
                response.sendRedirect("BillPayments");
            }else{
                response.sendRedirect("OpenAccount");
            }
    }

    public boolean addAccount(OpenAccountModel account){
        boolean flag = false;
       
        String sql = "INSERT INTO Accounts (accountType, branch, amount,  accountStatus, BankUserName, clientFname) values ('"+ account.getAccountType() +"', '"+ account.getBranch() +"', '"+ account.getAmount() +"', '"+ account.getAccountStatus() +"', '"+ account.getBankUserName() +"', '"+ account.getClientFname() +"')";
        
         try{
            stmt = connection.createStatement();
            if(stmt.executeUpdate(sql)>0){
                flag = true;
            }
        }catch (SQLException ex){
            
        }
                
        return flag;
    }
    
    public String getClientFname(String username) {
        
        Statement statement;
        ResultSet rs;
        
        try {
            String sql = "SELECT clientFname FROM Clients WHERE clientFname= '"+ username +"'";
            
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            
            while(rs.next()){
                return rs.getString("clientFname");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return "0";
    }
    
    public String getBankUserName(String username) {
        
        Statement statement;
        ResultSet rs;
        
        try {
            String sql = "SELECT username FROM BankUser WHERE username= '"+ username +"'";
            
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            
            while(rs.next()){
                return rs.getString("username");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return "0";
    }

}

