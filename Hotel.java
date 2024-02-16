import java.util.*;
import java.io.*;

public class Hotel {

	static Scanner scan = new Scanner(System.in);
	static Formatter table = new Formatter();
		
	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter outfile = new PrintWriter("hotelinfo.txt");
		
		System.out.print("How many rooms? ");
		int rooms = scan.nextInt();
		System.out.println();
		
		//Hotel Info
		String name[] = new String[rooms];
		int party[] = new int[rooms], nights[] = new int[rooms];
		String status;
		double perperson[] = new double[rooms];
		
		double pernight[] = new double[rooms], rtotal[] = new double[rooms];
		
		//Totals
		double ptotal = 0, ntotal = 0, total = 0;
		
		//Table Header
		table.format("%-5s %-10s %-10s %-10s %-15s %-15s %-9s\n", "ROOM", "NAME", "PARTY", "NIGHTS", "PER PERSON", "PER NIGHT", "TOTAL");
		table.format("-----------------------------------------------------------------------------\n");
		
		//Enter info
		for(int i = 0; i < rooms; i++) {
			
			System.out.print((i + 1) + " Room Status: ");
			status = scan.next();
			System.out.println();
			
			if(status.equalsIgnoreCase("vacant")) {
				
				name[i] = " ";
				perperson[i] = 0.00;
				
			}else if(status.equalsIgnoreCase("occupied")) {
								
				perperson[i] = 50.00;
				
				System.out.print("Name: ");
				name[i] = scan.next();
				
				System.out.print("Party Size: ");
				party[i] = scan.nextInt();
				
				System.out.print("Nights: ");
				nights[i] = scan.nextInt();
				System.out.println();
				
				pernight[i] = perperson[i] * party[i];
				rtotal[i] = pernight[i] * nights[i];
				
				
			}else {
				
				System.out.println("Specify the status!");
				System.out.println();
			}
			
			table.format("%-5s %-10s %-10s %-10s %10s %14s %11s\n", (i + 1), name[i], party[i], nights[i], perperson[i], pernight[i], rtotal[i]);
			
		}
				
		//Table Footer
		table.format("-----------------------------------------------------------------------------\n");
				
		//Totals
		for(int i = 0; i < rooms; i++) {
					
			ptotal += perperson[i];
			ntotal += pernight[i];
			total += rtotal[i];
		}
				
		table.format("                                       %10s %14s %11s", ptotal, ntotal, total);
				
		outfile.print(table);
		outfile.close();
		
		//System.out.println(table);
		System.out.println();
		System.out.println("Info has been printed to file!");
	}

}
