package top.xuebiao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xuebiao.common.Util;
import top.xuebiao.constant.ResponseCode;
import top.xuebiao.dao.IStoreMapper;
import top.xuebiao.exception.AppException;
import top.xuebiao.service.IStoreService;
import top.xuebiao.vo.Store;
import top.xuebiao.vo.StoreRecord;

@Service
public class StoreServiceImpl implements IStoreService {

	@Autowired
	private IStoreMapper storeMapper;

	@Override
	public List<Store> getStores() {
		return storeMapper.getStores();
	}

	@Override
	public List<StoreRecord> getStoreRecords() {
		return storeMapper.getStoreRecords();
	}

	@Override
	public List<StoreRecord> getSingleProductStoreRecords(int productID) {
		StoreRecord  sr = new StoreRecord();
		sr.setProductID(productID);
		return storeMapper.getSingleProductStoreRecords(sr);
	}

	@Override
	public StoreRecord addStoreRecord(StoreRecord storeRecord) throws AppException {
		StoreRecord  result = null;
		Store store = new Store();
		store.setProductID(storeRecord.getProductID());
		
		store = storeMapper.getStore(store);
		if (Util.isNull(store)) {
			// new
			if (StoreRecord.INSTRUCTIONS_IMPORT.equals(storeRecord.getInstructions())) {

				int storeRecordRow = storeMapper.addStoreRecord(storeRecord);
				if(storeRecordRow>0) {
					Store newStore = new Store();
					newStore.setProductID(storeRecord.getProductID());
					newStore.setTotal(storeRecord.getQuantity());
					int newRow = storeMapper.addStore(newStore);
					if(newRow > 0) {
						result = storeRecord;
					}
				}
			} else {
				// 无库存，出库不允许
				throw new AppException(ResponseCode.R0002, ResponseCode.R0002_DESC);
			}
		} else {
			// modify
			switch(storeRecord.getInstructions()) {
			case StoreRecord.INSTRUCTIONS_IMPORT:
				store.setTotal(Util.add(store.getTotal(), storeRecord.getQuantity()));
				break;
			case StoreRecord.INSTRUCTIONS_EXPORT:
				Integer total = Util.minus(store.getTotal(), storeRecord.getQuantity());
				if(total>0) {
					store.setTotal(total);
				}else {
					throw new AppException(ResponseCode.R0002, ResponseCode.R0002_DESC);
				}
				break;
			}
			int storeRecordRow = storeMapper.addStoreRecord(storeRecord);
			if (storeRecordRow > 0) {
				int storeRows = storeMapper.updateStore(store);
				if (storeRows > 0) {
					result = storeRecord;
				}
			}
		}
		return result;
	}

	@Override
	public StoreRecord updateStoreRecord(StoreRecord storeRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStoreRecord(StoreRecord storeRecord) {
		// TODO Auto-generated method stub
		return false;
	}
}
