package Models;
import java.io.Serializable;


public class AccountModel implements Serializable {
    private float Amount;
    private String AccountType;
    private String Branch;

    public AccountModel() { }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float Amount) {
        this.Amount = Amount;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String Branch) {
        this.Branch = Branch;
    }
    
    
}
