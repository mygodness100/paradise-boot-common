package com.wy.autoconfig;

import java.util.Objects;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wy.utils.StrUtils;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @apiNote swagger2自动装配类
 * @author ParadiseWY
 * @date 2019年7月9日 上午9:27:40
 */
@Configuration
@EnableConfigurationProperties(Swagger2Properties.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@ConditionalOnProperty(prefix = "config.autoconfig.swagger2", value = "enabled", matchIfMissing = true)
public class Swagger2AutoConfiguration {

	private Swagger2Properties properties;

	public Swagger2AutoConfiguration(Swagger2Properties properties) {
		this.properties = properties;
	}

	@Bean
	public Docket createDocketApi() {
		return new Docket(
				Objects.isNull(properties.getDocumentationType()) ? DocumentationType.SWAGGER_2
						: properties.getDocumentationType())
								.groupName(StrUtils.isBlank(properties.getGroupName()) ? "API接口文档"
										: properties.getGroupName())
								.apiInfo(createApiInfo()).select()
								.apis(RequestHandlerSelectors.basePackage(
										StrUtils.isBlank(properties.getBasePackage()) ? "com.wy.crl"
												: properties.getBasePackage()))
								.paths(PathSelectors.any()).build()
								.ignoredParameterTypes(properties.getIgnoredParameterTypes());
	}

	private ApiInfo createApiInfo() {
		return new ApiInfoBuilder()
				.title(StrUtils.isBlank(properties.getTitle()) ? "接口文档" : properties.getTitle())
				.description(StrUtils.isBlank(properties.getDescription()) ? "通用接口文档"
						: properties.getDescription())
				.version(StrUtils.isBlank(properties.getVersion()) ? "1.0.0"
						: properties.getVersion())
				.build();
	}
}