package edu.remad.mastering_boot_mvc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.remad.mastering_boot_mvc.bean.WelcomeBean;

@RestController
public class BasicController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Hello World";
	}

	@GetMapping("/welcome-with-object")
	public WelcomeBean welcomeWithObject() {
		return new WelcomeBean("Hello World");
	}

	private static final String helloWorldTemplate = "Hello World, %s!";

	@GetMapping("/welcome-with-parameter/name/{name}")
	public WelcomeBean welcomeWithParameter(@PathVariable String name) {
		return new WelcomeBean(String.format(helloWorldTemplate, name));
	}
	
	@ResponseBody
	@GetMapping("/welcome/project/{id}")
	public WelcomeBean welcomeProjectParameter(@PathVariable Long id) {
		return new WelcomeBean(String.format("The id was: %d!", id));
	}
}