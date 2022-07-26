package space.gavinklfong.demo.streamapi;

import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;
import space.gavinklfong.demo.streamapi.models.Customer;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.CustomerRepo;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

@Slf4j
@DataJpaTest
public class StreamApiTest {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ProductRepo productRepo;

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
	@Disabled
	public void exercise1() {

		Predicate<Product> isBooksCategory = product -> product.getCategory().equals("Books");
		Predicate<Product> isGreaterThanHundredPrice = product -> product.getPrice() > 100;

		List<Product> filteredProducts = productRepo.findAll().stream()
				.filter(product -> isBooksCategory.and(isGreaterThanHundredPrice).test(product))
				.collect(Collectors.toList());

		filteredProducts.forEach(System.out::println);

	}

	@Test
	@DisplayName("Obtain a list of order with products belong to category “Baby”")
	public void exercise2(){
		BiPredicate<Order, String> predicate = (Order order, String category) -> order.getProducts().stream()
				.anyMatch(
						product -> product.getCategory().equalsIgnoreCase(category)
				);

		List<Order> orderList = orderRepo.findAll().stream()
						.filter(order -> predicate.test(order, "Baby"))
						.collect(Collectors.toList());

		orderList.forEach(System.out::println);
	}

	@Test
	@DisplayName("Obtain a list of product with category = “Toys” and then apply 10% discount")
	public void excersice3(){
		Predicate<Product> predicate = product -> product.getCategory().equalsIgnoreCase("Toys");
		BiFunction<Product, Double, Product> alterPrice = (Product product, Double value) -> {
			product.withPrice(product.getPrice() * value);
			return product;
		};

		List<Product> products = productRepo.findAll().stream()
				.filter(predicate)
				.map(product -> alterPrice.apply(product, 0.9))
				.collect(Collectors.toList());

		System.out.println(products);
	}

	@Test
	@DisplayName("Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021")
	public void exercise4(){
		Predicate<Customer> predicateCustomerTier2 = customer -> customer.getTier().equals(2);
		Predicate<LocalDate> isInPeriod = (date) -> {
			LocalDate dateBegin = LocalDate.of(2021, 02, 01);
			LocalDate dateEnds = LocalDate.of(2021, 04, 01);

			return dateBegin.isBefore(date) && dateEnds.isAfter(date);
		};

		List<Product> productList = orderRepo.findAll().stream()
				.filter(order -> predicateCustomerTier2.test(order.getCustomer()))
				.filter(order -> isInPeriod.test(order.getOrderDate()))
				.map(Order::getProducts)
				.flatMap(Set::stream)
				.distinct()
				.sorted(Comparator.comparing(Product::getId))
				.collect(Collectors.toList());

		productList.forEach(o -> log.info(o.toString()));

	}

	@Test
	@DisplayName("Get the cheapest products of “Books” category")
	public void exercise5(){
		Predicate<Product> isBookCategory = product -> product.getCategory().equalsIgnoreCase("Books");

		Optional<Product> cheapestProduct = productRepo.findAll().stream()
				.filter(isBookCategory)
				.min(Comparator.comparing(Product::getPrice));

		log.info(cheapestProduct.get().toString());
	}

	@Test
	@DisplayName("Get the 3 most recent placed order")
	public void exercise6(){

		List<Order> listOrders = orderRepo.findAll().stream()
						.sorted(Comparator.comparing(Order::getOrderDate).reversed())
						.limit(3)
						.collect(Collectors.toList());
		listOrders.forEach(order -> log.info("Order: " + order.toString()));
	}

	@Test
	@DisplayName("Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list")
	public void exercise7(){

		Predicate<Order> wasOrderedOn15March = order -> order.getOrderDate().isEqual(LocalDate.of(2021, 03, 15));

		List<Product> listOrders = orderRepo.findAll().stream()
				.filter(wasOrderedOn15March)
					.peek(order -> log.info("Order: " + order.toString()))
				.map(Order::getProducts)
				.flatMap(Set::stream)
				.distinct()
				.collect(Collectors.toList());

		listOrders.forEach(p -> log.info("Product: " +  p));
	}

