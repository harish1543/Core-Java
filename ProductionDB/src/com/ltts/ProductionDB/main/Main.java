package com.ltts.ProductionDB.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
//import java.time.LocalDate;
import java.util.List;

import com.ltts.ProductionDB.model.*;
import com.ltts.ProductionDB.dao.*;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Choose Operation:\n1. Insert\n2. Update\n3. Delete\n4. Display");
		int choice = Integer.parseInt(br.readLine());
		
		if(choice==1) {
			
			System.out.println("Choose Table:\n1. Production\n2. Movie");
			int tableChoice = Integer.parseInt(br.readLine());
			if (tableChoice==1){
				Production p = new Production();
				System.out.println("Insert operation");
				System.out.println("Enter Production ID:");
				int productionId = Integer.parseInt(br.readLine());
				System.out.println("Enter Production Name:");
				String prodName = br.readLine();
				System.out.println("Enter Address:");
				String address = br.readLine();
				System.out.println("Enter Starting Date:");
				int startDate = Integer.parseInt(br.readLine());
				System.out.println("Enter Owner Name:");
				String ownerName = br.readLine();
				p.setProductioId(productionId);
				p.setProductionName(prodName);
				p.setAddress(address);
				p.setStartDate(startDate);
				p.setOwnerName(ownerName);
				
				ProductionDao pd = new ProductionDao();
				if(pd.insertProduction(p))
				{
					System.out.println("Insertion Successful");
				}else {
					System.out.println("Operation Failed");
				}
			}else if(tableChoice ==2) {		
				Movie m = new Movie();
				
				System.out.println("Enter Movie ID:");
				int movieId = Integer.parseInt(br.readLine());
				System.out.println("Enter Movie Name:");
				String movieName = br.readLine();
				System.out.println("Enter Hero Name:");
				String heroName = br.readLine();
				System.out.println("Enter Heroine Name");
				String heroineName = br.readLine();
				System.out.println("Enter release Date(dd/mm/yyyy):");
				String releaseDate = br.readLine();
				//String dateSplit[] = date.split("/");
				//LocalDate releaseDate = LocalDate.of(Integer.parseInt(dateSplit[2]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[0]));
				System.out.println("Enter language:");
				String language = br.readLine();
				System.out.println("Enter Movie length:");
				int length = Integer.parseInt(br.readLine());
				System.out.println("Enter Movie type:");
				String  movieType = br.readLine();
				System.out.println("Enter Production ID");
				int productionId = Integer.parseInt(br.readLine());
				
				m.setMovieId(movieId);
				m.setMovieName(movieName);
				m.setHeroname(heroName);
				m.setHeroineName(heroineName);
				m.setReleaseDate(Date.valueOf(releaseDate));
				m.setLanguage(language);
				m.setLength(length);
				m.setMovieType(movieType);
				m.setProductionId(productionId);
				
				ProductionDao pd = new ProductionDao();
				if(pd.insertMovie(m))
				{
					System.out.println("Insertion Successful");
				}else{
					System.out.println("Operation Failed");
				}
			}else{
				System.out.println("Invalid Choice");
			}
		}else if(choice == 2)
		{
			System.out.println("Choose Table:\n1. Production\n2. Movie");
			int tableChoice = Integer.parseInt(br.readLine());
			if (tableChoice==1){
				System.out.println("Enter column name:");
				String column = br.readLine();
				System.out.println("Enter new value:");
				String value = br.readLine();
				System.out.println("Enter key");
				int key = Integer.parseInt(br.readLine());
				ProductionDao pd = new ProductionDao();
				if(pd.updateProduction(column,value,key))
				{
					System.out.println("Updation Successful");
				}else{
					System.out.println("Operation Failed");
				}
				
			}else if(tableChoice==2) {		
				System.out.println("Enter column name:");
				String column = br.readLine();
				System.out.println("Enter new value:");
				String value = br.readLine();
				System.out.println("Enter key");
				int key = Integer.parseInt(br.readLine());
				ProductionDao pd = new ProductionDao();
				if(pd.updateMovie(column,value,key))
				{
					System.out.println("Updation Successful");
				}
				else{
					System.out.println("Operation Failed");
				}
			}else {
				System.out.println("Invalid Choice");
			}
			
		}else if(choice == 3)
		{
			System.out.println("Choose Table:\n1. Production\n2. Movie");
			int tableChoice = Integer.parseInt(br.readLine());
			if (tableChoice==1){
				ProductionDao pd = new ProductionDao();
				System.out.println("Enter production ID to delete:");
				int key = Integer.parseInt(br.readLine());
				if(pd.deleteProduction(key))
				{
					System.out.println("Deletion Successful");
				}else {
					System.out.println("Operation Failed");
				}
			}else if(tableChoice==2) {
				ProductionDao pd = new ProductionDao();
				System.out.println("Enter movie ID to delete:");
				int key = Integer.parseInt(br.readLine());
				if(pd.deleteMovie(key))
				{
					System.out.println("Deletion Successful");
				}else {
					System.out.println("Operation Failed");
				}
			}else {
				System.out.println("Invalid Choice");
			}
			
	
		}else if(choice==4)
		{
			System.out.println("Choose Table:\n1. Production\n2. Movie");
			int tableChoice = Integer.parseInt(br.readLine());
			if (tableChoice==1){
			ProductionDao pd =new ProductionDao();
			
			List<Production> prodList = pd.displayProduction();
						
			for(Production p :prodList)
			{
				System.out.println(p);
			}
			}else if(tableChoice==2)
			{
				ProductionDao pd =new ProductionDao();
				
				List<Movie> movieList = pd.displayMovie();
				
				for(Movie m:movieList)
				{
					System.out.println(m);
				}
			}else {
				System.out.println("Invalid Choice");
			}
		}else {
			System.out.println("Invalid Choice");
		}
	}
}
		
		

