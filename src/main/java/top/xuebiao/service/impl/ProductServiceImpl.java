package top.xuebiao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xuebiao.vo.Product;
import top.xuebiao.common.Util;
import top.xuebiao.dao.IProductMapper;

@Service
public class ProductServiceImpl implements top.xuebiao.service.IProductService {

	@Autowired
	private IProductMapper productMapper;
	
	@Override
	public List<Product> getProducts() {		
		return productMapper.getProducts();
	}

	@Override
	public Product addProduct(Product product) {
		Product result = null;
		int successRow = productMapper.addProduct(product);
		if(successRow == 1 ) {
			result = product;
		}
		return result;
	}

	@Override
	public Product updateProduct(Product product) {
		Product result = null;
		int successRow = productMapper.updateProduct(product);
		if(successRow == 1 ) {
			result = product;
		}
		return result;
	}

	@Override
	public boolean deleteProduct(int productID) {
		boolean result = false;
		Product product = new Product();
		product.setId(productID);
		int successRow = productMapper.deleteProduct(product);
		if(successRow == 1 ) {
			result = true;
		}
		return result;
	}

	@Override
	public Product getProduct(int productID) {
		Product product = new Product();
		product.setId(productID);
		return  productMapper.getProduct(product);
	}

}
