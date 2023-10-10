package com.games.pkg;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		TicTacToe access = new TicTacToe();
		char bingo[][] = new char[3][3];
		Scanner sc = new Scanner(System.in);
		access.init_space(bingo);
		int a, indexcheck, i = 1;
		char X = 'X', O = 'O';
		boolean victory = false;
		access.gamerules(bingo.length, i);
		int[] bin = { -1, 00, 01, 02, 10, 11, 12, 20, 21, 22 };
		boolean[] present = new boolean[bingo.length * 3 + 1];
		while (i <= bingo.length * 3) {
			if (i % 2 != 0) {
				System.out.println("First player turn --> X");
				a = sc.nextInt();
			} else {
				System.out.println("Second player turn --> O");
				a = sc.nextInt();
			}
			if (present[a] == true) {
				System.out.println("Can't Change");
				continue;
			}
			indexcheck = a;
			a = bin[a];
			if (a == -1) {
				System.out.println("Exit");
				break;
			}
			if (i % 2 != 0) {
				bingo = access.inputs(bingo, a, X);
				victory = access.border1(bingo);
				if (victory == true) {
					System.out.println("First player Won the game");
					break;
				}
			} else {
				bingo = access.inputs(bingo, a, O);
				victory = access.border1(bingo);
				if (victory == true) {
					System.out.println("Second player Won the game");
					break;
				}
			}
			present[indexcheck] = true;
			i++;
		}
		if (victory == false && i == (bingo.length * 3) + 1) {
			System.out.println("Draw");
		}
		sc.close();
	}

	private void gamerules(int bingo, int no) {
		System.out.println("     Tic-Tac-Toe");
		System.out.println("---------------------");
		System.out.println("↓KEYS↓");
		for (int i = 0; i < bingo; i++) {
			for (int j = 0; j < bingo; j++) {
				System.out.print(no + "|");
				no++;
			}
			System.out.println();
		}
		System.out.println("---------------------");
		System.out.println("PRESS 0 KEY FOR EXIT");
		System.out.println("---------------------");
	}

	private boolean border1(char[][] bingo) {
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				System.out.print(bingo[i][j] + "|");
			}
			System.out.println();
		}
		boolean victory = rules(bingo);
		return victory;
	}

	private boolean rules(char[][] bingo) {
		int minrow = 0, mincol = 0, countp1 = 0, countp2 = 0;
		boolean victory = false;
		while (minrow < 3) {
			countp1 = 0;
			countp2 = 0;
			for (int col = 0; col < bingo.length; col++) {
				if (bingo[minrow][col] == 'X') {
					countp1++;
					if (countp1 == 3) {
						victory = true;
						return victory;
					}
				} else if (bingo[minrow][col] == 'O') {
					countp2++;
					if (countp2 == 3) {
						victory = true;
						return victory;
					}
				}
			}
			minrow++;
			countp1 = 0;
			countp2 = 0;
			for (int row = 0; row < bingo.length; row++) {
				if (bingo[row][mincol] == 'X') {
					countp1++;
					if (countp1 == 3) {
						victory = true;
						return victory;
					}
				} else if (bingo[row][mincol] == 'O') {
					countp2++;
					if (countp2 == 3) {
						victory = true;
						return victory;
					}
				}
			}
			mincol++;
		}
		countp1 = 0;
		countp2 = 0;
		for (int row = 0, col = 0; row < bingo.length; row++, col++) {
			if (bingo[row][col] == 'X') {
				countp1++;
				if (countp1 == 3) {
					victory = true;
					return victory;
				}
			} else if (bingo[row][col] == 'O') {
				countp2++;
				if (countp2 == 3) {
					victory = true;
					return victory;
				}
			}
		}
		countp1 = 0;
		countp2 = 0;
		for (int col = 0, row = 2; col < bingo.length; col++, row--) {
			if (bingo[row][col] == 'X') {
				countp1++;
				if (countp1 == 3) {
					victory = true;
					return victory;
				}
			} else if (bingo[row][col] == 'O') {
				countp2++;
				if (countp2 == 3) {
					victory = true;
					return victory;
				}
			}
		}
		return victory;
	}

	private char[][] inputs(char[][] bingo, int a, char player) {
		int digit = 0, rem = a;
		while (rem > 0) {
			rem = rem / 10;
			digit++;
		}
		if (digit == 2)
			bingo[a / 10][a % 10] = player;
		else
			bingo[0][a % 10] = player;
		return bingo;
	}

	private char[][] init_space(char[][] bingo) {
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				bingo[i][j] = ' ';
			}
		}
		return bingo;
	}
}