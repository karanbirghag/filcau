package com.betfair.blocantii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betfair.blocantii.control.UserController;
import com.betfair.blocantii.meta.UserMeta;
import com.betfair.blocantii.model.User;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	private UserController userController = new UserController();

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String carNumber = req.getParameter("carNumber");
		User user = userController.getUserByCarNumber(carNumber);

		resp.setContentType("text/plain");
		resp.getWriter().println("Hi " + user.getUsername());
		
		resp.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = resp.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		out.print(UserMeta.get().modelToJson(user));
		out.flush();
		
	}

}
