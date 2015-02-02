/**
 * 
 */
package com.route;

import com.controller.UserController;
import com.jfinal.config.Routes;

/**
 * 用户路由配置,用户相关的路由都配置在此
 * @author macavity
 *
 */
public class UserRoute extends Routes {

	@Override
	public void config() {
		add("/user", UserController.class);
	}

}
