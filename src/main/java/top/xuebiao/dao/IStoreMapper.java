package top.xuebiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.xuebiao.vo.Store;

@Mapper
public interface IStoreMapper {
	

	List<Store> getStores();
}
