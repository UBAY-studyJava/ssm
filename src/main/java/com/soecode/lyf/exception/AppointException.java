package com.soecode.lyf.exception;

/**
 * 预约业务异常 Reservation task abnormality 예약 작업 이상
 */
public class AppointException extends RuntimeException {

	public AppointException(String message) {
		super(message);
	}

	public AppointException(String message, Throwable cause) {
		super(message, cause);
	}

}
