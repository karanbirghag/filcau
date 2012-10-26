package com.betfair.blocantii;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betfair.blocantii.control.SpotController;
import com.betfair.blocantii.control.StatisticsController;
import com.betfair.blocantii.control.UserController;

@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {

	private SpotController spotController = new SpotController();
	private UserController userController = new UserController();
	private StatisticsController statisticsController = new StatisticsController();

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		initDatastore();

		resp.setContentType("text/plain");
		resp.getWriter().println("Application Initialised");
	}

	private void initDatastore() {
		spotController.deleteAllCarSpots();
		userController.deleteAllUsers();
		spotController.initCarSpots();
		userController.initUsers();
		statisticsController.resetStatistics();
	}
}
