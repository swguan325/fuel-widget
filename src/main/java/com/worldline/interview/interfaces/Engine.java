package com.worldline.interview.interfaces;

import com.worldline.interview.enums.FuelType;
import com.worldline.interview.exceptions.FlowException;

public interface Engine {

	void fill(FuelType fuel, int level) throws FlowException;

	void consumeFuel() throws FlowException;

	void start() throws FlowException;

	void stop();

	double getCostPerBatch() throws FlowException;

	boolean isRunning();

	int getBatchSize();
}
