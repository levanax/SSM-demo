package top.xuebiao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import top.xuebiao.common.Responser;
import top.xuebiao.constant.Constant;
import top.xuebiao.constant.ResponseCode;
import top.xuebiao.service.IProductService;
import top.xuebiao.vo.Product;

@CrossOrigin(origins = "*")
@RequestMapping(value = "products")
@RestController
public class ProductController {

	@Autowired
	private IProductService productService;

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getProducts() {
		List<Product> products = productService.getProducts();
		return Responser.success(products);
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getProduct(@PathVariable  int id) {
		Product product = productService.getProduct(id);
		return Responser.success(product);
	}
	
	/**
	 */
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<Object> postProduct(@RequestBody Product product) {
		Map<String, Object> r = new HashMap<String, Object>();
		Product productRes = productService.addProduct(product);
		if(productRes != null) {
			r.put(Constant.DATA, productRes);
			return Responser.success(productRes);
		}else {
			return Responser.error(ResponseCode.R0001, ResponseCode.R0001_DESC);
		}
	}

	/**
	 */
	@RequiresRoles("admin")
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Object> putProduct(@RequestBody Product product, @PathVariable  int id) {
		product.setId(id);
		Product productRes = productService.updateProduct(product);
		if(productRes != null) {
			return Responser.success(productRes);
		}else {
			return Responser.error(ResponseCode.R0001, ResponseCode.R0001_DESC);
		}
	}
	
	/**
	 * 删除 product
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable  int id) {
		boolean success = productService.deleteProduct(id);
		if(success) {
			return Responser.success("");
		}else {
			return Responser.error(ResponseCode.R0001, ResponseCode.R0001_DESC);
		}
	}
}
