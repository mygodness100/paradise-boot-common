package com.wy.enums;

/**
 * @apiNote 判断通用联表查询的getList方法中的sql是那种类型
 * @author ParadiseWY
 * @date 2020年1月17日 下午10:28:31
 */
public enum PageType {

	// 原生sql
	NATIVE("native"),
	// jpa
	JPA("jpa"),
	// mybais
	MYBATIS("mybatis");

	private String type;

	PageType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}
}