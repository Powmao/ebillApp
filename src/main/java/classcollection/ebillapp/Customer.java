package classcollection.ebillapp;

public class Customer {

    private String username;
    private String password;
    private String fullName;
    private String address;
    private int customerId;

    // Private static instance
    private static Customer instance;

    // Private constructor
    Customer(String fullName, String username, String password, int customerId, String address) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.customerId = customerId;
        this.address = address;
    }

    // Public static method to get the instance
    public static Customer getInstance(String fullName, String username, String password, int customerId, String address) {
        if (instance == null) {
            instance = new Customer(fullName, username, password, customerId, address);
        }
        return instance;
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
}
