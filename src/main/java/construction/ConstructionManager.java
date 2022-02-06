package construction;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ConstructionManager {
	
	public Queue<Integer> getSlabdetails(int noOfSlabs) {
		Scanner scan = new Scanner(System.in);
//		Queue<Integer> slabs = new PriorityQueue<Integer>(noOfSlabs);
		Queue<Integer> slabs = new LinkedList<Integer>(); // Create DS Queue to hold Slab sizes in Manifactured order
		for(int i=1; i<= noOfSlabs; i++) {
			System.out.println("Enter the floor size given on day : "+i);
			slabs.add(scan.nextInt()); // Accept and insert the Slabs sizes in the queue
		}
		return slabs;
	}
	
	
	public void orderOfConstruction(Queue slabs, int maxSlab) {
		Stack<Integer> st = new Stack<Integer>();
		int nxtSlab = maxSlab; // Initialize nxt slab to max slab size.
		int currentSlab;
		String slabOrder; // String to hold the Order of slabs to be printed
		for(int i = 1; i <= maxSlab; i++) { // Iterate over slabs queue
			slabOrder = ""; // Set slab order to empty
			System.out.println("Day: "+i); // Print Day of construction
			currentSlab = (Integer) slabs.poll(); // Get the current ready slab from manufactured queue
			
			if(currentSlab == nxtSlab) { // Check if the ready slab is same as slab to be put on
				slabOrder = slabOrder+" "+currentSlab; // Put on the slab.
				nxtSlab--; // Get to the next slab to put
				while(!st.empty() && st.peek() == nxtSlab) { // check if the next slab is ready in the parked stock.
					slabOrder = slabOrder + " "+ st.pop(); // if found put he slab also.
					nxtSlab--;  // Get to the next slab to put
				}
			}else {
				st.add(currentSlab); // Park the slab in the storage 
				st.sort(null); // sort the slab storage
			}
			System.out.println(slabOrder);
		}
	}
}
