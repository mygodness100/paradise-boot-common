package com.wy.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.wy.base.AbstractPage;

/**
 * @apiNote 分页专用,值为分页参数类
 * @author ParadiseWY
 * @date 2019年10月11日
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface ListModel {

	Class<? extends AbstractPage> value();
}