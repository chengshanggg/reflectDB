package com.shou.hjn;

import com.shou.hjn.utils.ReadPropertiesFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReflectDbApplicationTests {
	@Autowired
	ReadPropertiesFile readPropertiesFile;

	@Test
	public void contextLoads() {
	}


	@Test
	public void test(){
		readPropertiesFile.getSqlByName();
		System.out.println(readPropertiesFile.getMap().toString());
	}
}
