package com.betfair.blocantii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betfair.blocantii.control.SpotController;
import com.betfair.blocantii.meta.SpotMeta;
import com.betfair.blocantii.model.Spot;
import com.betfair.blocantii.util.Constants;
import com.betfair.blocantii.util.JsonUtils;

@SuppressWarnings("serial")
public class SpotServlet extends HttpServlet {

	private SpotController spotController = new SpotController();

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		List<Spot> cars = spotController.getCarSpots();

		String output = cars.size() != 0 ? SpotMeta.get().modelsToJson(cars, 2)
				: JsonUtils.errorToJson(Constants.ERR_NO_CARS);

		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(output);
		out.flush();
	}
}
