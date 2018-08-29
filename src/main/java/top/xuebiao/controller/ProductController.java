package top.xuebiao.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.xuebiao.common.Response;
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
	public ResponseEntity<Map<String, Object>> getProducts() {
		List<Product> products = productService.getProducts();
		return Response.success(products);
	}

	/**
	 */
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<Map<String, Object>> postProduct(@RequestBody Product product) {
		Map<String, Object> r = new HashMap<String, Object>();
		Product productRes = productService.addProduct(product);
		if(productRes != null) {
			r.put(Constant.DATA, productRes);
			return Response.success(productRes);
		}else {
			return Response.error(ResponseCode.R0001, ResponseCode.R0001_DESC);
		}
	}

	/**
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> putProduct(@RequestBody Product product, @PathVariable  int id) {
		product.setId(id);
		Product productRes = productService.updateProduct(product);
		if(productRes != null) {
			return Response.success(productRes);
		}else {
			return Response.error(ResponseCode.R0001, ResponseCode.R0001_DESC);
		}
	}
	
	/**
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable  int id) {
		boolean success = productService.deleteProduct(id);
		if(success) {
			return Response.success("");
		}else {
			return Response.error(ResponseCode.R0001, ResponseCode.R0001_DESC);
		}
	}
}
