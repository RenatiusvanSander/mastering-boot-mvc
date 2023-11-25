package edu.remad.mastering_boot_mvc;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MasteringBootMvcApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MasteringBootMvcApplication.class, args);
		
		String[] beanNames = ctx.getBeanDefinitionNames();
	    Arrays.sort(beanNames);

	   for (String beanName : beanNames) {
	     System.out.println(beanName);
	    }
	}
}