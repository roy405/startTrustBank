package Models;

import java.io.Serializable;

public class AccountSummaryModel implements Serializable  {
    
    private int clientID;
    private String DOB;
    private String Age;
    private String clientFname;
    private String clientLname;
    private String NICPassport; 
    private int AccountNo; 
    private String Address;

    public AccountSummaryModel() {}

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getClientFname() {
        return clientFname;
    }

    public void setClientFname(String clientFname) {
        this.clientFname = clientFname;
    }

    public String getClientLname() {
        return clientLname;
    }

    public void setClientLname(String clientLname) {
        this.clientLname = clientLname;
    }

    public String getNICPassport() {
        return NICPassport;
    }

    public void setNICPassport(String NICPassport) {
        this.NICPassport = NICPassport;
    }

    public int getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(int AccountNo) {
        this.AccountNo = AccountNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
  
    
    

}