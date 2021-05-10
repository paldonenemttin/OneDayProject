package com.paldonenemttin.food.service;

import java.util.List;

import com.paldonenemttin.food.model.FoodDTO;
import com.paldonenemttin.food.model.FoodVO;

public interface FListService {
	
	public List<FoodDTO> selectAll();
	
	public FoodDTO findFcode(String fd_code);
	
	public List<FoodDTO> findCcode(String fd_ccode);
	
	public List<FoodDTO> findTcode(String fd_tcode);
	
	public void insert();
	public void update();
	public void delete();

}
