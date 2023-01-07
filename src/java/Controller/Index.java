package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends PageBase {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

            super.doGet(request, response);

            HttpSession loginSession = request.getSession();
            loginSession.removeAttribute("username");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        super.doGet(request, response);
        
        String username = request.getParameter("username");
        String password = request.getParameter("userPass");

        Index profile = new Index();

        try{
            String validateUser = profile.userValidate(username, password);
            
            
            switch(validateUser){
                case "admin":
                {
                    HttpSession loginSession = request.getSession();
                    loginSession.setAttribute("username", username);
                    response.sendRedirect("MessageAdmin");
                    break;
                }
                
                case "manager":
                {
                    HttpSession loginSession = request.getSession();
                    loginSession.setAttribute("username", username);
                    response.sendRedirect("MessageManager");
                    break;
                }
                
                case "user":
                {
                    HttpSession loginSession = request.getSession();
                    loginSession.setAttribute("username", username);
                    response.sendRedirect("AccountSummary");
                    break;
                }
                
                default:
                    HttpSession coursesession = request.getSession();
                    coursesession.setAttribute("status", "err");
                    response.sendRedirect("index.jsp?retry=1");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public String userValidate(String username, String password){
        Statement statement = null;
        ResultSet rs= null;
         
        try {
            String sql = "SELECT userType FROM BankUser WHERE username= '"+ username+"' " + 
                "&& userPass='"+ password+"'";
            
            statement =connection.prepareStatement(sql);  
            rs = statement.executeQuery(sql);
            
            while(rs.next()){
                if(rs.getString("userType").equals("1")){
                    return "admin";
                }else if(rs.getString("userType").equals("2")){
                    return "manager";
                }else if(rs.getString("userType").equals("3"))
                {   
                    
                    return "user";
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return "Invalid";
    }
}

