package com.wy.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import springfox.documentation.spi.DocumentationType;

/**
 * @description swagger2自动装配配置文件
 * @author ParadiseWY
 * @date 2019年7月9日 上午9:32:26
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "config.autoconfig.swagger2")
public class Swagger2Properties {

	/**
	 * swagger2文档类型,默认是swagger2
	 */
	private DocumentationType documentationType;

	/**
	 * api文档名称
	 */
	private String groupName;

	/**
	 * swagger2默认需要扫描的包,唯一
	 */
	private String basePackage;

	/**
	 * 忽略扫描的类
	 */
	private Class<?>[] ignoredParameterTypes;

	/**
	 * 接口文档标题
	 */
	private String title;

	/**
	 * 接口文档描述
	 */
	private String description;

	/**
	 * 接口文档版本
	 */
	private String version;
}