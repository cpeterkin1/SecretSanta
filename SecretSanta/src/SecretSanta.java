/**
 * 
 */

/**
 * @author Chris
 * @date 9/2/21
 * 
 * @description generates Secret Santa assignments and 
 * 	outputs text files to be opened by participants
 *
 */

import java.util.*;
import java.io.File;
import java.io.FileWriter;  // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class SecretSanta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many participants?:");
		int numParticipants = scan.nextInt();
		
		Participant[] members = new Participant[numParticipants];
		int[] assignments = new int[5];
		
		for (int i = 1; i<=members.length; i++) {
			System.out.println("Enter Participant " + (i) + " Name:");
			members[i-1] = new Participant(scan.next());
			assignments[i-1] = i-1;
		}
		
		String assignment = "";
		String fileName = "";
		shuffleArray(assignments);
		
		for (int i = 0; i<members.length; i++) {
			fileName = members[i].getName();
			assignment += "*** Secret Santa ***\n\n";
			assignment += "Assignment for " + fileName;
			assignment += " is " + members[assignments[i]].getName();
			try {
				File newFile = new File(fileName+".txt");
				FileWriter output = new FileWriter(fileName+".txt");
				output.write(assignment);
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fileName = "";
			assignment = "";
		}
		
		/* tester
		System.out.println(members.length);
		for (int i = 0; i<members.length; i++) {
			System.out.println("Participant " + (i+1) + " Name: " + members[i].getName());
		} */

	}
	
	private static void shuffleArray(int[] data) {
	    for (int i = 0; i < data.length - 1; i++) {
	        int j = (int) (i + 1 + Math.floor(Math.random() * (data.length - i - 1)));
	        int temp = data[j];
	        data[j] = data[i];
	        data[i] = temp;
	    }
	}

}
