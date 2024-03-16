package com.study.erum.fileupload;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DBConnPool {
	protected PreparedStatement pstmt = null;
    protected Connection conn = null;
    protected String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 URL
    protected String user = "webdb"; // 데이터베이스 사용자 이름
    protected String password = "12345"; // 데이터베이스 비밀번호

    public DBConnPool() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // JDBC 드라이버 로드
            this.conn = DriverManager.getConnection(url, user, password); // 데이터베이스 연결
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
