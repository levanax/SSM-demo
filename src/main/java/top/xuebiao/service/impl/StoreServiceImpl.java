package top.xuebiao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xuebiao.dao.IStoreMapper;
import top.xuebiao.service.IStoreService;
import top.xuebiao.vo.Store;

@Service
public class StoreServiceImpl implements IStoreService {

	@Autowired
	private IStoreMapper storeMapper;

	@Override
	public List<Store> getStores() {
		return storeMapper.getStores();
	}
}
