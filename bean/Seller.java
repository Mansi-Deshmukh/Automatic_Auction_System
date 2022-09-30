import java.util.List;

public class Seller {
    private int sellerId;
    private String name;
    private String email;
    private String password;

    private List<Product> products;
    private List<Product> itemSold;
    public Seller() {
    }
    public Seller(int sellerId, String name, String email, String password, List<Product> products,
            List<Product> itemSold) {
        this.sellerId = sellerId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.products = products;
        this.itemSold = itemSold;
    }
    
    public int getSellerId() {
        return sellerId;
    }
    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
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
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public List<Product> getItemSold() {
        return itemSold;
    }
    public void setItemSold(List<Product> itemSold) {
        this.itemSold = itemSold;
    }
    @Override
    public String toString() {
        return "Seller [sellerId=" + sellerId + ", name=" + name + ", email=" + email + ", password=" + password
                + ", products=" + products + ", itemSold=" + itemSold + "]";
    }
    
    
}
