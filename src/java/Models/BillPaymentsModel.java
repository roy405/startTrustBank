
package Models;

public class BillPaymentsModel {
    private int accID;
    private String BillType;
    private String CompanyName;
    private String BillAccountID;
    private float amount;
    private float billAmount;
    private float updatedAmount;

    public BillPaymentsModel(int accID, String BillType, String CompanyName, String BillAccountID, float amount, float billAmount, float updatedAmount) {
        this.accID = accID;
        this.BillType = BillType;
        this.CompanyName = CompanyName;
        this.BillAccountID = BillAccountID;
        this.amount = amount;
        this.billAmount = billAmount;
        this.updatedAmount = updatedAmount;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getBillType() {
        return BillType;
    }

    public void setBillType(String BillType) {
        this.BillType = BillType;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getBillAccountID() {
        return BillAccountID;
    }

    public void setBillAccountID(String BillAccountID) {
        this.BillAccountID = BillAccountID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(float billAmount) {
        this.billAmount = billAmount;
    }

    public float getUpdatedAmount() {
        return updatedAmount;
    }

    public void setUpdatedAmount(float updatedAmount) {
        this.updatedAmount = updatedAmount;
    }
    
    
    
    
}
