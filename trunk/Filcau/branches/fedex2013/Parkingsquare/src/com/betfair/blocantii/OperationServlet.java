package com.betfair.blocantii;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.EnumUtils;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.betfair.blocantii.admin.UserOperation;
import com.betfair.blocantii.control.SpotController;
import com.betfair.blocantii.control.StatisticsController;
import com.betfair.blocantii.control.UserController;
import com.betfair.blocantii.meta.SpotMeta;
import com.betfair.blocantii.meta.UserMeta;
import com.betfair.blocantii.model.Spot;
import com.betfair.blocantii.model.Statistics;
import com.betfair.blocantii.model.User;
import com.betfair.blocantii.util.Constants;
import com.betfair.blocantii.util.JsonUtils;

@SuppressWarnings("serial")
public class OperationServlet extends HttpServlet {

	private SpotController spotController = new SpotController();
	private UserController userController = new UserController();
	private StatisticsController statisticsController = new StatisticsController();

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("application/json");
		String output = null;
		String parameter = req.getParameter("OPERATION");
		if (parameter == null
				|| !EnumUtils.isValidEnum(UserOperation.class, parameter)) {
			output = JsonUtils.errorToJson(Constants.ERR_NOT_A_VALID_OPERATION);
		} else {
			UserOperation operation = UserOperation.valueOf(parameter);

			switch (operation) {
			case CHECK_IN:
				output = checkin(req);
				break;

			case CHECK_OUT:
				checkout(req);
				break;

			case GET_OWNER_DETAILS:
				output = getOwnerDetails(req);
				break;
			}

		}
		resp.getWriter().print(output);
		resp.getWriter().flush();
	}

	private String getOwnerDetails(HttpServletRequest req) {
		User user = userController.getUserByKey("userKey");
		return UserMeta.get().modelToJson(user);
	}

	private void checkout(HttpServletRequest req) {
		String spotKey = req.getParameter("spotKey");
		Spot spot = spotController.getSpotByKey(spotKey);
		spotController.deleteSpotByKey(spot.getKey());
		updateCheckoutStatistics();
	}

	private String checkin(HttpServletRequest req) {
		String output;
		String userKey = req.getParameter("userKey");
		Spot desiredSpot = populateDesiredSpot(req);
		Spot freeSpot = spotController.getFreeSpot(desiredSpot);
		boolean isFreeSpot = freeSpot != null;

		if (isFreeSpot) {
			User user = userController.getUserByKey(userKey);
			spotController.linkSpotToItsUser(freeSpot, user);
			updateCheckinStatistics();
			output = SpotMeta.get().modelToJson(freeSpot);
		} else {
			output = JsonUtils.errorToJson(Constants.ERR_NOT_A_FREE_SPOT);
		}
		return output;
	}

	private void updateCheckinStatistics() {
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		Statistics statistics = gtx.get(Statistics.class, statisticsController
				.getStatistics().getKey());

		statistics.setOccupiedSpots(statistics.getOccupiedSpots() + 1);
		statistics.setFreeSpots(statistics.getFreeSpots() - 1);
		statisticsController.updateStats(statistics);

		gtx.put(statistics);
		gtx.commit();
	}

	private void updateCheckoutStatistics() {
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		Statistics statistics = gtx.get(Statistics.class, statisticsController
				.getStatistics().getKey());

		statistics.setOccupiedSpots(statistics.getOccupiedSpots() - 1);
		statistics.setFreeSpots(statistics.getFreeSpots() + 1);
		statisticsController.updateStats(statistics);

		gtx.put(statistics);
		gtx.commit();
	}

	private Spot populateDesiredSpot(HttpServletRequest req) {
		Spot spot = new Spot();
		spot.setX1(Integer.parseInt(req.getParameter("x1")));
		spot.setY1(Integer.parseInt(req.getParameter("y1")));
		spot.setX2(Integer.parseInt(req.getParameter("x2")));
		spot.setY2(Integer.parseInt(req.getParameter("y2")));
		spot.setType("CAR");

		return spot;
	}

}
