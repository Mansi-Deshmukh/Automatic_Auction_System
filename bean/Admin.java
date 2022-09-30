import java.util.List;

public class Admin {

    private String userName;
    private String password;
    private List<Buyer> buyers;
    private List<Seller> sellers;
    public Admin(String userName, String password, List<Buyer> buyers, List<Seller> sellers) {
        this.userName = userName;
        this.password = password;
        this.buyers = buyers;
        this.sellers = sellers;
    }
    public Admin() {
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Buyer> getBuyers() {
        return buyers;
    }
    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }
    public List<Seller> getSellers() {
        return sellers;
    }
    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }
    @Override
    public String toString() {
        return "Admin [userName=" + userName + ", password=" + password + ", buyers=" + buyers + ", sellers=" + sellers
                + "]";
    }

    
    
}
