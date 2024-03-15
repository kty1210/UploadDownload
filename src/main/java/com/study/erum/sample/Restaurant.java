package com.study.erum.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Restaurant {
	
	@Autowired
	private Chief chief;
	//Chief 주입
}
