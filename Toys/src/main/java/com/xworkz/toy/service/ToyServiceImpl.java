package com.xworkz.toy.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.xworkz.toy.dto.ToyDto;
import com.xworkz.toy.entity.ToyEntity;
import com.xworkz.toy.handler.ToyNotFoundException;
import com.xworkz.toy.repository.ToyRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ToyServiceImpl implements ToyService {

	@Autowired
	ToyRepository toyRepo;

	@PersistenceContext
	EntityManager eManager;

	@Override
	public ToyEntity save(ToyDto dto) {
		ToyEntity entity = new ToyEntity();
		
		if(dto!=null) {
		BeanUtils.copyProperties(dto, entity);
		entity.setCreatedBy(dto.getCreatedBy());
		entity.setCreatedDate(LocalDateTime.now());
		entity.setUpdatedBy(dto.getUpdatedBy());
		entity.setUpdateOn(LocalDateTime.now());
		}
		else {
			System.out.println("Dto is null");
			return null;
		}
		return toyRepo.save(entity);
		
	}
	@Override
	public String saveAll(List<ToyDto> dto) {

		if(dto!=null) {
		List<ToyEntity> entityList = new ArrayList<ToyEntity>();

		for (ToyDto listDto : dto) {
			ToyEntity entity = new ToyEntity();
			entity.setToyName(listDto.getToyName());
			entity.setToyType(listDto.getToyType());
			entity.setPrice(listDto.getPrice());
			entity.setCreatedBy((listDto.getCreatedBy()));
			entity.setCreatedDate(LocalDateTime.now());
			entity.setUpdatedBy((listDto.getUpdatedBy()));
			entity.setUpdateOn(LocalDateTime.now());
			entityList.add(entity);
		}
		System.out.println(entityList);
		BeanUtils.copyProperties(dto, entityList);

		toyRepo.saveAll(entityList);
		}
		
		else {
			return "Entered data is null";
		}


		return "Data Saved Successfully";
	}

	public List<ToyEntity> retrieveAllToys() {
		return toyRepo.findAll();
	}

	@Override
	public ToyEntity getToysById(int id) {

	Optional<ToyEntity> toyById=toyRepo.findById(id);
	
	if(toyById.isEmpty()) {
		throw new ToyNotFoundException("Entered toy not found");
	}
	
		return toyById.get();
	}

//	@Override
//	public List<ToyEntity> findAllBySoertingAndPadgenation(int pageNo, int pageSize, String sortBy, String sortDir) {
//
//	Sort	sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending()
//																		:Sort.by(sortBy).descending();
//		
//Pageable	pageable=PageRequest.of(pageNo, pageSize, sort);
//	
//					Page<ToyEntity> page =toyRepo.findAll(pageable);
//					
//					List<ToyEntity> toyList=page.getContent();
//	return toyList;
//	}

//	@Override
//	public List<ToyEntity> findByToyName(String toyName) {
//		System.out.println("toys is :" + toyName);
//	return toyRepo.findByToyName(toyName);
//	}
//
//	@Override
//	public ToysEntity updateByToyId(ToysEntity entity, int id) {
//
//		return toyRepo.save(entity);
//	}
//
//	@Override
//	public boolean deleteById(int id) {
//		if (toyRepo.findById(id).isPresent()) {
//			toyRepo.deleteById(id);
//
//		}
//		return true;
//	}
//
//	@Override
//	public List<ToysEntity> saveAll(List<ToysEntity> toysEntity) {
//
//		return toyRepo.saveAll(toysEntity);
//
//	}

	@Override
	public List<ToyEntity> findAllByPagenation(int pageNo, int pageSize) {

		// creating an object of pagerequest
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);

		Page<ToyEntity> pagingUser = toyRepo.findAll(pageRequest);

		return pagingUser.getContent();

	}

	@Override
	public List<ToyEntity> pageAndSortByType(int pageNo, int pageSize, String toyType) {

		PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by("toyType").descending());

//this is to findAllbysomething//Page<ToyEntity>	pagingUser =toyRepo.findAll(pageRequest);

		Page<ToyEntity> page = toyRepo.findByToyType(pageRequest, toyType);

		return page.getContent();

	}

	@Override
	public List<ToyEntity> pageAndSortByTypeAndName(int pageNo, int pageSize, String toyType, String toyName) {

		Sort name = Sort.by("toyName");
		Sort type = Sort.by("toyType");

		Sort multiSort = name.and(type);

		Pageable page = PageRequest.of(pageNo, pageSize, multiSort);

		Page p = toyRepo.findByToyTypeAndToyName(page, toyType, toyName);

		return p.getContent();

	}

	// @Override
//	public List<ToyEntity> findAllByNameSorting(int pageNo, int pageSize,String name) {
//	PageRequest	page=PageRequest.of(pageNo, pageSize, Sort.by("name").ascending());
//	
//Page<ToyEntity>	pagingToy=toyRepo.findByToyName(pageSize, pageSize, name);
//		return pagingToy.getContent();
//	}

//	@Override
//	public ToysEntity updateByName(String name) {
//		return toyRepo.updateByName(name);
//		
//	
//		
//	}

//	@Override
//	public List<ToysEntity> saveList(ToysEntity toysEntity) {
//		return toyRepo.saveAll(toysEntity);
//		
//	}

}
