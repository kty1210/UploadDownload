package com.study.erum.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Getter
@Component
@ToString
// @AllArgsConstructor 생성자 자동 생성
public class SampleHotel {

	private Chief chief;
	
	public SampleHotel(Chief chief) {
		this.chief = chief;
	}


}
