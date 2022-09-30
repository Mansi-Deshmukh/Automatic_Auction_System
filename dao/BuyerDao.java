package dao;

import java.util.List;

public interface BuyerDao {

        public Buyer registerBuyer(Buyer buyer);
        
        public List<Buyer> viewAllBuyers();
        
        public Product buyProduct(int productId);
        
        
    }

