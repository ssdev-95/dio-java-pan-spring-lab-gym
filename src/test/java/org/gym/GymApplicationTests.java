package org.gym;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
class GymApplicationTests {
	@Test
	void contextLoads() {
		Assertions.assertEquals(2, 1+1);
	}
}
