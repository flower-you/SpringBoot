package com.yan.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yan.biz.IUserServ;
import com.yan.entity.UserBean;

@Controller
@RequestMapping("/")
@SessionAttributes("loginUser")
public class UserController {
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) throws Exception {
		model.addAttribute("user", new UserBean());
		return "user/login";
	}

	@Autowired
	private IUserServ userv;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") UserBean user, Errors errors, Model model) throws Exception {
		boolean bb = userv.login(user);
		if (bb) {
			model.addAttribute("loginUser", user);
			return "welcome";
		} else {
			model.addAttribute("msg", "登录失败！");
			return "user/login";
		}
	}
}
