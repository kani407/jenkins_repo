package java_Revision;

import java.util.Scanner;
public class PalindromeString { 
	public class PallindromeString {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String str = sc.nextLine();
	        String reverse = "";
	        for (int i = str.length() - 1; i >= 0; i--) {
	            reverse += str.charAt(i);   
	        }
	            		if (str.equals(reverse)) {
	                        System.out.println(str + " is a palindrome string.");
	                    } else {
	                        System.out.println(str + " is not a palindrome string.");
	                    }
	                }
	            }
		}  