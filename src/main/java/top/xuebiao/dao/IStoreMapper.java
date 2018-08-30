package top.xuebiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import top.xuebiao.vo.Store;
import top.xuebiao.vo.StoreRecord;

@Mapper
public interface IStoreMapper {
	
	List<Store> getStores();
	
	Store getStore(@Param(value="store") Store store);
	
	int addStore(@Param(value="store") Store store);


	int updateStore(@Param(value="store") Store store);
	
	
	int addStoreRecord(@Param(value="storeRecord") StoreRecord storeRecord);
	
	List<StoreRecord> getStoreRecords();
	
	List<StoreRecord> getSingleProductStoreRecords(@Param(value="storeRecord") StoreRecord storeRecord);
}
