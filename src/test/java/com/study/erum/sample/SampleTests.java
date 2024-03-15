package com.study.erum.sample;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//JUnit 테스트에서 Spring의 기능을 사용할 수 있게 도와줌
@RunWith(SpringJUnit4ClassRunner.class)
//경로에 있는 bean 설정 로드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//log 체킹
@Log4j 

public class SampleTests {
	
	@Autowired
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		
		// null값 아닌지 확인
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("-------------------------------------");
		log.info(restaurant.getChief());
	}	
}
