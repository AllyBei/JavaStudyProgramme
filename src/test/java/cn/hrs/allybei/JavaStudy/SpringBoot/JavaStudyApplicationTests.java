package cn.hrs.allybei.JavaStudy.SpringBoot;

import cn.hrs.allybei.JavaStudy.SpringBoot.testYaml.ItInventory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaStudyApplicationTests {

	@Autowired
	ItInventory itInventory;
	@Test
	void contextLoads() {
		System.out.println(itInventory);
	}

}
