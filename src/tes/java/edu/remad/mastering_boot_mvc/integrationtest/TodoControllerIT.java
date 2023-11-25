package edu.remad.mastering_boot_mvc.integrationtest;

import java.net.URI;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import edu.remad.mastering_boot_mvc.MasteringBootMvcApplication;
import edu.remad.mastering_boot_mvc.bean.Todo;

@SpringBootTest(classes = MasteringBootMvcApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerIT {

	@LocalServerPort
	private int port;

	private TestRestTemplate template = new TestRestTemplate();

	@Test
	public void retrieveTodos() throws Exception {
		String expected = "[" + "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}" + ","
				+ "{id:2,user:Jack,desc:\"Learn Struts\",done:false}" + "]";

		String uri = "/users/Jack/todos";

		ResponseEntity<String> response = template.getForEntity(createUrl(uri), String.class);

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void retrieveTodo() throws Exception {
		String expected = "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}";
		ResponseEntity<String> response = template.getForEntity(createUrl("/users/Jack/todos/1"), String.class);
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void addTodo() throws Exception {
		Todo todo = new Todo(-1, "Jill", "Learn Hibernate", new Date(), false);
		URI location = template.postForLocation(createUrl("/users/Jill/todos"), todo);
		org.hamcrest.MatcherAssert.assertThat(location.getPath(),
				org.hamcrest.Matchers.containsString("/users/Jill/todos/4"));
	}

	private String createUrl(String uri) {
		return "http://localhost:" + port + uri;
	}
}