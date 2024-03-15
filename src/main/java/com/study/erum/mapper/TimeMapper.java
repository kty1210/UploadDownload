package com.study.erum.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	//MyBatis를 사용하면 SQL을 처리할 때 애너테이션을 이용하는 편리할 수 있지만 
	//SQL문이 복잡하거나 길어지는 경우에는 애너테이션 보다는 XML을 사용하는 방식을 더 선호하게 됨.
	@Select("SELECT CURRENT_DATE FROM dual")
	public String getTime();
	
	
	public String getTime2();
}
