package fr.operateurs.console;

import java.util.Scanner;

import javax.management.NotCompliantMBeanException; 

public class OperateursApp {
	
	public static void main (String[] args){
		
		System.out.println("***** Application Opérateurs *****");
		System.out.println("Veuillez saisir le premier nombre...");
			
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		int nombreUn = reader.nextInt(); // Scans the next token of the input as an int.
		
		System.out.println("Veuillez saisir le second nombre...");
		
		int nombreDeux = reader.nextInt();
		
		System.out.println(nombreUn + " + " + nombreDeux + " = " + (nombreUn + nombreDeux));
		System.out.println(nombreUn + " - " + nombreDeux + " = " + (nombreUn - nombreDeux));
		System.out.println(nombreUn + " * " + nombreDeux + " = " + (nombreUn * nombreDeux));
		System.out.println(nombreUn + " / " + nombreDeux + " = " + (nombreUn / nombreDeux));
		System.out.println(nombreUn + " % " + nombreDeux + " = " + (nombreUn % nombreDeux));
		
	}
 
}
