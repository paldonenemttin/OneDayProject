package com.paldonenemttin.food.service.impl;

import java.sql.Connection;
import java.util.List;

import com.paldonenemttin.food.contract.DBContract;
import com.paldonenemttin.food.model.FoodDTO;
import com.paldonenemttin.food.model.FoodVO;
import com.paldonenemttin.food.service.FoodService;

public class FoodServiceImpl implements FoodService{

	protected Connection dbConn;
	
	public FoodServiceImpl() {
		// TODO Auto-generated constructor stub
		dbConn = DBContract.getDBConnection();
	}
	
	
	@Override
	public List<FoodDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodDTO findcode(String fd_code) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<FoodDTO> findFname(String fd_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodDTO> findCname(String fd_ccode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodDTO> findTname(String fd_tname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(FoodVO foodVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(FoodVO foodVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String fd_code) {
		// TODO Auto-generated method stub
		
	}

}
