package top.xuebiao.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.xuebiao.service.ProductService;
import top.xuebiao.vo.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/product")
	public Map<String,Object> login(RequestEntity<String> request){
		Map<String,Object> r = new HashMap<String, Object>();
		List<Product> products = productService.getProducts();
		r.put("data", products);
		return r;
	}
}
