package top.xuebiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.xuebiao.vo.Product;

@Mapper
public interface ProductMapper {

	List<Product> getProducts();
	
	int addProduct(Product product);
	
	int updateProduct(Product product);
}
