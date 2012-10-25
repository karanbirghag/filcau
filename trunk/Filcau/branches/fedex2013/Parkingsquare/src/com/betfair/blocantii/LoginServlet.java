package com.betfair.blocantii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betfair.blocantii.control.UserController;
import com.betfair.blocantii.meta.UserMeta;
import com.betfair.blocantii.model.User;
import com.betfair.blocantii.util.Constants;
import com.betfair.blocantii.util.JsonUtils;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	private UserController userController = new UserController();

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String carNumber = req.getParameter("carNumber");
		User user = userController.getUserByCarNumber(carNumber);

		String output = user != null ? UserMeta.get().modelToJson(user)
				: JsonUtils.errorToJson(Constants.ERR_NO_USER_FOR_CAR_NUMBER);

		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(output);
		out.flush();
	}
}
