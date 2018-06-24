package com.gtm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gtm.bo.JourneyBo;
import com.gtm.entities.Journey;
import com.gtm.util.HibernateUtilForMySQL;

public class JourneyDao {
	public int saveJourney(JourneyBo journeyBo) {
		int journeyNo = 0;
		Session mySQLSession = null;
		Transaction transaction = null;
		Journey journey = null;
		boolean flag = false;

		try {
			mySQLSession = HibernateUtilForMySQL.getSessionFactory().getCurrentSession();
			System.out.println("MYSQL Session : " + mySQLSession);
			
			transaction = mySQLSession.beginTransaction();

			journey = new Journey();
			journey.setSource(journeyBo.getSource());
			journey.setDestination(journeyBo.getDestination());
			journey.setJourneyDate(journeyBo.getJourneyDate());
			journey.setAmount(journeyBo.getAmount());
			
			
			journeyNo = (Integer) mySQLSession.save(journey);
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

		return journeyNo;
	}
}
