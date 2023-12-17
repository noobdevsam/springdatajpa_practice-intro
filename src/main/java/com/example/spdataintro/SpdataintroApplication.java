package com.example.spdataintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpdataintroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpdataintroApplication.class, args);
	}

	@Bean
	CommandLineRunner bootstrap(ProductRepo prepo, VendorRepo vrepo) {
		return args -> {
			List<Product> products = List.of(
				new Product("Fan"), new Product("Bulb"), new Product("Switch")
			);
			prepo.saveAll(products);

			List<Vendor> vendors = List.of(
				new Vendor("Company X"), new Vendor("Company Y"), new Vendor("Company Z")
			);
			vrepo.saveAll(vendors);
	
			prepo.findAll().stream().forEach(System.out::println);
			System.out.println("--------------------------------");
			vrepo.findAll().stream().forEach(System.out::println);
		};
	}

}



@Entity
@NoArgsConstructor
@Data
class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String name;

	public Product(String name) {
		this.name = name;
	}

	// using new procedure to implement UUID as a primary key 
}

@Entity
@NoArgsConstructor
@Data
class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String name;
	
	public Vendor(String name) {
		this.name = name;
	}
	
	// using new procedure to implement UUID as a primary key
}

interface ProductRepo extends ListCrudRepository<Product,UUID>{}

interface VendorRepo extends ListCrudRepository<Vendor,UUID>{}
