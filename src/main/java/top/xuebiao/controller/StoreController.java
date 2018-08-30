package top.xuebiao.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import top.xuebiao.common.Response;
import top.xuebiao.exception.AppException;
import top.xuebiao.service.IStoreService;
import top.xuebiao.vo.Store;
import top.xuebiao.vo.StoreRecord;

@CrossOrigin(origins = "*")
@RequestMapping(value = "stores")
@RestController
public class StoreController {

	@Autowired
	private IStoreService storeService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getStores(){
		List<Store> result = this.storeService.getStores();
		return Response.success(result);
	}
	

	@RequestMapping(value="/records",method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getStoreRecords(){
		List<StoreRecord> result = this.storeService.getStoreRecords();
		return Response.success(result);
	}

	@RequestMapping(value="/records/{productID}",method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getSingleProductStoreRecords(@PathVariable  int productID){
		List<StoreRecord> result = this.storeService.getSingleProductStoreRecords(productID);
		return Response.success(result);
	}

	@RequestMapping(value="/records",method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> postStoreRecord(@RequestBody StoreRecord storeRecord) throws AppException{
		StoreRecord result = storeService.addStoreRecord(storeRecord);
		return Response.success(result);
	}
}
