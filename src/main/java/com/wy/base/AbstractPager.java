package com.wy.base;

import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

/**
 * @apiNote 分页参数
 * @author ParadiseWY
 * @date 2020年1月2日 下午8:47:13
 */
@Getter
@Setter
public abstract class AbstractPager {
	@Transient
	@JSONField(serialize = false)
	private Integer pageSize;
	
	@Transient
	@JSONField(serialize = false)
	private Integer pageIndex;
	
	public boolean hasPager() {
		if (pageIndex == null || pageIndex <= 0) {
			return false;
		}
		if (pageSize == null || pageSize <= 0) {
			pageSize = 10;
		}
		return true;
	}
}