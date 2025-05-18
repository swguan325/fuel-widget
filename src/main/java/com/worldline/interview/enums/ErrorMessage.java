package com.worldline.interview.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

	ENGINE_NOT_RUN("Engine is not run."),
	FUEL_TYPE_WRONG("Fuel supports only wood or coal."),
	FUEL_TYPE_NONE("No fuel type found."),
	FUEL_LEVEL_EMPTY("Fuel level must be greater than zero."),
	FUEL_LEVEL_SHORT("Fuel level not enough."),
	;

	private final String message;
}
