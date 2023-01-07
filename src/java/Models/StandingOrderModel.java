
package Models;

import java.io.Serializable;

public class StandingOrderModel implements Serializable {
    private String paymentType;
    private String paymentDate;
    private float stdamount;
    private String clientFname;

    public StandingOrderModel(String paymentType, String paymentDate, float stdamount, String clientFname) {
        this.paymentType = paymentType;
        this.paymentDate = paymentDate;
        this.stdamount = stdamount;
        this.clientFname = clientFname;
    }

   
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String parmentType) {
        this.paymentType = parmentType;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public float getStdamount() {
        return stdamount;
    }

    public void setStdamount(float stdamount) {
        this.stdamount = stdamount;
    }

    public String getClientFname() {
        return clientFname;
    }

    public void setClientFname(String clientFname) {
        this.clientFname = clientFname;
    }
    
    
}
