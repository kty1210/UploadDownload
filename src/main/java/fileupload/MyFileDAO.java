package fileupload;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

public class MyFileDAO extends DBConnPool { 
	// 새로운 게시물을 입력합니다.
    public int insertFile(MyFileDTO dto) {
        int applyResult = 0;
        try {
            String query = "INSERT INTO myfile ( "
                + " idx, title, cate, ofile, sfile) "
                + " VALUES ( "
                + " seq_board_num.nextval, ?, ?, ?, ?)";
                        
            psmt = con.prepareStatement(query);
            psmt.setString(1, dto.getTitle());
            psmt.setString(2, dto.getCate());
            psmt.setString(3, dto.getOfile());
            psmt.setString(4, dto.getSfile());
        
            applyResult = psmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("INSERT 중 예외 발생");
            e.printStackTrace();
        }        
        return applyResult;
    }

    
}

