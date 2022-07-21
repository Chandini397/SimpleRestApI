package com.example.HelloWorld;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HelloWorldApplicationTests {

	@Autowired
	HelloWorldController helloWorldController;

	@Autowired
	HelloWorldApplication helloWorldApplication;

	@Test
	void testingHelloWorld() {
		assertEquals("Hello World",
				helloWorldController.sayHello());
	}

	@Test
	void testingHeyWorld() {
		assertEquals("Hey World",
				helloWorldApplication.sayHello());
	}

}
