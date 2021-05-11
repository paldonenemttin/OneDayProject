package com.paldonenemttin.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paldonenemttin.food.contract.DBContract;
import com.paldonenemttin.food.contract.DBInfo;
import com.paldonenemttin.food.model.EatDTO;
import com.paldonenemttin.food.service.FListService;

public class FListServiceImpl implements FListService {

	protected Connection dbConn;

	public FListServiceImpl() {
		dbConn = DBContract.getDBConnection();
	}

	private List<EatDTO> select(PreparedStatement pStr) throws SQLException {
		// TODO Auto-generated method stub
		List<EatDTO> eList = new ArrayList<EatDTO>();
		ResultSet rSet = pStr.executeQuery();
		while (rSet.next()) {
			EatDTO eatDTO = new EatDTO();
			eatDTO.setMy_date(rSet.getString(DBInfo.EAT.my_date));
			eatDTO.setFd_code(rSet.getString(DBInfo.EAT.fd_code));
			eatDTO.setFd_name(rSet.getString(DBInfo.EAT.fd_name));
			eatDTO.setMy_eats(rSet.getInt(DBInfo.EAT.my_eats));
			eatDTO.setFd_all(rSet.getInt(DBInfo.EAT.fd_all));
			eatDTO.setFd_kral(rSet.getInt(DBInfo.EAT.fd_karl));
			eatDTO.setFd_prot(rSet.getInt(DBInfo.EAT.fd_prot));
			eatDTO.setFd_fat(rSet.getInt(DBInfo.EAT.fd_fat));
			eatDTO.setFd_carb(rSet.getInt(DBInfo.EAT.fd_carb));
			eatDTO.setFd_suga(rSet.getInt(DBInfo.EAT.fd_suga));
			eList.add(eatDTO);
		}
		rSet.close();

		return eList;
	}

	@Override
	public List<EatDTO> selectAll() {
		// TODO Auto-generated method stub

		String sql = " SELECT * FROM view_섭취정보 ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);

			List<EatDTO> eList = this.select(pStr);
			pStr.close();
			return eList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EatDTO> findDate(String my_date) {
		// TODO Auto-generated method stub

		String sql = " SELECT * FROM view_섭취정보 ";
		sql += " WHERE 날짜 = ? ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, my_date.trim());
			List<EatDTO> eList = this.select(pStr);
			pStr.close();
			return eList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EatDTO> findFname(String fd_name) {
		// TODO Auto-generated method stub

		String sql = " SELECT * FROM view_섭취정보 ";
		sql += " WHERE ";
		sql += DBInfo.EAT.fd_name;
		sql += "LIKE '%' || ? || '%'";
		
		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, fd_name.trim());

			List<EatDTO> eList = this.select(pStr);
			pStr.close();
			return eList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<EatDTO> findFcode(String fd_code) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_섭취정보 ";
		sql += " WHERE 식품코드 = ? ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, fd_code.trim());
			List<EatDTO> eList = this.select(pStr);
			pStr.close();
			return eList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}