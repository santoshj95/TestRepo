package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Address;
@Repository
public class TestDaoImpl implements TestDao{
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	DriverManagerDataSource dataSource;
	
	@Transactional
	public void transactionExample() {
			
		Connection conn=getConnection();
		try {			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO data1(id,NAME) VALUES(?,?)");			
			for(int i=2;i<6;i++) {			
				ps.setInt(1, i);
				ps.setString(2, ("w"+i));
				int k = ps.executeUpdate();
				if(i==3)
					throw new RuntimeException();
				System.out.println("Result : "+ k);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

	
	private Connection getConnection() {
		
		Connection conn=null;
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	@Override
	public void saOneTone(Address adr) {
		// TODO Auto-generated method stub
		
	}
}
