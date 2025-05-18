
package com.worldline.interview;

import com.worldline.interview.enums.ErrorMessage;
import com.worldline.interview.exceptions.FlowException;
import com.worldline.interview.interfaces.Engine;

public class WidgetMachine {

	private Engine engine;

	public WidgetMachine(Engine engine) {
		this.engine = engine;
	}

	public double produceWidgets(int quantity) throws FlowException {
		engine.start();

		if (!engine.isRunning()) {
			throw new FlowException(ErrorMessage.ENGINE_NOT_RUN);
		}

		int batchSize = engine.getBatchSize();
		int batches = (int) Math.ceil((double) quantity / batchSize);
		double cost = 0.0;

		for (int i = 0; i < batches; i++) {
			engine.consumeFuel();
			cost += engine.getCostPerBatch();
		}

		engine.stop();
		return cost;
	}
}
