// DBConnPool.java
package com.study.erum.fileupload;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnPool {
    protected Connection conn;

    // 데이터베이스 연결 설정
    public DBConnPool() {
        try {
            String dbURL = "jdbc:mysql://localhost:3306/database_name";
            String dbID = "username";
            String dbPassword = "password";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 오류:");
            e.printStackTrace();
        }
    }
}