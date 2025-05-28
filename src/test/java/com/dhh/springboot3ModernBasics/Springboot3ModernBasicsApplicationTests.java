package com.dhh.springboot3ModernBasics;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class Springboot3ModernBasicsApplicationTests {

	@Test
	void contextLoads() {
	}

}
