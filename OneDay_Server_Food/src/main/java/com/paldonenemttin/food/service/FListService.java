package com.paldonenemttin.food.service;

import java.util.List;

import com.paldonenemttin.food.model.EatDTO;



public interface FListService {
	
	public List<EatDTO> selectAll();
	
	public List<EatDTO> findDate(String my_date);
	
	public List<EatDTO> findFname(String fd_name);
	
	public List<EatDTO> findFcode(String fd_code);
	
	public void insert();
	public void update();
	public void delete();

}
