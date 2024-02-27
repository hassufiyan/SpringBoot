package com.xworkz.toy.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xworkz.toy.entity.ToyEntity;


public interface ToyRepository extends JpaRepository<ToyEntity,Integer> {

	
Page<ToyEntity>	findByToyType(Pageable pageRequest,String toyType);
	
Page<ToyEntity>	findByToyTypeAndToyName(Pageable pageRequest,String toyType,String toyName);	

//Page<ToyEntity> findAll(Pageable pageRequest);	
	
	
//Page<ToyEntity> findByToyName(int pageNo,int pageSize, String toyName);

//List<ToyEntity> findByToyPrice(int price,Pageable pageable);
	
	
//	@Query(value = "")
//	ToysEntity updateByToyId(int id);
	
	//in spring we use find methods to update and delete the methods....
	
	//if we need any custome methods we use @query or @named query annotation and in service class we implement its code....

	//ToysEntity updateByName(String name);
}
