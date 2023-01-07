
package Models;

import java.io.Serializable;

public class OpenAccountModel implements Serializable{
    private String accountType;
    private String branch; 
    private float  amount;
    private int accountStatus;
    private String username;
    private String BankUserName;
    private String clientFname;

    public OpenAccountModel(String accountType, String branch, float amount, int accountStatus, String username, String BankUserName, String clientFname) {
        this.accountType = accountType;
        this.branch = branch;
        this.amount = amount;
        this.accountStatus = accountStatus;
        this.username = username;
        this.BankUserName = BankUserName;
        this.clientFname = clientFname;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatis) {
        this.accountStatus = accountStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBankUserName() {
        return BankUserName;
    }

    public void setBankUserName(String BankUserName) {
        this.BankUserName = BankUserName;
    }

    public String getClientFname() {
        return clientFname;
    }

    public void setClientFname(String clientFname) {
        this.clientFname = clientFname;
    }
    
    
}
