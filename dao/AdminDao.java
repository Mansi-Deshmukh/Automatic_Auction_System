package dao;

import java.util.List;
public interface AdminDao {
    
    public List<Buyer> viewBuyerList();
    public List<Seller> viewSellerList();
    public List<Product> dailySellReport();
    
}
