
package Models;

import java.io.Serializable;

public class CardManagementModel implements Serializable {
    private int cardID;
    private String cardType;
    private String cardNumber;
    private String cardHolderNIC;
    private String cardStatus;
    private String expiryDate;
    private float amountDue;
    private String clientFname; 
    private int ccmID;
    
    public CardManagementModel(){}

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderNIC() {
        return cardHolderNIC;
    }

    public void setCardHolderNIC(String cardHolderNIC) {
        this.cardHolderNIC = cardHolderNIC;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }
    
    

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public float getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(float amountDue) {
        this.amountDue = amountDue;
    }

    public String getClientFname() {
        return clientFname;
    }

    public void setClientFname(String clientFname) {
        this.clientFname = clientFname;
    }

    public int getCcmID() {
        return ccmID;
    }

    public void setCcmID(int ccmID) {
        this.ccmID = ccmID;
    }
    
    
    
    
}
