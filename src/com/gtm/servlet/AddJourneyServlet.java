package com.gtm.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gtm.bo.JourneyBo;
import com.gtm.bo.MemberBo;
import com.gtm.dao.JourneyDao;
import com.gtm.dao.MemberDao;

@WebServlet("/add-journey")
public class AddJourneyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		JourneyDao jDao = null;
		MemberDao mDao = null;
		JourneyBo journeyBo = null;
		MemberBo memberBo = null;
		String page = null;
		
		try {
			journeyBo = new JourneyBo();
			journeyBo.setSource(req.getParameter("source"));
			journeyBo.setDestination(req.getParameter("destination"));
			journeyBo.setJourneyDate(new SimpleDateFormat("dd-MM-yyyy")
					.parse(req.getParameter("journeyDate")));
			journeyBo.setAmount(Double.parseDouble(req.getParameter("amount")));
			
			jDao = new JourneyDao();
			int journeyNO = jDao.saveJourney(journeyBo);
			
			memberBo = new MemberBo();
			memberBo.setFirstName("Vivek");
			memberBo.setLastName("Tiwari");
			memberBo.setGender("Male");
			memberBo .setAge(13);
			
			int memberNo = mDao.saveMember(memberBo);
			req.setAttribute("memberNo", memberNo);
			req.setAttribute("journeyNO", journeyNO);
			page="/success.jsp";
		} catch (ParseException e) {
			req.setAttribute("error", e);
			page="/error.jsp";
		}
		req.getRequestDispatcher(page).forward(req, resp);
	}

}
