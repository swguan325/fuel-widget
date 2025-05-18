
package com.worldline.interview;

import static com.worldline.interview.enums.FuelType.COAL;
import static com.worldline.interview.enums.FuelType.PETROL;
import static com.worldline.interview.enums.FuelType.WOOD;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.worldline.interview.exceptions.FlowException;

public class SteamEngineTest {

	@Test
	public void testProduceWidgets_Wood() throws FlowException {
		SteamEngine engine = new SteamEngine();
		engine.fill(WOOD, 5);
		WidgetMachine machine = new WidgetMachine(engine);

		double cost = machine.produceWidgets(5);
		assertEquals(3 * 4.35, cost, 0.01);
	}

	@Test
	public void testProduceWidgets_Coal() throws FlowException {
		SteamEngine engine = new SteamEngine();
		engine.fill(COAL, 5);
		WidgetMachine machine = new WidgetMachine(engine);

		double cost = machine.produceWidgets(4);
		assertEquals(2 * 5.65, cost, 0.01);
	}

	@Test(expected = FlowException.class)
	public void test_FuelType_Wrong() throws FlowException {
		SteamEngine engine = new SteamEngine();
		engine.fill(PETROL, 5);
	}

	@Test(expected = FlowException.class)
	public void test_Fuel_Empty() throws FlowException {
		SteamEngine engine = new SteamEngine();
		engine.fill(WOOD, 0);
		engine.start();
	}
}
