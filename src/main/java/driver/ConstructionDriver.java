package driver;

import java.util.Queue;
import java.util.Scanner;

import construction.ConstructionManager;

public class ConstructionDriver {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the total no of floors in the building"); // Prompt User to enter total slabs.
		int noOfSlabs = scan.nextInt(); // Accept slabs count.
		int maxSlabSize = noOfSlabs; // Set max slab size as count of Slabs.
		
		ConstructionManager manager = new ConstructionManager(); // create object of class to access methods
		Queue slabs = manager.getSlabdetails(noOfSlabs); // Invoke method to accept Slabs details.
		manager.orderOfConstruction(slabs, maxSlabSize); // Calculate / Manager construction order
	}
	
}
