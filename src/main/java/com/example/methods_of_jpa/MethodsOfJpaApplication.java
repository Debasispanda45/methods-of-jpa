package com.example.methods_of_jpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MethodsOfJpaApplication implements CommandLineRunner {
	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(MethodsOfJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = Product.builder()
				.productName("I phone")
				.ProductBrand("Apple")
				.productPrice(100000.99)
				.build();
		// save()
		//productRepository.save(product);

		// saveAll()
		//productRepository.saveAll(getProducts());

		// count()
		//System.out.println("Total rows available in the table  : " + productRepository.count());

		// Exist()
		//System.out.println("Is product with id available : "
			//	+ productRepository.existsById("21086dfd-a21c-4c19-a29e-be25581720d4"));

		// delete()
		//productRepository.deleteById("21086dfd-a21c-4c19-a29e-be25581720d4");

		// findall()
		List<Product> products2 = productRepository.findAll();
		//products2.forEach(System.out::println);

		List<Product> products3 = productRepository.findAll(Sort.by(Direction.ASC, "productPrice"));
		//products3.forEach(System.out::println);

		//pagination
		// Page<Product> products4 = productRepository.findAll(PageRequest.of(0, 3));
		Page<Product> products4 = productRepository.findAll(PageRequest.of(1, 3, Sort.by(Direction.DESC, "productPrice")));

		products4.forEach(System.out::println);

	}

	private List<Product> getProducts() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		return numbers.stream()
				.map(number -> Product.builder()
						.productName("Product - " + number)
						.ProductBrand("Brand - " + number)
						.productPrice(number * 1000.50)
						.build())
				.toList();
	}

}
