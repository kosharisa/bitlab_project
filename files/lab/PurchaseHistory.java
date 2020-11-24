package files.lab;

import java.util.Date;

public class PurchaseHistory {

    private String goodName;
    private int goodPrice;
    private Date purchaseTime;

    public PurchaseHistory() {
    }

    public PurchaseHistory(String goodName, int goodPrice) {
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.purchaseTime = new Date();
    }

    public PurchaseHistory(String goodName, int goodPrice, Date purchaseTime) {
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.purchaseTime = purchaseTime;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(int goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    @Override
    public String toString() {
        return "PurchaseHistory{" +
                "goodName='" + goodName + '\'' +
                ", goodPrice=" + goodPrice +
                ", purchaseTime=" + purchaseTime +
                '}';
    }
}
