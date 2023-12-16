package edu.remad.mastering_boot_mvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import edu.remad.mastering_boot_mvc.bean.WelcomeBean;
import edu.remad.mastering_boot_mvc.services.TodoService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class FullStackTest {
	
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void test() {
		assert(todoService != null);
	}
	
	@Test
	public void restTemplateTest() {
		String endpoint = "/welcome/project/1";
		WelcomeBean welcomeBean = this.restTemplate.getForObject(endpoint, WelcomeBean.class);
		assert(welcomeBean.getMessage().contains("The id was: 1!"));
	}
}
