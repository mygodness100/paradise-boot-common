package com.wy.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.wy.yml.UserYml;

@Configuration
@EnableConfigurationProperties({ UserYml.class })
public class YmlConfig {

	public static UserYml userYml;

	@Autowired
	public void setFeatureTable(UserYml userYml) {
		YmlConfig.userYml = userYml;
	}
}