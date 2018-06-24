package com.gtm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gtm.bo.MemberBo;
import com.gtm.entities.Member;
import com.gtm.util.HibernateUtilForOracle;

public class MemberDao {
	public int saveMember(MemberBo memberBo)
	{
		int memberNo = 0;
		Session oracleSession = null;
		Transaction transaction = null;
		Member member =null;
		
		boolean flag = false;

		try {
			oracleSession = HibernateUtilForOracle.getSessionFactory().getCurrentSession();
			System.out.println("Oracle Session : " + oracleSession);
			
			transaction = oracleSession.beginTransaction();
			
			member = new Member();
			
			member.setFirstName(memberBo.getFirstName());
			member.setLastName(memberBo.getLastName());
			member.setAge(memberBo.getAge());
			member.setGender(memberBo.getGender());

			memberNo = (Integer) oracleSession.save(member);
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
		}

		return memberNo;
	}
}
