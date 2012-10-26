package com.betfair.blocantii;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betfair.blocantii.control.StatisticsController;
import com.betfair.blocantii.meta.StatisticsMeta;
import com.betfair.blocantii.model.Statistics;

@SuppressWarnings("serial")
public class StatisticsServlet extends HttpServlet {

	private StatisticsController statisticsController = new StatisticsController();
	StatisticsMeta statisticsMeta = StatisticsMeta.get();

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		resp.setContentType("text/plain");
		Statistics stats = statisticsController.getStatistics();

		resp.getWriter().println(statisticsMeta.modelToJson(stats));
	}

}
