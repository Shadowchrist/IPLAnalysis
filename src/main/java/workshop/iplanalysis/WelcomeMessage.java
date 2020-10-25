/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.workshop.iplanalysis;

import csvutility.CustomException;

public class WelcomeMessage {
   public static void main(String args[]) throws CustomException
   {
	   System.out.println("Welcome to IPL League Analyzer.");
	   GetStats stats = new GetStats();
	   System.out.println("BATSMEN:\n");
	   stats.getBatsmenData().stream().sorted((p1,p2)->p1.getName().compareToIgnoreCase(p2.getName())).forEach(System.out::println);
	   System.out.println("BOWLERS:\n");
	   stats.getBowlersData().stream().sorted((p1,p2)->p1.getName().compareToIgnoreCase(p2.getName())).forEach(System.out::println);
   }
}
