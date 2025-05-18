package com.worldline.interview;

import com.worldline.interview.enums.ErrorMessage;
import com.worldline.interview.enums.FuelType;
import com.worldline.interview.exceptions.FlowException;
import com.worldline.interview.interfaces.Engine;

public class InternalCombustionEngine implements Engine {

	private boolean running;
	private int fuelLevel;
	private FuelType requiredFuelType;
	private FuelType fuelType;

	private static final int BATCH_SIZE = 8;

	public void fill(FuelType fuel, int fuelLevel) throws FlowException {
		if (fuel != FuelType.PETROL && fuel != FuelType.DIESEL) {
			throw new FlowException(ErrorMessage.FUEL_TYPE_WRONG);
		}
		if (fuelLevel >= 0 && fuelLevel <= 100) {
			this.fuelLevel = fuelLevel;
		} else if (fuelLevel > 100) {
			this.fuelLevel = 100;
		} else {
			this.fuelLevel = 0;
		}
		this.fuelType = fuel;
	}

	@Override
	public void start() throws FlowException {
		if (!requiredFuelType.equals(fuelType)) {
			throw new FlowException(ErrorMessage.FUEL_TYPE_WRONG);
		}
		if (fuelLevel <= 0) {
			throw new FlowException(ErrorMessage.FUEL_LEVEL_EMPTY);
		}
		running = true;
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
		if (fuelType == FuelType.PETROL) {
			return 9.00;
		} else if (fuelType == FuelType.DIESEL) {
			return 12.00;
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

	public InternalCombustionEngine(FuelType requiredFuelType) {
		this.requiredFuelType = requiredFuelType;
		running = false;
		fuelLevel = 0;
	}

	public FuelType getFuelType() {
		return requiredFuelType;
	}
}
