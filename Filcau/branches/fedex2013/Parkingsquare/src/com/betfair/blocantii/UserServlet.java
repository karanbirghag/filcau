package com.betfair.blocantii;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betfair.blocantii.control.SpotController;

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		new SpotController().initCarSpots();
		resp.getWriter().println("init");
	}

}
