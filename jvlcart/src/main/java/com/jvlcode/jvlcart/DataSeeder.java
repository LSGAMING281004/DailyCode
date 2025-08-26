package com.jvlcode.jvlcart;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jvlcode.jvlcart.modles.Product;
import com.jvlcode.jvlcart.repositories.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String ...args) throws Exception{
		//Check if the table is empty
		if(productRepository.count()==0)
		{
			//Seed demo data
			List<Product> products = Arrays.asList(
					new Product("Realme 8 5g",20.988, "My Mobile:",5.0,"Smartphone","Lokesh",50,5674,Arrays.asList("https://picsum.photos/200/300"))
					);
			
			productRepository.saveAll(products);
			System.out.println("Demo data seeded");
		}
	}
}
