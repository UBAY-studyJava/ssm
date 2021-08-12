package com.soecode.lyf.exception;

/**
 * 库存不足异常 재고부족 이상 Out of stock abnormality
 */
public class NoNumberException extends RuntimeException {

	public NoNumberException(String message) {
		super(message);
	}

	public NoNumberException(String message, Throwable cause) {
		super(message, cause);
	}

}
