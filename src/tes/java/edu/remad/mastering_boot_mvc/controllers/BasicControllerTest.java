package edu.remad.mastering_boot_mvc.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@RunWith(SpringRunner.class)
@WebMvcTest(BasicController.class)
public class BasicControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void welcome() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/welcome").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(org.hamcrest.Matchers.equalTo("Hello World")));
	}

	@Test
	public void welcomeWithObject() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/welcome-with-object").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(containsString("Hello World")));
	}

	@Test
	public void welcomeWithParameter() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/welcome-with-parameter/name/Buddy").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(containsString("Hello World, Buddy")));
	}
}