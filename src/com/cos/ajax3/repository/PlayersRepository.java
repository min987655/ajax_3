package com.cos.ajax3.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ajax3.db.DBconn;
import com.cos.ajax3.model.KBOTeam;
import com.cos.ajax3.model.Players;

public class PlayersRepository {
	private static final String TAG = "PlayersRepository : "; 
	
	private static PlayersRepository instance = new PlayersRepository();
	private PlayersRepository() {}
	public static PlayersRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<Players> findTeamPlayer(int teamId) {
		System.out.println(TAG + "teamId : " + teamId);
		final String SQL = "SELECT id, teamId , playerName, position FROM players WHERE teamId =? ";
		List<Players> playerList = new ArrayList<>();
		System.out.println(TAG + "playerList : " + playerList);
		
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, teamId);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Players player = Players.builder()
						.id(rs.getInt(1))
						.teamId(rs.getInt(2))
						.playerName(rs.getString(3))
						.position(rs.getString(4))
						.build();
				playerList.add(player);
				System.out.println(TAG + "KBOTeam : " + player);
			}
			return playerList;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findTeamPlayer : " + e.getMessage());
		} finally {
			DBconn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public List<Players> findAll() {
		final String SQL = "SELECT id, teamId, playerName, position FROM players";
		List<Players> playerList = new ArrayList<>();
		
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Players player = Players.builder()
						.id(rs.getInt(1))
						.teamId(rs.getInt(2))
						.playerName(rs.getString(3))
						.position(rs.getString(4))
						.build();
				playerList.add(player);
				System.out.println(TAG + "KBOTeam : " + player);
			}
			return playerList;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll : " + e.getMessage());
		} finally {
			DBconn.close(conn, pstmt, rs);
		}
		return null;
	}
}
