package TestCSorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.nexsoft.sorting.CSorting;

public class TestCSorting {

	CSorting cSorting;

	@BeforeEach
	public void init() throws IOException {
		cSorting = new CSorting();
	}
//	Green Test/Positive Test
//	<1>=====================================================================================================-
	@DisplayName("Bubble Sort Operation Data Changed")
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", delimiter = ';', numLinesToSkip = 1)
	public void testBubbleSort_WhenDataNotChanged(int a, int b, int c, int d, int e) {
		assertTimeout(Duration.ofMillis(500), () -> {
			// Arrange
			int arrInt[] = {a, b, c, d, e};
			int expected[] = {a, b, c, d, e};
			Arrays.sort(expected);

			// Act
			cSorting.bubbleSort(arrInt, arrInt.length);

			// Assert
			assertArrayEquals(expected, arrInt);
		});
	}
	
//	<2>=====================================================================================================-
	@DisplayName("Selection Sort Operation Data Changed")
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", delimiter = ';', numLinesToSkip = 1)
	public void testSelectionSort_WhenDataIsProvide(int a, int b, int c, int d, int e) {
		assertTimeout(Duration.ofMillis(500), () -> {
			// Arrange
			int arrInt[] = {a, b, c, d, e};
			int expected[] = {a, b, c, d, e};
			
			Arrays.sort(expected);

			// Act
			cSorting.selectionSort(arrInt);

			// Assert
			assertArrayEquals(expected, arrInt);
		});
	}

//	<3>=====================================================================================================-
	@DisplayName("Insertion Sort Operation Data Changed")
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", delimiter = ',', numLinesToSkip = 1)
	public void insertionSortTest_WhenDataIsProvide(int a, int b, int c, int d, int e) {

		assertTimeout(Duration.ofMillis(500), () -> {
			//Arrange
			int arrInt[] = {a, b, c, d, e};
			int expected[] = {a, b, c, d, e};
			Arrays.sort(expected);

			//Act
			cSorting.insertionSort(arrInt, arrInt.length);

			//Assert
			assertArrayEquals(expected, arrInt);
		});
	}
	
//	Red Test/Negative Test
//	<4>=====================================================================================================-
	@DisplayName("Bubble Sort Operation Data Not Changed")
	@ParameterizedTest
	@CsvFileSource(resources = "data.csv", delimiter = ';', numLinesToSkip = 1)
	public void bubbleSortTest_WhenDataNotChanged(int a, int b, int c, int d, int e) {
		assertTimeout(Duration.ofMillis(500), () -> {
			// arrange
			int arrInt[] = {a, b, c, d, e};
			int expected[] = {a, b, c, d, e};
			
			// act
			cSorting.bubbleSort(arrInt, arrInt.length);
			
			// assert
			assertArrayEquals(expected, arrInt);
		});
	}
	
//	<5>=====================================================================================================-
	@DisplayName("Selection Sort Operation Data Not Changed")
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", delimiter = ';', numLinesToSkip = 1)
	public void testSelectionSort_WhenArrayNotSorted(int a, int b, int c, int d, int e) {
		assertTimeout(Duration.ofMillis(500), () -> {
			//Arrange
			int arrInt[] = {a, b, c, d, e};
			int expected[] = {a, b, c, d, e};
			
			//Act
			cSorting.selectionSort(arrInt);
			
			//Assert
			assertArrayEquals(expected, arrInt);
		});
	}
	
//	<6>=====================================================================================================-
	@DisplayName("Insertion Sort Operation Data Not Changed")
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", delimiter = ';', numLinesToSkip = 1)
	public void insertionSortTest_WhenArrayNotSorted(int a, int b, int c, int d, int e) {
		
		assertTimeout(Duration.ofMillis(500), () -> {
			//Arrange
			int arrInt[] = {a, b, c, d, e};
			int expected[] = {a, b, c, d, e};
			
			//Act
			cSorting.insertionSort(arrInt, arrInt.length);
			
			//Assert
			assertArrayEquals(expected, arrInt);
		});
	}
}