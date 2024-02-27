package com.xworkz.toy.toycontroller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.xworkz.toy.dto.ToyDto;
import com.xworkz.toy.entity.ToyEntity;
import com.xworkz.toy.service.ToyServiceImpl;
import com.xworkz.toy.utils.AppConstants;

@RestController
@RequestMapping("/api")
public class ToyController {
	
	
	
	
	@Autowired
	ToyServiceImpl toyService;
	
	
	
	@PostMapping("/toys")
	public ResponseEntity<ToyEntity> save(@RequestBody ToyDto dto) {
	ToyEntity createAll= toyService.save(dto);
	 
	URI location=ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(createAll).toUri();
	return ResponseEntity.created(location).build();
	 
	}
	
	@PostMapping("HttP POST/toys")
	public ResponseEntity<Object>  createAll(@RequestBody List<ToyDto> dto){
		 toyService.saveAll(dto);
		 
		 return ResponseEntity.created(null).build();
	}
	
	@GetMapping("/toy")
	public List<ToyEntity> retireveAllToys(){
		return toyService.retrieveAllToys();
	}
	
	@GetMapping("/toy/{id}")
	public ToyEntity findToysById(@PathVariable int id) {	
		return toyService.getToysById(id);
	}
	
//	@GetMapping("/toys/{toyName}")
//	public List<ToyEntity> findToyByName(@PathVariable String toyName) {
//		System.out.println("response is : "+toyName);
//		return toyService.findByToyName(toyName);
//		
//	}
	
	

	
	
	@GetMapping("/toy/pages")
	public List<ToyEntity> findByPagenation( 	@RequestParam(defaultValue = "0")  Integer pageNo,
			@RequestParam(defaultValue = "10")  Integer pageSize){
		
//		@RequestParam(defaultValue = "0")
//		@RequestParam(defaultValue = "10")
		
		return toyService.findAllByPagenation(pageNo,pageSize);
		
	}
	
	
	@GetMapping("/toys/type")
	public List<ToyEntity> findBySortAndPaging( @RequestParam(defaultValue="0") Integer pageNo,
			@RequestParam(defaultValue="10") Integer pageSize,
					@RequestParam(defaultValue="toyType,asc") String toyType){
		
		System.out.println("Controller is here");
		return toyService.pageAndSortByType(pageNo, pageSize,toyType);	
				
	
	
	}
	
	
	@GetMapping("/multitoys")
	public List<ToyEntity> findBySortAndPaging( @RequestParam(defaultValue="0") Integer pageNo,
			@RequestParam(defaultValue="10") Integer pageSize,
			@RequestParam(defaultValue="toyType,asc")String toyType,
			@RequestParam(defaultValue="toyName,asc")String toyName){
		
		System.out.println("Controller is here");
		return toyService.pageAndSortByTypeAndName(pageNo,pageSize, toyType, toyName);
				
	
	}
	
	
	
	
	
	
//	@GetMapping("/pagenation")
//	public List<ToyEntity> findByPagination(@RequestParam (value="pageNo",defaultValue=AppConstants.DEFAUlT_PAGENUMBER, required = false)int pageNo,
//			@RequestParam (value="pageNo", defaultValue=AppConstants.DEFAUlT_PAGESIZE, required = false)int pageSize,
//			@RequestParam (value="pageNo",defaultValue=AppConstants.DEFAULT_SORT_BY, required = false)String sortBy,
//			@RequestParam (value="pageNo",defaultValue=AppConstants.DEFAULT_SORT_DIRECTION, required = false)String sortDir){
//			
//		return	toyService.findAllBySoertingAndPadgenation(pageNo, pageSize, sortBy, sortDir);
//	}
	
//	@GetMapping("/toys/sorting-pagination")
//	public List<ToyEntity> findByToyNameSorting(@RequestParam(defaultValue="0")Integer pageNo,
//											@RequestParam(defaultValue="10")Integer pageSize,@PathVariable String name){
//		return toyService.findAllByNameSorting(pageNo,pageSize, name);
//	}
//	
//	@PutMapping("/toys/{id}")
//	public ToyEntity updateByToyId(@RequestBody ToyEntity entity,@PathVariable int id) {
//	ToyEntity	toy=toyService.getToysById(id);
//	
//	if(toy.getToyId()==id) {
//		entity.setToyId(id);
//		toyService.save(entity);
//	}
//	return entity;
//	}
//	
//	@DeleteMapping("/toys/{id}")
//	public boolean deleteById(@PathVariable int id) {
//		return toyService.deleteById(id);
//		
//	}
//	
//	@PostMapping("/saveAll")
//	public List<ToyEntity> saveAll(@RequestBody List<ToyEntity> toysEntity){
//		return toyService.saveAll(toysEntity);
//	}
//	
	
//	@PutMapping("/toys/{toyName}")
//	public ToysEntity updateByName( @RequestBody ToysEntity entity, @PathVariable String name) {
//	ToysEntity	toy=toyService.findByToyName(name);
//	
//	if(toy.getToyName().equals(name)) {
//		
//	entity.setToyName(name);
//	
//	System.out.println("Updated toys is :"+toy);
//	}
//	return toyService.save(entity);		
//	}
	
	//save,saveList,read by one id, read all,update, delete 
	
//	@PostMapping("/saveAll")
//	public List<ToysEntity> saveList(@RequestBody List<ToysEntity> toysEntity){
//		return toyService.saveList(toysEntity);
//		
//	}

	//sonar lint

}
