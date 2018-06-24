package com.cc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cc.context.ConnectionThreadLocalContext;
import com.cc.valueobjects.PlanVO;

public class PlanDAO {
	public void savePlan(PlanVO plan) throws SQLException
	{
		final String sql="select max(planNo) from PlanVO";
		Connection con = null;
		Statement idstmt = null;
		PreparedStatement savePstmt = null;
		ResultSet rs = null;
		int planID = -1;

		con = ConnectionThreadLocalContext.getInstance().getConnection();
		
		idstmt = con.createStatement();
		rs = idstmt.executeQuery(sql);
		
		if(rs.next())
		{
			planID = rs.getInt(1);
		}
		plan.setPlanNo(planID); 
		
		savePstmt = con.prepareStatement("insert into planVO values(?,?)");
		savePstmt.setInt(1, planID);
		savePstmt.setString(2, plan.getPlanName());
		
		savePstmt.executeUpdate();
		
		
	}
}
