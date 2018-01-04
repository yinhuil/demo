package demo;

import java.util.Scanner;

public class test {
   public static void main(String[] args) {
	   int input;
       Scanner scanner = new Scanner(System.in);
       while ((input = scanner.nextInt()) != 10) {
           System.out.println("the number you entered is: " + input);
       }
       System.out.println("loop ended");
   }
}
