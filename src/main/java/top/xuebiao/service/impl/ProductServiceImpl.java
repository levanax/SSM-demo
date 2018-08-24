package top.xuebiao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xuebiao.vo.Product;
import top.xuebiao.dao.ProductMapper;

@Service
public class ProductServiceImpl implements top.xuebiao.service.IProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<Product> getProducts() {		
		return productMapper.getProducts();
	}

	@Override
	public Product addProduct(Product product) {
		Product result = null;
		int productID = productMapper.addProduct(product);
		if(productID != 0) {
			product.setId(productID);
			result = product;
		}
		return result;
	}

	@Override
	public Product updateProduct(Product product) {
		Product result = null;
		int productID = productMapper.updateProduct(product);
		if(productID != 0) {
			result = product;
		}
		return result;
	}

}
