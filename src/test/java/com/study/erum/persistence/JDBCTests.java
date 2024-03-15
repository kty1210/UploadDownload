package com.study.erum.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

//log 체킹
@Log4j
public class JDBCTests {
	static {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection con = 
			DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE",
				"webdb",
				"12345")){
			log.info(con);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}