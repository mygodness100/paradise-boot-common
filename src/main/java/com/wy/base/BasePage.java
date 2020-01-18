package com.wy.base;

import com.wy.enums.PageType;

/**
 * @apiNote 联表分页接口
 * @author ParadiseWY
 * @date 2019年11月6日 下午10:42:52
 */
public interface BasePage {
	
	PageType getType();

	/**
	 * @apiNote 获得需要进行查询的字段
	 * @param clazz 需要查询的主表实体字节码
	 * @return 需要查询的字段
	 */
	Object getColumns(Class<?> clazz);

	/**
	 * @apiNote 需要进行查询的表
	 * @param clazz 需要查询的主表实体字节码
	 * @return 需要查询的表
	 */
	Object getTable(Class<?> clazz);

	/**
	 * @apiNote 查询所需要的条件
	 * @return 查询需要的条件
	 */
	Object getCondition();

	/**
	 * @apiNote 排序方式
	 * @return 排序方式
	 */
	Object getOrder();
}