package com.wy.yml;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "config.user")
public class UserYml {

	private String swagger2BasePackage;
	private List<Class<?>> swagger2IgnoredParameterTypes;
}