package classcollection.ebillapp;

public class Customer {

    private String username;
    private String password;
    private String fullName;
    private String address;
    private int customerId;

    public Customer(String fullName,String username, String password, int Id, String Address) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.customerId = Id;
        this.address = Address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public int getCustomerId() {
        return customerId;
    }

    // Getters and Setters
}
