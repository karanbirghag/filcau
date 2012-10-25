package com.betfair.blocantii;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betfair.blocantii.admin.AdminOperation;
import com.betfair.blocantii.control.SpotController;
import com.betfair.blocantii.control.UserController;

@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {

	private SpotController spotController = new SpotController();
	private UserController userController = new UserController();

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String parameter = req.getParameter("OPERATION");
		AdminOperation operation = parameter != null ? AdminOperation
				.valueOf(parameter) : AdminOperation.INIT;

		switch (operation) {
		case INIT:
			initDatastore();
			break;
		case RESET:
			resetDatastore();
			break;
		}

		resp.setContentType("text/plain");
		resp.getWriter().println("Application initialised");
	}

	private void resetDatastore() {
		spotController.deleteAllCarSpots();
		userController.deleteAllUsers();
	}

	private void initDatastore() {
		spotController.initCarSpots();
		userController.initUsers();
	}
}
