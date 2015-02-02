/**
 * 
 */
package com.controller;

import com.jfinal.core.Controller;

/**
 * 用户相关控制类
 * @author macavity
 *
 */
public class UserController extends Controller {
	public void index() {
		renderText("Hello JFinal World.User");
	}

}
