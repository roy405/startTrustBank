package Models;
   
import java.io.Serializable;


public class TransactionModel implements Serializable {
 private int logID;
 private String logTime;
 private String logDate;
 private String logDesc; 
 private String logType;
 private String BankUserName; 

    public TransactionModel(int logID, String logTime, String logDate, String logDesc, String logType, String BankUserName) {
        this.logID = logID;
        this.logTime = logTime;
        this.logDate = logDate;
        this.logDesc = logDesc;
        this.logType = logType;
        this.BankUserName = BankUserName;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getBankUserName() {
        return BankUserName;
    }

    public void setBankUserName(String BankUserName) {
        this.BankUserName = BankUserName;
    }
 
 
 
}
