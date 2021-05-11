package com.paldonenemttin.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paldonenemttin.food.contract.DBContract;
import com.paldonenemttin.food.model.EatVO;
import com.paldonenemttin.food.model.FoodDTO;
import com.paldonenemttin.food.model.FoodVO;
import com.paldonenemttin.food.service.FoodService;

public class FoodServiceImpl implements FoodService{

	protected Connection dbConn;
	
	public FoodServiceImpl() {
		// TODO Auto-generated constructor stub
		dbConn = DBContract.getDBConnection();
	}
	
	private List<FoodDTO> select(PreparedStatement pStr) throws SQLException {
		
		List<FoodDTO> fdList = new ArrayList<FoodDTO>();
		ResultSet rStr = pStr.executeQuery();
		while(rStr.next()) {
			FoodDTO fdDTO = new FoodDTO();
			fdDTO.setFd_code(rStr.getString("식품코드"));
			fdDTO.setFd_name(rStr.getString("식품명"));
			fdDTO.setFd_year(rStr.getInt("출시일"));
			fdDTO.setFd_ccode(rStr.getString("제조사명"));
			fdDTO.setFd_tcode(rStr.getString("분류명"));
			fdDTO.setFd_ones(rStr.getInt("일회제공량"));
			fdDTO.setFd_all(rStr.getInt("총제공량"));
			fdDTO.setFd_kral(rStr.getInt("에너지"));
			fdDTO.setFd_prot(rStr.getInt("단백질g"));
			fdDTO.setFd_fat(rStr.getInt("지방g"));
			fdDTO.setFd_carb(rStr.getInt("탄수화물g"));
			fdDTO.setFd_suga(rStr.getInt("총당류g"));
			fdList.add(fdDTO);
		}
		return fdList;
	}
	
	
	@Override
	public List<FoodDTO> selectAll() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM view_식품정보";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<FoodDTO> fdList = this.select(pStr);
			pStr.close();
			return fdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	


	@Override
	public FoodDTO findcode(String code) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public List<FoodDTO> findFname(String name) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM view_식품정보";
		sql += " WHERE 식품명 LIKE '%' || ? || '%' ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, name);
			
			List<FoodDTO> fdList = this.select(pStr);
			pStr.close();
			return fdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FoodDTO> findCname(String cname) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM view_식품정보";
		sql += " WHERE 제조사명 LIKE '%' || ? || '%' ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, cname);
			
			List<FoodDTO> fdList = this.select(pStr);
			pStr.close();
			return fdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<FoodDTO> findTname(String tname) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM view_식품정보";
		sql += " WHERE 분류명 LIKE '%' || ? || '%' ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, tname);
			
			List<FoodDTO> fdList = this.select(pStr);
			pStr.close();
			return fdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(EatVO eatVO) {
		// TODO 먹은거 추가
		
		String sql = "INSERT INTO tbl_myfoods ";
		sql += "(my_seq, my_date, my_code, my_eats";
		sql += "VALUES(seq_myfoods.NEXTVAL, ?,?,?)";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, eatVO.getMy_date());
			pStr.setString(2, eatVO.getFd_code());
			pStr.setInt(3, eatVO.getMy_eats());
			
			int result = pStr.executeUpdate();
			pStr.close();
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
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
