package edu.remad.mastering_boot_mvc.integrationtest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import edu.remad.mastering_boot_mvc.MasteringBootMvcApplication;

@SpringBootTest(classes = MasteringBootMvcApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicControllerIT {

	private static final String LOCAL_HOST = "http://localhost:";

	@LocalServerPort
	private int port;

	private TestRestTemplate template = new TestRestTemplate();

	@Test
	public void welcome() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/welcome"), String.class);
		assertThat(response.getBody(), org.hamcrest.Matchers.equalTo("Hello World"));
	}

	@Test
	public void welcomeWithObject() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/welcome-with-object"), String.class);
		assertThat(response.getBody(), containsString("Hello World"));
	}

	@Test
	public void welcomeWithParameter() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/welcome-with-parameter/name/Buddy"),
				String.class);
		assertThat(response.getBody(), containsString("Hello World, Buddy"));
	}

	private String createURL(String uri) {
		return LOCAL_HOST + port + uri;
	}
}