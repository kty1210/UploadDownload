package com.study.erum.fileupload;

import java.util.List;
import java.util.Vector;


public class MyFileDAO extends DBConnPool{

	public int inserFile(MyFileDTO dto) {
		
		int applyResult = 0;
		
		try {
			String query = "insert into myfile (idx, title, cate, ofile, sfile) values (seq_board_num.nextval, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getCate());
			pstmt.setString(3, dto.getOfile());
			pstmt.setString(4, dto.getSfile());
			
			applyResult = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Insert 중 예외 발생");
			e.printStackTrace();
		}
		
		return applyResult;
	}
}
