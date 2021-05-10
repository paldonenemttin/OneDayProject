package com.paldonenemttin.food.service;

import java.util.List;

import com.paldonenemttin.food.model.FoodDTO;
import com.paldonenemttin.food.model.FoodVO;

public interface FoodService {
	
	public List<FoodDTO> selectAll();
	
	public FoodDTO findcode(String fd_code);
	
	public List<FoodDTO> findFname(String fd_name);
	
	public List<FoodDTO> findCname(String fd_ccode);
	
	public List<FoodDTO> findTname(String fd_tname);
	
	public void insert(FoodVO foodVO);
	
	public void update(FoodVO foodVO);
	
	public void delete(String fd_code);
	

}
