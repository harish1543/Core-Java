package com.ltts.ProductionDB.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.ProductionDB.Configuration.myConfig;
import com.ltts.ProductionDB.model.Movie;
import com.ltts.ProductionDB.model.Production;

public class ProductionDao {
	
	// insert new data entry in production table
	public boolean insertProduction(Production p) throws Exception {
		Connection c = myConfig.getConnection();
		Statement s = c.createStatement();
		
		try {
			String insertQuery = "insert into production values("+p.getProductionId()+",'"+p.getProductionName()+"','"+p.getAddress()+"',"+p.getStartDate()+",'"+p.getOwnerName()+"')";
			s.execute(insertQuery);
		}catch(Exception e){
			
			System.out.println(e);
			return false;
		}finally{
			c.close();
		}	
		return true;
	}
	
	// insert new data entry in movie table
	public boolean insertMovie(Movie m) throws Exception {
		Connection c = myConfig.getConnection();
		Statement s = c.createStatement();
		
		try {
			String insertQuery = "insert into movie values("+m.getMovieId()+",'"+m.getMovieName()+"','"+m.getHeroname()+"','"+m.getHeroineName()+"','"+m.getReleaseDate()+"','"+m.getLanguage()+"',"+m.getLength()+",'"+m.getMovieType()+"',"+m.getProductionId()+")";
			s.execute(insertQuery);
		}catch(Exception e){
			
			System.out.println(e);
			return false;
		}finally{
			c.close();
		}	
		return true;
	}
	
	//update String type column in production table
	public boolean updateProduction(String column, String value, int key) throws Exception
	{
		Connection c = myConfig.getConnection();
		try{
			String updateQuery = "update production set "+column+"='"+value+"' where productionid ="+key;
			PreparedStatement ps = c.prepareStatement(updateQuery);
			ps.executeUpdate();
			return true;
		}catch(Exception e)
		{			
			System.out.println(e);
			return false;
		}finally {
			c.close();
		}
		
	}
	
	//update String type column in movie table
	public boolean updateMovie(String column, String value, int key) throws Exception
	{
		Connection c = myConfig.getConnection();
		try{
			String updateQuery = "update movie set "+column+"='"+value+"' where movieid ="+key;
			PreparedStatement ps = c.prepareStatement(updateQuery);
			ps.executeUpdate();
			return true;
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}finally {
			c.close();
		}
		
	}
	
	//delete data from Production table 
	public boolean deleteProduction(int key) throws Exception
	{
		Connection c = myConfig.getConnection();
		try {
			String deleteQuery = "delete from movie where movieid ="+key;
			PreparedStatement ps = c.prepareStatement(deleteQuery);
			ps.execute();
			return true;
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}finally {
			c.close();
		}
	}
	
	//delete data from Movie Table
	public boolean deleteMovie(int key) throws Exception
	{
		Connection c = myConfig.getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("delete from movie where movieid ="+key);
			ps.execute();
			return true;
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	// display production table
	public List<Production> displayProduction() throws Exception{
		
		List<Production> li = new ArrayList<Production>();
		Connection c = myConfig.getConnection();
		PreparedStatement ps = c.prepareStatement("select * from production");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			li.add(new Production(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
		}
		
		return li;

	}
	
	//display movie table
	
	public List<Movie> displayMovie() throws Exception{
		
		List<Movie> li = new ArrayList<Movie>();
		Connection c = myConfig.getConnection();
		PreparedStatement ps = c.prepareStatement("select * from movie");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			li.add(new Movie(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
		}
		
		return li;

	}

}
