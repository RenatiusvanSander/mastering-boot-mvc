package edu.remad.mastering_boot_mvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import edu.remad.mastering_boot_mvc.services.TodoService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FullStackTest {
	
	@Autowired
	private TodoService todoService;
	
	@Test
	public void test() {
		assert(todoService != null);
	}
}
