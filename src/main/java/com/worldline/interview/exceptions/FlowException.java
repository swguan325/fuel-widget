package com.worldline.interview.exceptions;

import com.worldline.interview.enums.ErrorMessage;

import lombok.Getter;

@Getter
public class FlowException extends Exception {
	private static final long serialVersionUID = 1L;

	private final String message;

	public FlowException(ErrorMessage cdMsg) {
		this.message = cdMsg.getMessage();
	}
}
