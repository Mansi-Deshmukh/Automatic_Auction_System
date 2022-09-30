public class Buyer{
    private int buyerId;
    private String name;
    private String email;
    private String password;
    public Buyer(int buyerId, String name, String email, String password) {
        this.buyerId = buyerId;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public Buyer() {
    }
    public int getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Buyer [buyerId=" + buyerId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
    }

    
}