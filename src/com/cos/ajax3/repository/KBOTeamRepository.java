package com.cos.ajax3.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ajax3.db.DBconn;
import com.cos.ajax3.model.KBOTeam;
import com.cos.ajax3.model.Players;

public class KBOTeamRepository {
	private static final String TAG = "KBOTeamRepository : "; 
	
	private static KBOTeamRepository instance = new KBOTeamRepository();
	private KBOTeamRepository() {}
	public static KBOTeamRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<KBOTeam> findAll() {
		final String SQL = "SELECT id, teamName FROM KBOTeam";
		List<KBOTeam> kboTeams = new ArrayList<>();
		
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				KBOTeam kboTeam = KBOTeam.builder()
						.id(rs.getInt(1))
						.teamName(rs.getString(2))
						.build();
				kboTeams.add(kboTeam);
				System.out.println(TAG + "KBOTeam : " + kboTeam);
			}
			return kboTeams;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll : " + e.getMessage());
		} finally {
			DBconn.close(conn, pstmt, rs);
		}
		return null;
	}
}
