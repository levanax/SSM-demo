package top.xuebiao.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.xuebiao.common.Constant;
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
	public Map<String, Object> getProducts(RequestEntity<String> request) {
		Map<String, Object> r = new HashMap<String, Object>();
		List<Product> products = productService.getProducts();
		r.put(Constant.DATA, products);
		return r;
	}

	/**
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> postProduct(RequestEntity<String> request, Product product) {
		Map<String, Object> r = new HashMap<String, Object>();
		Product productRes = productService.addProduct(product);
		if(productRes != null) {
			r.put(Constant.DATA, productRes);
		}
		Collection<String> a = null;
		return r;
	}

	/**
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public Map<String, Object> putProduct(Product product, @PathVariable  int id) {
		Map<String, Object> r = new HashMap<String, Object>();
		Product productRes = productService.addProduct(product);
		if(productRes != null) {
			r.put(Constant.DATA, productRes);
		}
		return r;
	}
}
