package com.signhor.cms.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.signhor.cms.model.User;
import com.signhor.cms.service.UserService;
import com.signhor.cms.util.Captcha;
import com.signhor.cms.web.CmsSessionContext;

@Controller
public class LoginController {

	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {		
		return "admin/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userName, String passWord, String checkCode, Model model, HttpSession session) {
		String cc = (String) session.getAttribute("LoginCheckCode");
		if (checkCode != null && !checkCode.equals(cc)) {
			model.addAttribute("error", "验证码出错，请重新输入");
			return "admin/login";
		}
		
		User loginUser = userService.testService(userName, passWord);
		session.setAttribute("loginUser", loginUser);
		session.setAttribute("isAdmin", true);
		session.removeAttribute("LoginCheckCode");
		CmsSessionContext.addSessoin(session);
		return "redirect:/admin";
	}
	
	
	/**
	 * 
	 * drawCheckCode:生成登录验证码
	 *
	 * @author zfg
	 * @param response
	 * @param session
	 * @throws IOException
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/drawCheckCode")
	public void drawCheckCode(HttpServletResponse response, HttpSession session) throws IOException {
		response.setContentType("image/jpg");
		int width = 200;
		int height = 30;
		Captcha c = Captcha.getInstance();
		c.set(width, height);
		String checkcode = c.generateCheckcode();
		session.setAttribute("LoginCheckCode", checkcode);
		OutputStream os = response.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
	}
}
