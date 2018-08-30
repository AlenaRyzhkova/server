package com.ryzhkova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * Session Bean implementation class ExampleServer
 */
@Stateless
@LocalBean
public class ExampleServer implements ExampleServerRemote, ExampleServerLocal {

    public ExampleServer() { }
    
    @Resource(mappedName="java:/MySqlDS")
    private DataSource db;
    
    @Override
    public List<String> getMsg() {
    	return showFlights();
    }
    
    public List<String> showFlights() {
    	
    	Connection con;
    	List<String> result = null;
		try {
			con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement
	    			("select flights_id, flights_date, flights_depature, flights_destination from flights");
	    	ResultSet rs = stmt.executeQuery();
	    	result = new ArrayList<>();
	    	while(rs.next()) {
	    		result.add(rs.getString(1) + " " + rs.getString(2) + " "
	    				+ rs.getString(3) + " " + rs.getString(4));
	    	}
	    } catch (SQLException e) {
			e.printStackTrace();
		}
    	return result;
    }
}
