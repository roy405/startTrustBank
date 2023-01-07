package Controller;
import Models.AccountSummaryModel;
import Models.AccountModel;
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


import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;


@WebServlet(name = "AccountSummary", urlPatterns = {"/AccountSummary"})
public class AccountSummary  extends PageBase {
        String username ;
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        super.doGet(request, response);
        
        HttpSession session = request.getSession();
        username = session.getAttribute("username").toString();
      
        AccountSummaryModel account = getUserInfo(username);
        request.setAttribute("userAcc", account);
        
        AccountModel Acc = getAccInfo(username);
        request.setAttribute("accountInfo", Acc);
        
        
        RequestDispatcher RequestDispatcherObj =request.getRequestDispatcher("/AccountSummary.jsp");
        RequestDispatcherObj.forward(request, response);
    
    }
   
    public  AccountSummaryModel getUserInfo(String username)
    {  
        
        AccountSummaryModel account = new AccountSummaryModel();
        Statement  statement;
        ResultSet rs ;
        try{ 
            
           String sql = "SELECT clientID, DOB, age, clientFname, clientLname, NICPassport, AccountNo, Address FROM Clients WHERE clientFname='" +username+ "'";
           statement = connection.createStatement();
            
           rs = statement.executeQuery(sql);

           while(rs.next()){ 
                account.setClientID(Integer.parseInt(rs.getString("clientID")));
                account.setDOB(rs.getString("DOB"));  
                account.setAge(rs.getString("age"));
                account.setClientFname(rs.getString("clientFname"));
                account.setClientLname(rs.getString("clientLname"));
                account.setNICPassport(rs.getString("NICPassport"));
                account.setAccountNo(Integer.parseInt(rs.getString("AccountNo")));
                account.setAddress(rs.getString("Address"));   
           }  
             connection.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return account;  
    }
      public AccountModel getAccInfo(String username)
    {
        AccountModel Acc = new AccountModel(); 
      
        Statement  statement;
        ResultSet rs ;
        try{ 
            

           String sql = "SELECT amount,branch,accountType FROM accounts WHERE clientFname='" +username+ "'";
           statement = connection.createStatement();
            
           rs = statement.executeQuery(sql);
           while(rs.next()){ 
                Acc.setAmount(rs.getFloat("amount"));
                Acc.setBranch(rs.getString("branch"));
                Acc.setAccountType(rs.getString("accountType"));  
            }  
            connection.close(); 
        }catch(Exception e){
            e.printStackTrace();
            
        }  
           
        return Acc; 
    }
    
    
   }
 

