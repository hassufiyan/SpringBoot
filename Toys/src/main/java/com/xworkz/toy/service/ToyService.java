package com.xworkz.toy.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.xworkz.toy.dto.ToyDto;
import com.xworkz.toy.entity.ToyEntity;

public interface ToyService {
	
ToyEntity save(ToyDto  dto);
	
	List<ToyEntity>  retrieveAllToys();
	
	ToyEntity getToysById(int id);
	
	//List<ToyEntity> findByToyName(String toyName);
	
//	ToysEntity updateByToyId(ToysEntity entity,int id);
	
//	boolean deleteById(int id);
	
//ToysEntity	updateByName(String name);
	
	String saveAll(List<ToyDto> dto);
	
	List<ToyEntity> findAllByPagenation(int pageNo,int pageSize);
	
	//List<ToyEntity> findAllByNameSorting(int pageNo,int pageSize,String name);
	
	//List<ToyEntity> findAllBySoertingAndPadgenation(int pageNo,int pageSize,String sortBy,String sortDir);

	List<ToyEntity> pageAndSortByType(int pageNo,int pageSize,String toyType);
	
	List<ToyEntity> pageAndSortByTypeAndName(int pageNo,int pageSize,String toyType,String toyName);
}
