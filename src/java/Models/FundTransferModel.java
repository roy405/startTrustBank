package Models;

import java.io.Serializable;


public class FundTransferModel implements Serializable{
    private int accID;
    private float amountToTransfer;
    private int beneficiaryId;
    private String amount;
    private float updatedAmount;
    private String BankName;

    public FundTransferModel(int accID, float amountToTransfer, int beneficiaryId, String amount, float updatedAmount, String BankName) {
        this.accID = accID;
        this.amountToTransfer = amountToTransfer;
        this.beneficiaryId = beneficiaryId;
        this.amount = amount;
        this.updatedAmount = updatedAmount;
        this.BankName = BankName;
 
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String BankName) {
        this.BankName = BankName;
    }
    

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(int beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public float getAmountToTransfer() {
        return amountToTransfer;
    }

    public void setAmountToTransfer(float amountToTransfer) {
        this.amountToTransfer = amountToTransfer;
    }

    public float getUpdatedAmount() {
        return updatedAmount;
    }

    public void setUpdatedAmount(float updatedAmount) {
        this.updatedAmount = updatedAmount;
    }
    
    
}
