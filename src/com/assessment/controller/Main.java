package com.assessment.controller;

import java.util.*;
import javax.persistence.*;
import com.assessment.dao.ProductDao;
import com.assessment.model.Product;

public class Main {

	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
		while(true) {
		ProductDao pD = new ProductDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to do?");
		String functionality = sc.nextLine();
		switch(functionality) {
		case "Create":
			System.out.println("Enter Name of the product:");
			String productName = sc.nextLine();
			System.out.println("Enter Description of the product:");
			String productDescription = sc.nextLine();
			System.out.println("Enter Quantity of the product:");
			int productQuantity = sc.nextInt();
			System.out.println("Enter Price of the product:");
			int productPrice  = sc.nextInt();
		
			Product p = new Product(productName, productDescription, productQuantity, productPrice);
			pD.create(p);
		
			System.out.println("The product details have been entered.");
			break;
		case "Read":
			ProductDao p4= new ProductDao();
			List<Product> product= p4.findAll();
			for (Product product2 : product) {
				System.out.println(product2.getName()+" "+product2.getDescription()+" "+product2.getPrice()+" "+product2.getQuantity()+" " );
			}
			break;
		case "Update":
			System.out.println("Enter Id");
			long id = sc.nextLong();
			System.out.println("Enter new Name");
			String uname = sc.next();
			System.out.println("Enter new Price");
			int uprice = sc.nextInt();
			System.out.println("Enter new Quantity");
			int uquantity = sc.nextInt();
			ProductDao pDao1=new ProductDao();
			pDao1.update(id, uname,uprice, uquantity);
			System.out.println("Updated Product Details recorded!!");			
			break;
		case "Delete":
			System.out.println("Enter the ID");
			long id1= sc.nextLong();
			ProductDao pDao2= new ProductDao();
			pDao2.delete(id1);
			System.out.println("Deleted");
			break;
			}
		}
	}
}

