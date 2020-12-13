package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CarTest {
	private static Car car1;
	private static Car car2;
	private static Car car3;
	private static Car car4;
	private static ArrayList<Car> usedCar = new ArrayList<>();

	@BeforeAll
	public static void setUp() {

		car1 = new Car("Lexus", "LS", 10000, 2008, 12500.5f);
		car2 = new Car("Toyota", "Camry", 4501, 2012, 15500.6f);
		car3 = new Car("Audi", "Q3", 2300, 2019, 35000.0f);
		car4 = new Car("Chevrolet", "Malibu", 8800, 2014, 21550.6f);

		usedCar.add(car1);
		usedCar.add(car2);
		usedCar.add(car3);
		usedCar.add(car4);

		// setting up the domination count initially.
		for (Car car : usedCar) {
			car.setDominationCount(car, usedCar);
		}
	}

	// helper method in purpose of getting of the car's make.
	public String[] convertArray(ArrayList<Car> usedCar) {
		ArrayList<String> temp = new ArrayList<String>();
		for (Car car : usedCar) {
			temp.add(car.getMake());
		}
		String[] result = new String[temp.size()];
		result = temp.toArray(result);
		return result;
	}

	// By Price Ascending
	@Test
	public void verify_the_order_of_car_by_price_ascending() {
		String[] expected = { "Lexus", "Toyota", "Chevrolet", "Audi" };
		Car.sortCarByPriceAscending(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Price Descending
	@Test
	public void verify_the_order_of_car_by_price_descending() {
		String[] expected = { "Audi", "Chevrolet", "Toyota", "Lexus" };
		Collections.sort(usedCar, (Car car1, Car car2) -> (int) (car2.getPrice() - car1.getPrice()));
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Price Ascending using comparing() method
	@Test
	public void verify_the_order_of_car_by_price_ascending_using_Comparing() {
		String[] expected = { "Lexus", "Toyota", "Chevrolet", "Audi" };
		Car.sortCarByPriceAscendingUsingComparing(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Price Descending using comparing() method
	@Test
	public void verify_the_order_of_car_by_price_descending_using_Comparing() {
		String[] expected = { "Audi", "Chevrolet", "Toyota", "Lexus" };
		Car.sortCarByPriceDescendingUsingComparing(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Mileage Ascending
	@Test
	public void verify_the_order_of_car_by_mileage_ascending() {
		String[] expected = { "Audi", "Toyota", "Chevrolet", "Lexus" };
		Car.sortCarByMileageAscending(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Mileage Ascending using comparing() method
	@Test
	public void verify_the_order_of_car_by_mileage_descending_using_Comparing() {
		String[] expected = { "Audi", "Toyota", "Chevrolet", "Lexus" };
		Car.sortCarByMileageAscendingUsingComparing(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Mileage Descending
	@Test
	public void verify_the_order_of_car_by_mileage_descending() {
		String[] expected = { "Lexus", "Chevrolet", "Toyota", "Audi" };
		Car.sortCarByMileageDescending(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Mileage Descending using comparing() method
	@Test
	public void verify_the_order_of_car_by_mileage_asscending_using_Comparing() {
		String[] expected = { "Lexus", "Chevrolet", "Toyota", "Audi" };
		Car.sortCarByMileageDescendingUsingComparing(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Year Ascending
	@Test
	public void verify_the_order_of_car_by_year_ascending() {
		String[] expected = { "Lexus", "Toyota", "Chevrolet", "Audi" };
		Car.sortCarByYearAscending(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Year Ascending using comparing() method
	@Test
	public void verify_the_order_of_car_by_Year_ascending_using_Comparing() {
		String[] expected = { "Lexus", "Toyota", "Chevrolet", "Audi" };

		Car.sortCarByYearAscendingUsingComparing(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Year Descending
	@Test
	public void verify_the_order_of_car_by_year_descending() {
		String[] expected = { "Audi", "Chevrolet", "Toyota", "Lexus" };
		Car.sortCarByYearDescending(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Year Descending using comparing() method
	@Test
	public void verify_the_order_of_car_by_Year_descending_using_Comparing() {
		String[] expected = { "Audi", "Chevrolet", "Toyota", "Lexus" };
		Car.sortCarByYearDescendingUsingComparing(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Pareto's comparison ascending
	@Test
	public void verify_the_order_of_car_by_using_Pareto_Comparison_ascending() {
		String[] expected = { "Audi", "Toyota", "Chevrolet", "Lexus" };
		Car.sortCarByParetoAscending(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Year Ascending using comparing() method
	@Test
	public void verify_the_order_of_car_by_Pareto_comparison_ascending_using_Comparing() {
		String[] expected = { "Audi", "Toyota", "Chevrolet", "Lexus" };
		Car.sortCarByParetoAscendingUsingComparing(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Pareto's comparison descending
	@Test
	public void verify_the_order_of_car_by_using_Pareto_Comparison_descending() {
		String[] expected = { "Lexus", "Chevrolet", "Toyota", "Audi" };
		Car.sortCarByParetoDescending(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Year Descending using comparing() method
	@Test
	public void verify_the_order_of_car_by_Pareto_comparison_descending_using_Comparing() {
		String[] expected = { "Lexus", "Chevrolet", "Toyota", "Audi" };
		Car.sortCarByParetoDescendingUsingComparing(usedCar);
		assertArrayEquals(expected, convertArray(usedCar));
	}
}
