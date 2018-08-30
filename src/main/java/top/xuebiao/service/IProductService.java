package top.xuebiao.service;

import java.util.List;

import top.xuebiao.vo.Product;

public interface IProductService {
	List<Product> getProducts();
	
	Product getProduct(int productID);
	
	Product addProduct(Product product);
	
	Product updateProduct(Product product);
	
	boolean deleteProduct(int productID);
}
