
package company;


/**
 * Class Company: abstracts a company
 * @author Marconi Fonseca CST8284
 * Assignment 2: Company Management Tool prototype
 *  March 31 2019
 */

import java.util.ArrayList;
import java.util.Calendar;

/*
 * Class Company: abstracts a company
 */
public class Company {
/*
 * An array to hold the <Arraylist> employees of the company
*/

	private ArrayList<Employee> employees;
/*
* Default constructor; it instantiates the Employee array and pre-loads
* three employees, to be used for demonstration purposes
*/
	public Company() {

		employees = new ArrayList<Employee>();

		employees.add(new Manager("Alvin Spring", 14, new OurDate(2, 12, 2014), 150000, "Manager"));
		employees.add(new Staff("Grant Barge", 21, new OurDate(18, 5, 2009), 40000, "Clerk"));
		employees.add(new Temp("Ross Chuttle", 23, new OurDate(22, 2, 2010), 43269, new OurDate(20, 12, 2020)));
	}

/*
 * Method to add employee into the Employee Array. add a switch() statement to choose which of the three subclasses 
 * to instantiate based on the new parameter (Manager, Staff, Temp)
 * It will return to the loadExtraInfo() of which subclass.
 */

	public Employee addEmployee(String name, int employeeNumber, OurDate Startdate, double salary, int empType) {
		switch (empType) {
		case CompanyConsole.MANAGER:
			Manager manager = new Manager();
			employees.add(new Manager(name, employeeNumber, Startdate, salary, ""));
			return manager;
			

		case CompanyConsole.STAFF:
			Staff staff = new Staff(name, employeeNumber, Startdate, salary, "");
			employees.add(staff);
			//staff.loadExraInfo();
			return staff;
		case CompanyConsole.TEMP:
			Temp temp = new Temp(name, employeeNumber, Startdate, salary, new OurDate());
			employees.add(temp);
			//temp.loadExraInfo();
			return temp;
		}

		return null;
	}

/*
 * A current number of employee method. It return the size of array. 
 */
	public int currentNumberEmployees() {
		return employees.size();
	}

	
	public boolean isMaximumEmployees() {
		return false;
	}

	
/*
 * Delete employee's method. Search the employee through the nested array. If the chosen number wasn't matched 
 * with the Employee Number, it will return a message that "Employee can't be found", 
 * otherwise, it deletes the employee based on their number. 
 */
	public Employee deleteEmployee(int empNum) {

		int k = 0;
		for (int i = 0; empNum != employees.get(i).getEmployeeNumber(); i++) {
			k++;
			if (k >= employees.size()) {
				System.out.print("An employee with that number could not be found");
				return null;
			}// end if

		}// end for

		System.out.println("The record for " + employees.get(k).getName() + " employee number,"
				+ employees.get(k).getEmployeeNumber() + " has been deleted");
		return employees.remove(k);
	}// end method


/*
 * Find employee's method. Search the employee through the nested array. If the chosen number wasn't matched 
 * with the Employee Number, it will return a message that "Employee can't be found", 
 * otherwise, it returns the employee based on their number. Same method of Delete Employee 
 */
	
	public Employee findEmployee(int empNum) {

		int k = 0;
		for (int i = 0; empNum != employees.get(i).getEmployeeNumber(); i++) {
			k++;
			if (k >= employees.size()) {
				System.out.print("An employee with that number could not be found");
				return null;
			}// end if
		} // end for

		System.out.println("\nNAME\t\t" + "   " + "EMPLOYEE NO.\t\tSTART DATE\tSALARY\t\t EMPLOYEE INFO");
		System.out.print(employees.get(k) + "\n");

		return employees.get(k);

	}// end method

/*
 * Return a reference to the array of Employees
 */
	public ArrayList<Employee> getEmployees() {
		return employees;

	}

/*
 *  Find senior employee by converting the start date of each non-null employee
 *  in the employees array to its Calendar equivalent, and using Calendar's
 *  before() method to determine which date is earliest. The index of the
 *  earliest start date is used to return a new instance of the most senior employee
*/
	
	public Employee findSeniorEmployee() {

		if (employees.size() == 0)
			return null; // return null if no employees entered

		int seniorEmployeeIndex = 0; // assume first employee in array is senior
		// instantiate Calendar objects for current and earliest start dates
		Calendar calEarliestStartDate = (Calendar.getInstance());

		// load Calendar object to hold presumed earliest start date using employees[0]
		OurDate odEarliestStartDate = employees.get(seniorEmployeeIndex).getStartDate();
		calEarliestStartDate.set(odEarliestStartDate.getYear(), odEarliestStartDate.getMonth(),
				odEarliestStartDate.getDay());

		// loop through remaining employees and compare to determine earliest start date
		for (int employeeIndex = 1; employeeIndex < employees.size(); employeeIndex++) {
			OurDate thisStartDate = employees.get(employeeIndex).getStartDate();
			Calendar calThisStartDate = Calendar.getInstance(); // need to load new instance..
			calThisStartDate.set(thisStartDate.getYear(), thisStartDate.getMonth(), thisStartDate.getDay());
			// Use calendar before() method to compare Calendar start dates
			if (calThisStartDate.before(calEarliestStartDate)) {
				seniorEmployeeIndex = employeeIndex; // set new oldest employee
				calEarliestStartDate = calThisStartDate;
			}
		}

		return employees.get(seniorEmployeeIndex); // return employee at index with earliest startdate
	}

	
}// end class
