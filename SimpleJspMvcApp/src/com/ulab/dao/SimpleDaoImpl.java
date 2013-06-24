package com.ulab.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ulab.model.Simple;

public class SimpleDaoImpl {
	java.sql.Connection con;
	Simple simple;

	public Simple getSimple(Integer recordNo) {
		PreparedStatement pstmt;
		ResultSet rs;
		Simple simple = null;
		try {
			pstmt = con.prepareStatement("select * from ulab_records where id=?");
			pstmt.setInt(1, recordNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				simple = new Simple();
				simple.setId(rs.getString("id"));
				simple.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println("Error on getSimple");
		}
		return simple;
	}

	public void setSimple(Simple simple) {
		System.out.println("---------------");
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("insert into simple values(?,?)");
			pstmt.setString(1, simple.getId());
			pstmt.setString(2, simple.getName());
			pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error in prepared statement");
		}
		System.out.println("Data Successfully entered");
	}

	public SimpleDaoImpl() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "ulabdb", "root");
		} catch (SQLException e) {
			System.out.println("Connection failed");
		}
	}
}
