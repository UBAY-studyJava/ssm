package com.soecode.lyf.enums;

/**
 * 使用枚举表述常量数据字典 Enumeration Representation Constant Data Dictionary
 * 열거형 표현 상수 데이터 사전
 * 시스템에러의 원문 : 系统异常
 */
public enum AppointStateEnum {

	SUCCESS(1, "Reservation successful"), NO_NUMBER(0, "soldout"), REPEAT_APPOINT(-1, "duplicate reservation"), INNER_ERROR(-2, "System Error");

	private int state;

	private String stateInfo;

	private AppointStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static AppointStateEnum stateOf(int index) {
		for (AppointStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
