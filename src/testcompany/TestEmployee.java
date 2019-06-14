package testcompany;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import company.Company;
import company.Employee;
import company.Manager;
import company.OurDate;
import company.Temp;

/**
 * Class Company: abstracts a company
 * @author Marconi Fonseca CST8284
 * Assignment 2: Company Management Tool prototype
 *  March 31 2019
 */

class TestEmployee {

		Employee e1; // Instantiating the object for the test
		Employee e2; //Instantiating the object for the test
		OurDate date; //Instantiating the object for the test
		Calendar CAL = Calendar.getInstance(); //Instantiating the object for the test
		
		/*
		  Method setUpBeforeAll, print Starting Tests!!
		   before every tests.
		 */
		@BeforeAll
		static void setUpBeforeAllTests() {  System.out.println("STARTING TESTING....");  }

		@AfterAll
		static void tearDownAfterAllTests()  {  System.out.println("ENDING TESTING....");  }

		/*
		 *  Method setUpBeforeEach, Before each tests
		    this method will create a new Employee() 
		    and print Testing case for each test.
		 */
		@BeforeEach
		void setUpBeforeEachTest() {  System.out.println("Starting test...."); 
		
		//Employee e1 = new Manager ("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, "TESTER");
		}

		/*
		  Method tearDownAfterEach, this method
		  will set employee = null after each test.
		 */
		
		@AfterEach
		void tearDownAfterEachTest()  {  System.out.println("Ending test...."); 
		
		e1=null;
		e2=null;
				
		}
		
		/*
		 * checks when an new Employee is created  and compare with another one.
		  */
		@Test
		void testEmployeeEquals() {  
			
			Employee e1 = new Manager ("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, "Manager"); 
			Employee e2 = new Manager ("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, "Manager");
			assertTrue(e1.equals(e2)); 
			
	        }
		
		/*
		 * checks when an new Employee is created  and compare with another different Emplpoyee one.
		  */
		
		@Test
		void testEmployeeNotEquals() {  
			Employee e1 = new Manager ("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, "VP");
			Employee e2 = new Manager ("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, "Manager");
			
			assertFalse(e1.equals(e2)); 
			
		e1 = null;
		e2 = null;
		}
		
		@Test
		public void testDefaultOurDateConstructor(){
			date = new OurDate( CAL.get( Calendar.DATE), CAL.get( Calendar.MONTH + 1), CAL.get(Calendar.YEAR));
			assertEquals( date.getDay(), CAL.get( Calendar.DATE));
			assertEquals( date.getMonth(), CAL.get( Calendar.MONTH + 1));
			assertEquals( date.getYear(), CAL.get( Calendar.YEAR));
		
		date = null;
		}
		
		@Test
		public void testOverloadedOurDateConstructor(){
			date = new OurDate( CAL.get( Calendar.DATE), CAL.get( Calendar.MONTH + 1), CAL.get( Calendar.YEAR));
			assertEquals( date.getDay(), CAL.get( Calendar.DATE));
			assertEquals( date.getMonth(), CAL.get( Calendar.MONTH + 1));
			assertEquals( date.getYear(), CAL.get( Calendar.YEAR));
			
			date = null;
		}
		
		/*
		 * checks that the deleteEmployee() method returns null when the employee number
		 * is not in the employees ArrayList
		 */
		@Test
		public void testDeleteEmployeeReturnsNull() {

			Company newCompany = new Company();

			Employee delete = newCompany.deleteEmployee(1);

			assertNull(delete);

		}
		
		/*
		 * that checks that deleteEmployee() deletes only the
		 * first of two Employee entries having the same employee number;
		 */
		
		@Test
		public void testDeleteFirstEmployeeOnly() {

			Company newCompany = new Company();

			Employee delete = newCompany.deleteEmployee(14);

			assertNotNull(delete);

		}
		
		/*
		 * checks that when an employee number is not found, 
		 * deleteEmployee() does not accidentally delete an entry anyway;
		 */
		
		@Test
		public void testNoAccidentalDeleteEmployee() {

			Company newCompany = new Company();
			
			int berforeDelete = newCompany.currentNumberEmployees();
			newCompany.deleteEmployee(1);
			
			int afterDelete = newCompany.currentNumberEmployees();
			assertTrue(berforeDelete == afterDelete);

		}
		
		/*
		 * checks that a new Temp employee’s equals() method works correctly.
		 * I have print both new Temp employee to confirm that was created
		 */
		@Test
		public void testTempEquals() {

			Employee e1 = new Temp ("Joe Smith", 14, new OurDate(5, 9, 1987), 55000, new OurDate(5,9,2000)); 
			Employee e2 = new Temp ("Smith Joe ", 15, new OurDate(5, 9, 1987), 55000, new OurDate(5,9,2000)); 

			assertFalse(e1.equals(e2));
			
			System.out.print(e1 + "\n");
			System.out.print(e2 + "\n");

		}

	}
