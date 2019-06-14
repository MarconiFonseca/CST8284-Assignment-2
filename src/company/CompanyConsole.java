package company;
import java.util.Scanner;


/**
 * Class Company: abstracts a company
 * @author Marconi Fonseca CST8284
 * Assignment 2: Company Management Tool prototype
 *  March 31 2019
 */

public class CompanyConsole {
	
	/*
	 *  named constants, used in the menu below
	 */
	
	private static final int ADDEMPLOYEE = 1;
	private static final int DISPLAYEMPLOYEES = 2;
	private static final int DISPLAYSENIOREMPLOYEE = 3;
	private static final int FIND_EMPLOYEE = 4;
	private static final int DELETE_EMPLOYEE = 5;
	private static final int EXIT = 9;
	
	public static final int MANAGER = 1;
	public static final int STAFF = 2;
	public static final int TEMP = 3;
	
	/*
	 *  a variable to hold a company object, itself made up of employees
	 */
	private Company startUp;
	
	/*
	 *  used for menu input
	 */
	
	private Scanner in = new Scanner(System.in);
	
	/*
	 *  default startup object for the application
	 */
	public CompanyConsole() {
		startUp = new Company();
	}

	/*
	 *  starting point of execution for the program; loads a new instance of this
	 *  class, and runs the menu for user input
	 */
	
	public static void main (String [] args) {	
		CompanyConsole console = new CompanyConsole();
		console.menu();	
	}
	
	/*
	 *  the main interface for the application; the user's choices drive program
	 *  execution
	 */
	 
	public void menu(){	
		int choice;
		do{
		
			System.out.println("\n********************************************************");
			System.out.println(CompanyConsole.ADDEMPLOYEE + ".  ADD EMPLOYEE");
			System.out.println(CompanyConsole.DISPLAYEMPLOYEES+ ".  DISPLAY EMPLOYEES");
			System.out.println(CompanyConsole.DISPLAYSENIOREMPLOYEE+ ".  DISPLAY SENIOR EMPLOYEE");
			System.out.println(CompanyConsole.FIND_EMPLOYEE+ ".  FIND EMPLOYEE");
			System.out.println(CompanyConsole.DELETE_EMPLOYEE + ".  DELETE EMPLOYEE");
			System.out.println(CompanyConsole.EXIT + ".  EXIT ");
			System.out.println("*******************************************************\n");
			
			System.out.print("SELECTION: ");
			
			choice = in.nextInt();
			in.nextLine(); //get rid of newline character in buffer
			
			switch(choice){
				case CompanyConsole.ADDEMPLOYEE:
					addEmployee();
					break;
				case CompanyConsole.DISPLAYEMPLOYEES:
					displayEmployees();
					break;
				case CompanyConsole.DISPLAYSENIOREMPLOYEE:
					displaySeniorEmployee();
					break;
				case CompanyConsole.FIND_EMPLOYEE:
					findEmployee();
					break;
				case CompanyConsole.DELETE_EMPLOYEE:
					deleteEmployee();
					break;
 				case CompanyConsole.EXIT:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("INVALID CHOICE; PLEASE RE-ENTER");
			}	
		} while(choice != CompanyConsole.EXIT); //end do and exit program
	}//end menu
	
	/*
	 * addEmployee returned from the call to startUp.addEmployee()
	 * to a temporary Employee-declared variable.
	 */
	
	private void addEmployee() {
		if(startUp.isMaximumEmployees()) {
			// check if space available in array first
					System.out.println("Attempt to exceed maximum Employee array size;\n" +
		                       "can't add another employee");}

		else{   // prompt user to add new employee information

			System.out.println("ENTER NEW EMPLOYEE INFORMATION:\n");
			System.out.print("NAME: ");
			String name = in.nextLine();
			
			System.out.print("EMPLOYEE NUMBER: ");
			int employeeNumber = in.nextInt();
			
			System.out.println("HIRING DATE");
			System.out.print("YEAR: ");
			int year = in.nextInt();
			
			System.out.print("MONTH: ");
			int month = in.nextInt();
			
			System.out.print("DAY: ");
			int day = in.nextInt();
			
			System.out.print("SALARY: ");
			double salary = in.nextDouble();		
			
			System.out.print("Employee Type (Manager = 1, Staff = 2, Temp = 3) ");
			int empType = in.nextInt();

			startUp.addEmployee(name, employeeNumber, new OurDate(day, month, year), salary, empType);
			
			// use Company method to load Employee object to employees array
				
		}//end else
		
	}//END ADDEMPLOYEE()
	
	/*
	 * deleteEmployee() prompts the user for the Employee number to delete, 
	 * and prints out the name of the employee just deleted, assuming it was found,
	 * otherwise the message “An employee with that number could not be found.”
	 */
	
	private void deleteEmployee() {
		
		System.out.print("\nWhat is the number of the Employee that you want to delete? ");
		int empNum = in.nextInt();
		startUp.deleteEmployee(empNum);
	}	
	
	/*
	 * findEmployee() prompts the user for the Employee number to find, 
	 * assuming it was found, otherwise the message “An employee with that number could not be found.”
	 */
	private void findEmployee() {

		System.out.print("Enter number of employee to find: ")	;
		
		int empNum = in.nextInt();
		startUp.findEmployee(empNum);		
		
	}

	/*
	 * outputs senior employee information to the console using findSeniorEmployee 
	 */	
	
	private void displaySeniorEmployee() {
		if(startUp.getEmployees().size() == 0){
			System.out.println("There are no employees\n");
		}
		else{
			Employee e = startUp.findSeniorEmployee();
			
			System.out.println("\nNAME\t\t"+"   "+"EMPLOYEE NO.\t\tSTART DATE\tSALARY\t\t EMPLOYEE INFO\n" +e.toString());	

		}
	}

	/*
	 *  loads through the employees array and outputs each Employee's toString() 
	 *  method in tabular form preceded by table heading for each field presented
	 */
	private void displayEmployees() {
		System.out.println("\nNAME\t\t"+"   "+"EMPLOYEE NO.\t\tSTART DATE\tSALARY\t\t EMPLOYEE INFO");	
		for(int i = 0; i < startUp.currentNumberEmployees(); i++)
			if (startUp.getEmployees().get(i) !=null)
			   System.out.println(startUp.getEmployees().get(i));
		
	}

	
	
}//END CLASS COMPANYCONSOLE
