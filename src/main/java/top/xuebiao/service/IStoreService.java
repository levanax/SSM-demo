package top.xuebiao.service;

import java.util.List;

import top.xuebiao.exception.AppException;
import top.xuebiao.vo.Store;
import top.xuebiao.vo.StoreRecord;

public interface IStoreService {

	List<Store> getStores();

	List<StoreRecord> getStoreRecords();

	List<StoreRecord> getSingleProductStoreRecords(int productID);
	
	StoreRecord addStoreRecord(StoreRecord storeRecord) throws AppException;
	
	StoreRecord updateStoreRecord(StoreRecord storeRecord);
	
	boolean deleteStoreRecord(StoreRecord storeRecord);
}
