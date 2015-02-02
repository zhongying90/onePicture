/**
 * 
 */
package com.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.model.User;
import com.route.UserRoute;

/**
 * @author macavity
 *
 */
public class OnePicConfig extends JFinalConfig {
	/**
	 * 此方法用来配置 JFinal 常量值，如开发模式常量 devMode 的配置
	 * 在开发模式下，JFinal 会对每次请求输出报告，如输出本次请求的 Controller、Method 
	 * 以及请求所携带的参数。JFinal 支持 JSP、FreeMarker、Velocity 三种常用视图。
	 * 默认为FreeMarker视图
	 */
	public void configConstant(Constants me) {
		me.setDevMode(true);//开发模式
	}

	/**
	 * 配置 JFinal 访问路由
	 */
	public void configRoute(Routes me) {
		me.add(new UserRoute());//用户路由
	}

	/**
	 * 插件配置
	 */
	public void configPlugin(Plugins me) {
		//dbConfig(me);//数据库插件
	}

	/**
	 * 拦截器配置
	 */
	public void configInterceptor(Interceptors me) {
	}

	/**
	 * 处理器配置
	 */
	public void configHandler(Handlers me) {
	}

	
	/**
	 * 数据库插件配置
	 */
	public void dbConfig(Plugins me){
		loadPropertyFile("onePicture.properties");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),
		getProperty("user"), getProperty("password"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("user", User.class);
	}
	
}
