import java.time.LocalDateTime;

public class Transaction {
    private double amount;
    private String type;
    private String category;
    private LocalDateTime timeStamp;
    private int id; // Added new private field

    // constructor
    public Transaction(int id, double amount, String type, String category, LocalDateTime timeStamp) { // Updated constructor
        this.id = id; // Initialize id
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.timeStamp = timeStamp;
    }

    // getters and setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    public int getId() { // Added getter for id
        return id;
    }

    public void setId(int id) { // Added setter for id
        this.id = id;
    }
}
