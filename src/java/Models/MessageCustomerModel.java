
package Models;

public class MessageCustomerModel {
    private String email;
    private String receiver;
    private String msubject;
    private String message;
    private String BankUserName;

    public MessageCustomerModel(String email, String receiver, String msubject, String message, String BankUserName) {      
        this.email = email;
        this.receiver = receiver;
        this.msubject = msubject;
        this.message = message;
        this.BankUserName = BankUserName;
    }

 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMsubject() {
        return msubject;
    }

    public void setMsubject(String msubject) {
        this.msubject = msubject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBankUserName() {
        return BankUserName;
    }

    public void setBankUserName(String BankUserName) {
        this.BankUserName = BankUserName;
    }
    
    
    
    
}
