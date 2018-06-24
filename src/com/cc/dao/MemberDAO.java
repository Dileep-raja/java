package com.cc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cc.context.ConnectionThreadLocalContext;
import com.cc.valueobjects.MemberVO;

public class MemberDAO {
	
	public void saveMember(MemberVO member) throws SQLException
	{
		final String sql="select max(memberID) from MemberVO";
		Connection con = null;
		Statement idstmt = null;
		PreparedStatement savePstmt = null;
		ResultSet rs = null;
		int memberID = -1;

		con = ConnectionThreadLocalContext.getInstance().getConnection();
		
		idstmt = con.createStatement();
		rs = idstmt.executeQuery(sql);
		
		if(rs.next())
		{
			memberID = rs.getInt(1);
		}
		member.setMemberId(memberID); 
		
		savePstmt = con.prepareStatement("insert into MemberVO values(?,?,?,?)");
		savePstmt.setInt(1, memberID);
		savePstmt.setString(2, member.getName());
		savePstmt.setDate(3, new java.sql.Date(member.getDob().getTime()));
		savePstmt.setString(4, member.getGender());
		
		savePstmt.executeUpdate();
		
	}
}
