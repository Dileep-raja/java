package com.cc.delegate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.cc.context.ConnectionThreadLocalContext;
import com.cc.dao.MemberDAO;
import com.cc.dao.PlanDAO;
import com.cc.valueobjects.MemberVO;
import com.cc.valueobjects.PlanVO;
import com.cc.valueobjects.PolicyVO;

public class MemberDelegate {
	public PolicyVO enrollMemberToPlan(MemberVO member,PlanVO plan)
	{
		PolicyVO policy = null;
		MemberDAO mDao = null;
		PlanDAO pDao = null;
		boolean flag = false;
		
		try {
			mDao = new MemberDAO();
			 mDao.saveMember(member);
			
			
			pDao = new PlanDAO();
			
			policy = new PolicyVO();
			policy.setEffictiveFrom(new Date());
			policy.setMemberNo(member.getMemberId());
			policy.setPlanNo(plan.getPlanNo());
			policy.setTenure(12);
			policy.setPremium(12_000f);
			
			flag = true;
		} catch ( SQLException e) {
			flag = false;
		}finally{
			Connection con = ConnectionThreadLocalContext.getInstance().getConnection();
			
			if(con != null)
			{
				if(flag)
				{
					try {
						con.commit();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else {
					try {
						con.rollback();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				ConnectionThreadLocalContext.getInstance().closeConnection();
			}
		}
		return policy;
	}
}
