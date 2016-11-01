package com.dream.jie.huang.Excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��ѯSQL��JDBC
 * @author Dؼream
 *
 */
public class JDBC {

	
    private static String URL = "jdbc:oracle:thin:@10.211.137.206:1521:remedy";
    private static String ORACLEDRIVER="oracle.jdbc.driver.OracleDriver";
    private static String USER = "mgslm";
    private static String PWD = "dcits0okm";
    private static Connection conn;


    private static void getConnection(){
        try {
            Class.forName(ORACLEDRIVER);
            conn= DriverManager.getConnection(URL,USER,PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
	private static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet Select(String sql) {
        JDBC.getConnection();
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
