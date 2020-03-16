package com.wy;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wy.utils.StrUtils;

/**
 * 基础servlet类,在contrller方法之前统一处理request和response,且是线程安全的
 * ModelAttribute:在controller内,在执行其他requestmapping方法之前都先执行modelattribute注解的方法;放在参数上时,表明引用参数中的值
 * @author 万杨
 */
public class BaseContext {

	private static final ThreadLocal<HttpServletRequest> requestContainer = new ThreadLocal<HttpServletRequest>();

	private static final ThreadLocal<HttpServletResponse> responseContainer = new ThreadLocal<HttpServletResponse>();

	private static final ThreadLocal<ModelMap> modelContainer = new ThreadLocal<ModelMap>();

	protected HttpSession session;

	protected ServletContext servletContext;// 上下文对象

	protected WebApplicationContext webApplicationContext;// 整个spring的上下文

	protected WebApplicationContext springApplicationContext;// springmvc的上下文

	@ModelAttribute
	private final void initResponse(HttpServletResponse response) {
		responseContainer.set(response);
	}

	/**
	 * 获取当前线程的response对象
	 */
	protected final HttpServletResponse getResponse() {
		return responseContainer.get();
	}

	/**
	 * 初始化request
	 */
	@ModelAttribute
	private final void initRequest(HttpServletRequest request) {
		requestContainer.set(request);
	}

	/**
	 * 获取当前线程的request对象
	 */
	protected final HttpServletRequest getRequest() {
		HttpServletRequest request = requestContainer.get();
		this.session = request.getSession();
		this.servletContext = session.getServletContext();
		this.webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.springApplicationContext = RequestContextUtils.findWebApplicationContext(request);
		return request;
	}

	/**
	 * 设置model
	 */
	@ModelAttribute
	private final void initModelMap(ModelMap model) {
		modelContainer.set(model);
	}

	/**
	 * 获取当前线程的modelMap对象
	 */
	protected final ModelMap getModelMap() {
		return modelContainer.get();
	}

	public String get(String param) {
		return getRequest().getParameter(param);
	}

	public String get(String param, String defaultValue) {
		String value = getRequest().getParameter(param);
		return StrUtils.isBlank(value) ? defaultValue : value;
	}

	public int get(String param, int defaultValue) {
		String value = getRequest().getParameter(param);
		return StrUtils.isBlank(value) ? defaultValue : Integer.valueOf(value);
	}

	public long get(String param, long defaultValue) {
		String value = getRequest().getParameter(param);
		return StrUtils.isBlank(value) ? defaultValue : Long.valueOf(value);
	}
}