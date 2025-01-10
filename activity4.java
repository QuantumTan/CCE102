import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
 
public class activity4 {
	
	  private static final String FILE_PATH = "Myfile.txtdata.txt"; //defines a constant that represents the file path where tasks will be stored or retrieved. Fixed na siya
	  																// private kay para activity 4 class lang ang maka access, it is used to be accessed only within the class
	  
	    public static void main(String[] args) throws IOException {
	 
	        initializeFile(); //this method creates a file, we called it there first to initialize or to make a file.
	 
	        Scanner scanner = new Scanner(System.in);
	 
	        while (true) {
	 
	            System.out.println("To-Do: \n");
	            System.out.println("1. Create (Add a new tasks)");
	            System.out.println("2. Read (View all tasks)");
	            System.out.println("3. Update (Modify a tasks)");
	            System.out.println("4. Delete (Remove a tasks)");
	            System.out.println("5. Exit\n");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	 
	 
	            switch (choice) { //switch case to access the methods
	 
	                case 1: // kini na method is e display niya ang process and output sa createTasks method
	                	createTasks(scanner);
	                	break;
	 
	                case 2:
	                	readTasks(); // same thought sa case 1
	                	break;
	 
	                case 3:
	                	updateTasks(scanner); // same thought sa case 1
	                	break;
	 
	                case 4:
	                	deleteTask(scanner); // same thought sa case 1
	                	break;
	 
	                case 5:
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    return;     //Without return;, the program might continue running code after the switch block, which could lead to unintended behavior. 
	                    			//It acts as a clean and explicit way to end the process once the user decides to exit.
	 
	                
	                default:
	 
	                	System.out.println("Invalid choice. Please try again.");
	 
	            }
	 
	        }
	 
	    }
	 
	 
	 
	    private static void initializeFile() throws IOException { //throws IOException is needed
	 
	        File file = new File(FILE_PATH); // mura rakag nag initialize diri og scanner. Parameter nimo kay sring variable nimo sa imong file path.
	 
	        if (!file.exists()) {   // condition para dili magbalikbalik og himog file ang program. Pagmakita niya na 
	        						// walay file magbuhat na siya, kapag naa na then walay mahitabo.
	        	
	            file.createNewFile(); //creates new file if file doesn't exist
	        }
	 
	    }
	 
	 
	 
	    private static void createTasks(Scanner scanner) throws IOException { //throws IOException is needed
	 
	        System.out.print("Enter new task: ");
	        String recordTask = scanner.nextLine();
	 
	 
	 
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) { 
	        	
	        	//writes a file, naay 2 nparameters which is ang second ---
	        	//parameter false and default that would add and delete a file if neww file is added 
	        	//maong butngan natu og true para mag write or mag add lang siya without deleting the other 
	        	// written strings.
	 
	            writer.write(recordTask); // .write method is the one who writes a string
	            writer.newLine();
	 
	        }
	 
	        System.out.println("Task added successfully.\n");
	 
	    }
	 
	 
	 
	    private static void readTasks() throws IOException {
	 
	        List<String> tasks = Files.readAllLines(Paths.get(FILE_PATH));  //this syntax will read what is inside the FILE_PATH.
	        																// Files.readAllLines(Paths.get(STRING)); ang syntax para mubaasa og file
	        																// we have created a variable tasks to be use afterwards.
	 
	        if (tasks.isEmpty()) { // validation lang ni 
	            System.out.println("No tasks found."); 
	 
	        } else {
	            System.out.println("Tasks:");
	 
	            for (int i = 0; i < tasks.size(); i++) {				 //using loop to read all what is inside the FILE_PATH.    
	            														 //.size atoang gamiton kapag List<String>, kay ang array .size man
	            	
	                System.out.println((i + 1) + ". " + tasks.get(i));   // .get method means "retrieve" or "access." 
	                													 //It is used to fetch an item from a collection 
	            }
	 
	        }
	 
	    }
	 
	 
	 
	    private static void updateTasks(Scanner scanner) throws IOException {
	 
	        List<String> tasks = Files.readAllLines(Paths.get(FILE_PATH)); // List<String> works like an array, kalahian lang is limitless siya compared sa array
	
	        if (tasks.isEmpty()) { // validation lang
	            System.out.println("No task to update.");
	            return; //return; ensures the method exits immediately, 
	            		//avoiding any errors or unintended behavior.
	 
	        }
	 
	 
	 
	        readTasks(); // call this method to display the tasks to update
	 
	        System.out.print("Enter the task number to update: ");
	        int taskNumber = scanner.nextInt();
	        scanner.nextLine();
	 
	 
	 
	        if (taskNumber < 1 || taskNumber > tasks.size()) {	// validation
	            System.out.println("Invalid task number.\n");
	            return;
	        }
	 
	 
	        System.out.print("Enter the new task: ");
	        String newValue = scanner.nextLine();
	        tasks.set(taskNumber - 1, newValue);    // .set method replaces an element. we have 2 parameters;
	        										// first is the taskNumber - 1, gi minusan natu ug 1 para ma accurate atuang 
	        										// indexing (To accesds the first index which is the zero kay human ang e input sa user kay 
	        										// numbers 1, 1, 3, eme nalang man... so nag minus tag one to access the first index and delete it)
	        										// (correct me if I am wrong pls)
	        
	        
	        										// the second parameter aims to add the new one, since the recent is deleted, the second parameter will be added.
	 
	        Files.write(Paths.get(FILE_PATH), tasks);   // we have used .write here to write the updated value which has 2 parameters
	        											// the first parameter is the path of your file while the second one is the
	        											// list string variable which we have used to update values.
	        System.out.println("Task updated successfully.\n");
	 
	    }
	 
	 
	 
	    private static void deleteTask(Scanner scanner) throws IOException {
	 
	        List<String> tasks = Files.readAllLines(Paths.get(FILE_PATH)); // List<String> works like an array, kalahian lang is limitless siya compared sa array
	 
	        if (tasks.isEmpty()) { //validation
	            System.out.println("No tasks to delete.");
	            return;
	        }
	 
	 
	        readTasks(); //display all tasks
	        System.out.print("Enter the task number to delete: ");
	        int taskNumber = scanner.nextInt(); //input
	        scanner.nextLine();
	 
	 
	 
	        if (taskNumber < 1 || taskNumber > tasks.size()) { // still validation
	            System.out.println("Invalid task number.");
	            return;
	 
	        }
	 
	        
	        tasks.remove(taskNumber - 1);   // .remove method removes an element with one parameter to delete a task. The same kanina, we minus 
	        								// a one para ma access ang first index which is zero because???????? because ang e input sa user kay 1 or more raman
	        								// unless magpa input kag zero no. 
	        
	        Files.write(Paths.get(FILE_PATH), tasks);           // so mao ra gihapon ganina, ga write ni siyag latest updated values. 
	        										        	//Kalahian lang kay e input na niya ang mga values na nabilin.
	        
	        System.out.println("Task deleted successfully.");
	 
	    }
	 
	}
