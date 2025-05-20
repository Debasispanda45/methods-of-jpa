package com.example.methods_of_jpa;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
		// Product product = Product.builder()
		Product.builder()
				.productName("I phone")
				.productBrand("Apple")
				.productPrice(100000.99)
				.build();
		// save()
		// productRepository.save(product);

		// saveAll()
		// productRepository.saveAll(getProducts());

		// count()
		// System.out.println("Total rows available in the table : " +
		// productRepository.count());

		// Exist()
		// System.out.println("Is product with id available : "
		// + productRepository.existsById("21086dfd-a21c-4c19-a29e-be25581720d4"));

		// delete()
		// productRepository.deleteById("21086dfd-a21c-4c19-a29e-be25581720d4");

		// findall()
		List<Product> products2 = productRepository.findAll();
		// products2.forEach(System.out::println);

		List<Product> products3 = productRepository.findAll(Sort.by(Direction.ASC, "productPrice"));
		// products3.forEach(System.out::println);

		// pagination
		// Page<Product> products4 = productRepository.findAll(PageRequest.of(0, 3));
		// Page<Product> products4 = productRepository
		// .findAll(PageRequest.of(1, 3, Sort.by(Direction.DESC, "productPrice")));

		// products4.forEach(System.out::println);

		// Optional<Product> optProduct = productRepository
		// .findById("21086dfd-a21c-4c19-a29e-be25581720d4");
		// Product existingProduct = optProduct.orElseThrow(() -> new
		// NoSuchElementException("Product not found by id "));
		// System.out.println("Product found by id : " + existingProduct);

		// Optional<Product> optProduct =
		// productRepository.findById("3386d76a-c7c9-4bbf-82ea-0258b9bc6e7f");
		// Product existingProduct = optProduct.orElseThrow(() -> new
		// NoSuchElementException("Product not found by id "));

		// System.out.println("Before update : " + existingProduct);

		// existingProduct.setProductName("Iphone 17 pro max");
		// existingProduct.setProductPrice(150000.33);

		// Product savedProduct = productRepository.save(existingProduct);
		// System.out.println("Product updated : " + savedProduct);

		// findByProductName
		// Optional<Product> optProduct = productRepository.findByProductName("Iphone 17 pro max");
		// Product productByName = optProduct.orElseThrow();
		// System.out.println("Product found by name : " + productByName);

		// findAllByProductPriceBetween
		// List<Product> productPriceBetween = productRepository.findAllByProductPriceBetween(1000.00, 5000.00);
		// productPriceBetween.forEach(System.out::println);

		//greaterThan
		// List<Product> productPriceGreaterThan = productRepository.findAllByProductPriceGreaterThan(10000.00, Sort.by(Direction.ASC, "productPrice"));
		// productPriceGreaterThan.forEach(System.out::println);

		// findAllByProductBrandAndProductPrice
		Optional<Product> productByBrandAndPrice = productRepository
				.findAllByProductBrandAndProductPrice("Apple Ind", 150000.33);
				System.out.println("Product found by brand and price : " + productByBrandAndPrice.orElseThrow(() -> new NoSuchElementException("Product not found by brand and price")));
	}

	private List<Product> getProducts() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		return numbers.stream()
				.map(number -> Product.builder()
						.productName("Product - " + number)
						.productBrand("Brand - " + number)
						.productPrice(number * 1000.50)
						.build())
				.toList();
	}

}
