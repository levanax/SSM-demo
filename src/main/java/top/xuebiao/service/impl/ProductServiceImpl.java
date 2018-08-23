package top.xuebiao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xuebiao.vo.Product;
import top.xuebiao.dao.ProductMapper;

@Service
public class ProductServiceImpl implements top.xuebiao.service.ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<Product> getProducts() {		
		return productMapper.getProducts();
	}

}
