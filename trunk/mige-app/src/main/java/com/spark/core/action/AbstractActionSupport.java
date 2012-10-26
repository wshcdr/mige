package com.spark.core.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hgu
 * 
 */
public abstract class AbstractActionSupport extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {
	private static final long		serialVersionUID	= 1L;

	protected ServletContext		servletContext;
	protected Map<String, Object>	session;
	protected HttpServletRequest	request;
	protected HttpServletResponse	response;
	protected ApplicationContext	applicationContext;
	
	public AbstractActionSupport() {
		super();
		servletContext = ServletActionContext.getServletContext();
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	protected <T> T getBean(Class<T> clazz, String name) {
		return clazz.cast(applicationContext.getBean(name));
	}
}
