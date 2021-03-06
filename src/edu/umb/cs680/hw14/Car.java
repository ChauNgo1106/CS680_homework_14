package edu.umb.cs680.hw14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Car {

	private String make, model;
	private int mileage, year;
	private float price;
	private int dominationCount = 0;

	// default constructor
	public Car() {
	}

	// constructor with arguments
	public Car(String make, String model, int mileage, int year, float price) {
		super();
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public float getPrice() {
		return price;
	}

	public int getDominationCount() {
		return this.dominationCount;
	}

	public void setDominationCount(Car car, ArrayList<Car> usedCar) {
		int counter = 0;
		for (Car cr : usedCar) {
			// this refer to the car' variable in CarTest class.
			if ((Float.compare(car.getPrice(), cr.getPrice())) > 0) {
				counter++;
			}
			if ((Integer.compare(car.getYear(), cr.getYear())) < 0) {
				counter++;
			}
			if ((Integer.compare(car.getMileage(), cr.getMileage())) > 0) {
				counter++;
			}

			if (counter > 1) {
				this.dominationCount++;
				counter = 0;// compared to another car.
			}
			counter = 0;

		}
	}

	// price
	public static void sortCarByPriceAscending(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, (Car car1, Car car2) -> (int) (car1.getPrice() - car2.getPrice()));
	}

	public static void sortCarByPriceDescending(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, (Car car1, Car car2) -> (int) (car2.getPrice() - car1.getPrice()));
	}

	// price using comparing method
	public static void sortCarByPriceAscendingUsingComparing(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, Comparator.comparing(Car::getPrice, Comparator.naturalOrder()));
	}

	public static void sortCarByPriceDescendingUsingComparing(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, Comparator.comparing(Car::getPrice, Comparator.reverseOrder()));
	}

	// Mileage
	public static void sortCarByMileageAscending(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, (Car car1, Car car2) -> (int) (car1.getMileage() - car2.getMileage()));
	}

	public static void sortCarByMileageDescending(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, (Car car1, Car car2) -> (int) (car2.getMileage() - car1.getMileage()));
	}

	// Mileage using comparing method
	public static void sortCarByMileageAscendingUsingComparing(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, Comparator.comparing(Car::getMileage, Comparator.naturalOrder()));
	}

	public static void sortCarByMileageDescendingUsingComparing(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, Comparator.comparing(Car::getMileage, Comparator.reverseOrder()));
	}

	// year
	public static void sortCarByYearAscending(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, (Car car1, Car car2) -> (int) (car1.getYear() - car2.getYear()));
	}

	public static void sortCarByYearDescending(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, (Car car1, Car car2) -> (int) (car2.getYear() - car1.getYear()));
	}

	// Year using comparing method
	public static void sortCarByYearAscendingUsingComparing(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, Comparator.comparing(Car::getYear, Comparator.naturalOrder()));
	}

	public static void sortCarByYearDescendingUsingComparing(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, Comparator.comparing(Car::getYear, Comparator.reverseOrder()));
	}

	// Pareto
	//ascending means the best cars to the worst cars
	public static void sortCarByParetoAscending(ArrayList<Car> usedCar) {
		Collections.sort(usedCar,
				(Car car1, Car car2) -> (int) (car1.getDominationCount() - car2.getDominationCount()));
	}
	//descending means the worst cars to the best cars
	public static void sortCarByParetoDescending(ArrayList<Car> usedCar) {
		Collections.sort(usedCar,
				(Car car1, Car car2) -> (int) (car2.getDominationCount() - car1.getDominationCount()));
	}

	// Pareto using comparing method
	public static void sortCarByParetoAscendingUsingComparing(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, Comparator.comparing(Car::getDominationCount, Comparator.naturalOrder()));
	}

	public static void sortCarByParetoDescendingUsingComparing(ArrayList<Car> usedCar) {
		Collections.sort(usedCar, Comparator.comparing(Car::getDominationCount, Comparator.reverseOrder()));
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", mileage=" + mileage + ", year=" + year + ", price=" + price
				+ "]";
	}

}
