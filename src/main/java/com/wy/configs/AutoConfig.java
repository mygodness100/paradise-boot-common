package com.wy.configs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.wy.yml.UserYml;

/**
 * @description 写一个自动装配类,{@link HttpEncodingAutoConfiguration}
 * @instruction 自动配置类需要写在resources下的META-INF下的spring-factories中,参考某个spring的jar包,
 *              需要在该factories文件中添加org.springframework.boot.autoconfigure.EnableAutoConfiguration的固定格式
 * @EnableConfigurationProperties 该注解里的值是需要自动加载的配置文件类
 * @ConditionalOnWebApplication 判断当前应用是否web项目,若是,则配置生效,根据情况可用可不用
 * @ConditionalOnClass 当有某个类的时候才生效,根据情况可用可不用
 * @ConditionalOnProperty 判断当前应用中是否存在某个prefix中的配置,value表示某个prefix中的属性,
 *                        matchIfMissing表示即使没有value中的值,该配置也是生效的
 *                        类似于一个开关,若enabled为false则不生效
 * @author paradiseWy 2019年4月6日 上午9:28:05
 * @git {@link https://github.com/mygodness100}
 */
@Configuration
@EnableConfigurationProperties(UserYml.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@ConditionalOnClass(CharacterEncodingFilter.class)
@ConditionalOnProperty(prefix = "user.yml", value = "enabled", matchIfMissing = true)
public class AutoConfig {

}