	@Test
	@DisplayName("Calculate total lump sum of all orders placed in Feb 2021")
	public void exercise8(){

		Predicate<Order> wasOrderedOnFeb = order -> {
			LocalDate date = LocalDate.of(2021, 02, 01);

			return date.getMonth() == order.getOrderDate().getMonth() && date.getYear() == order.getOrderDate().getYear();
		};

		Optional<Double> value = orderRepo.findAll().stream()
				.filter(wasOrderedOnFeb)
				.map(Order::getProducts)
				.flatMap(Set::stream)
				.map(Product::getPrice)
				.reduce(Double::sum);

		value.ifPresent(aDouble -> log.info("Sum: " + aDouble));

	}

	@Test
	@DisplayName("Calculate order average payment placed on 14-Mar-2021")
	public void exercise9(){

		Predicate<Order> wasOrderedOnMarch = order -> {
			LocalDate date = LocalDate.of(2021, 03, 14);

			return date.isEqual(order.getOrderDate());
		};

		BiFunction<Double, Product, Double> acumulador = (acc, product) -> acc + product.getPrice();

		double value = orderRepo.findAll().stream()
				.filter(wasOrderedOnMarch)
				.flatMap(order -> order.getProducts().stream())
				.mapToDouble(Product::getPrice).average().getAsDouble();


		log.info("Value: " + value);

	}

	@Test
	@DisplayName("Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category “Books”")
	public void exercise10(){
		Predicate<Product> isBookCategory = product -> product.getCategory().equalsIgnoreCase("Books");

		DoubleSummaryStatistics statistics = productRepo.findAll().stream()
				.filter(isBookCategory)
				.mapToDouble(Product::getPrice)
				.summaryStatistics();

		log.info("Data: " +
				"\n\tSUM: " + statistics.getSum() +
				"\n\tAVG: " + statistics.getAverage() +
				"\n\tMAX: " + statistics.getMax() +
				"\n\tMIN: " + statistics.getMin() +
				"\n\tCOUNT: " + statistics.getCount());

	}

	@Test
	@DisplayName("Obtain a data map with order id and order’s product count")
	public void exercise11(){
		Map<Long, Integer> result = orderRepo.findAll().stream()
				.collect(Collectors.toMap(
						Order::getId,
						order -> order.getProducts().size()
				));

		System.out.println("result = " + result);
				
	}

	@Test
	@DisplayName("Produce a data map with order records grouped by customer")
	public void exercise12(){

		Map<Customer, List<Order>> result = orderRepo.findAll().stream()
				.collect(
						Collectors.groupingBy(
								Order::getCustomer
						)
				);

		System.out.println("result = " + result);

	}

	@Test
	@DisplayName("Produce a data map with order record and product total sum")
	public void excercise13(){
		Map<Order, Double> result = orderRepo.findAll().stream()
				.collect(
						Collectors.toMap(
								Function.identity(),
								order -> order.getProducts().stream().mapToDouble(Product::getPrice).sum()
						)
				);
		System.out.println("result = " + result);
	}

	@Test
	@DisplayName("Obtain a data map with list of product name by category")
	private void exercise14(){
		Map<String, List<String>> result = productRepo.findAll().stream()
				.collect(
						Collectors.groupingBy(
								Product::getCategory, 
								Collectors.mapping(Product::getName, Collectors.toList())
						)
				);

		System.out.println("result = " + result);
	}

	@Test
	@DisplayName("Get the most expensive product per category")
	void exercise15() {
		Map<String, Optional<Product>> result = productRepo.findAll().stream()
				.collect(
						Collectors.groupingBy(
								Product::getCategory,
								Collectors.maxBy(Comparator.comparing(Product::getPrice))
						)
				);

		System.out.println("result = " + result);
	}
}
