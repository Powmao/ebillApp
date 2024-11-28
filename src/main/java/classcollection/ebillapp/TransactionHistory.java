package classcollection.ebillapp;

public class TransactionHistory {

    private int month;
    private String dueDate;
    private int consumption;
    private double amount;
    private double amountDue;
    private String status;

    public TransactionHistory(int month, String dueDate, int consumption, double amount, double amountDue, String status) {
        this.month = month;
        this.dueDate = dueDate;
        this.consumption = consumption;
        this.amount = amount;
        this.amountDue = amountDue;
        this.status = status;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
