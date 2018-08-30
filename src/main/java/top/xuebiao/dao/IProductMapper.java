package top.xuebiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import top.xuebiao.vo.Product;

@Mapper
public interface IProductMapper {

	List<Product> getProducts();

	Product getProduct(@Param(value="product") Product product);
	
	int addProduct(@Param(value="product") Product product);
	
	int updateProduct(@Param(value="product") Product product);
	
	int deleteProduct(@Param(value="product") Product product);
	
}
