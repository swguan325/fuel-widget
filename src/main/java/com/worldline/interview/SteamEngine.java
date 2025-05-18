
package com.worldline.interview;

import com.worldline.interview.enums.ErrorMessage;
import com.worldline.interview.enums.FuelType;
import com.worldline.interview.exceptions.FlowException;
import com.worldline.interview.interfaces.Engine;

public class SteamEngine implements Engine {
	private FuelType fuelType;
	private double fuelLevel;
	private boolean running = false;
	private boolean initialized = false;

	private static final int BATCH_SIZE = 2;

	@Override
	public void fill(FuelType fuel, int level) throws FlowException {
		if (fuel != FuelType.WOOD && fuel != FuelType.COAL) {
			throw new FlowException(ErrorMessage.FUEL_TYPE_WRONG);
		}
		this.fuelType = fuel;
		this.fuelLevel += level;
		this.initialized = true;
	}

	@Override
	public void start() throws FlowException {
		if (!initialized) {
			throw new FlowException(ErrorMessage.FUEL_TYPE_NONE);
		}
		if (fuelLevel <= 0) {
			throw new FlowException(ErrorMessage.FUEL_LEVEL_EMPTY);
		}
		this.running = true;
	}

	@Override
	public void stop() {
		this.running = false;
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public int getBatchSize() {
		return BATCH_SIZE;
	}

	@Override
	public double getCostPerBatch() throws FlowException {
		if (fuelType == FuelType.WOOD) {
			return 4.35;
		} else if (fuelType == FuelType.COAL) {
			return 5.65;
		}
		throw new FlowException(ErrorMessage.FUEL_TYPE_WRONG);
	}

	@Override
	public void consumeFuel() throws FlowException {
		if (fuelLevel < 1) {
			throw new FlowException(ErrorMessage.FUEL_LEVEL_SHORT);
		}
		fuelLevel -= 1;
	}
}
