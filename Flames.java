package com.games.pkg;

import java.util.ArrayList;
import java.util.Scanner;

public class Flames {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Flames obj = new Flames();
		System.out.println("Your Name: ");
		String a = sc.nextLine();
		System.out.println("Your Partner Name: ");
		String b = sc.nextLine();
		// char []ch1=a.toCharArray();
		char[] ch1 = new char[a.length()];
		int space1 = 0, space2 = 0;
		for (int i = 0, j = 0; i < a.length(); i++) {
			if (a.charAt(i) != ' ') {
				ch1[j++] = a.charAt(i);
			} else {
				space1++;
			}
		}
		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i] >= 'A' && ch1[i] <= 'Z') {
				ch1[i] = (char) (ch1[i] + 32);
			}
		}
		char[] ch2 = new char[b.length()];
		for (int i = 0, j = 0; i < ch2.length; i++) {
			if (b.charAt(i) != ' ') {
				ch2[j++] = b.charAt(i);
			} else {
				space2++;
			}
		}
		for (int i = 0; i < ch2.length; i++) {
			if (ch2[i] >= 'A' && ch2[i] <= 'Z') {
				ch2[i] = (char) (ch2[i] + 32);
			}
		}
		int number = obj.removesamecharacter(ch1, ch2, space1, space2);
		ArrayList<String> al = obj.flames(number);
		System.out.println("The Relationship between " + a + " and " + b + " is " + al + ".");
		System.out.println("Do not take the result of flames game too seriously. It is Just for fun.");
		sc.close();
	}

	private ArrayList<String> flames(int number) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Friendship");// 0
		al.add("Love");// 1
		al.add("Affection");// 2
		al.add("Marriage");// 3
		al.add("Enemy");// 4
		al.add("Siblings");// 5
		int rem = al.size();
		int pre = 0;
		int number1 = number;
		while (true) {
			if (number <= rem && rem >= 2) {
				pre = number - 1;
				al.remove(number - 1);
				number = number1 + pre;
				rem--;
			} else {
				number = number - rem;
			}
			if (rem == 1) {
				break;
			}

		}
		System.out.println(al);
		return al;
	}

	private int removesamecharacter(char[] ch1, char[] ch2, int space1, int space2) {
		int count = 0;
		for (int i = 0; i < ch1.length; i++) {
			for (int j = 0; j < ch2.length; j++) {
				if (ch1[i] == ch2[j]) {
					count = count + 2;
					ch2[j] = ' ';
					break;
				}
			}
		}
		count = ch1.length + ch2.length - count - space1 - space2;
		System.out.println(count);
		return count;
	}

}
