package com.betfair.blocantii.control;

import org.slim3.datastore.Datastore;

import com.betfair.blocantii.meta.StatisticsMeta;
import com.betfair.blocantii.model.Statistics;
import com.betfair.blocantii.util.Constants;

public class StatisticsController {

	private StatisticsMeta meta = StatisticsMeta.get();

	public Statistics getStatistics() {
		return Datastore.query(meta).asSingle();
	}

	public void updateStats(Statistics statistics) {
		Statistics stats = getStatistics();
		stats.setFreeSpots(statistics.getFreeSpots());
		stats.setOccupiedSpots(statistics.getOccupiedSpots());
		stats.setBlockedSpots(statistics.getBlockedSpots());
		stats.setBlockingSpots(statistics.getBlockingSpots());
		Datastore.put(stats);
	}

	public void resetStatistics() {
		Statistics stats = getStatistics();
		if (stats == null) {
			stats = new Statistics();
		}
		stats.setFreeSpots(Constants.DEFAULT_FREE_SPOTS);
		stats.setOccupiedSpots(0);
		stats.setBlockedSpots(0);
		stats.setBlockingSpots(0);
		Datastore.put(stats);
	}

}
