package dao;

import java.util.List;

public interface SellerDao {

	public Seller registerSeller(Seller seller);
	
	public List<Product> createListOfitems(List<Product> products);
	
	public Product updateProduct(Product product);
	
	public Product addProductInList(Product product);
	
	public Product removeProductInList(Product product);
	
	public List<Product> soldItems(int sellerId);
	
}