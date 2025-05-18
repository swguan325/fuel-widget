package com.worldline.interview;

import static com.worldline.interview.enums.FuelType.DIESEL;
import static com.worldline.interview.enums.FuelType.PETROL;
import static com.worldline.interview.enums.FuelType.WOOD;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.worldline.interview.exceptions.FlowException;

public class InternalCombustionEngineTest {

	@Test
	public void testProduceWidgets_Wood() throws FlowException {
		InternalCombustionEngine engine = new InternalCombustionEngine(PETROL);
		engine.fill(PETROL, 10);
		WidgetMachine machine = new WidgetMachine(engine);

		double cost = machine.produceWidgets(16);
		assertEquals(2 * 9.00, cost, 0.01);
	}

	@Test
	public void testProduceWidgets_Coal() throws FlowException {
		InternalCombustionEngine engine = new InternalCombustionEngine(DIESEL);
		engine.fill(DIESEL, 10);
		WidgetMachine machine = new WidgetMachine(engine);

		double cost = machine.produceWidgets(20);
		assertEquals(3 * 12.00, cost, 0.01);
	}

	@Test(expected = FlowException.class)
	public void test_FuelType_Fill() throws FlowException {
		InternalCombustionEngine engine = new InternalCombustionEngine(PETROL);
		WidgetMachine machine = new WidgetMachine(engine);
		machine.produceWidgets(16);
	}

	@Test(expected = FlowException.class)
	public void test_FuelType_Wrong() throws FlowException {
		InternalCombustionEngine engine = new InternalCombustionEngine(WOOD);
		engine.fill(WOOD, 10);
	}

	@Test(expected = FlowException.class)
	public void test_Fuel_Empty() throws FlowException {
		InternalCombustionEngine engine = new InternalCombustionEngine(PETROL);
		engine.fill(PETROL, 0);
		engine.start();
	}

}
