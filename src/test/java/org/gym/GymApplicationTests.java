package org.gym;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GymApplicationTests {
	@Test
	void MyDummyTest() {
		Assertions.assertEquals(2, 1+1);
	}
}
