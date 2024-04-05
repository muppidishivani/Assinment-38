package com.web.java;

import java.util.Scanner;

public class TicTacToe_38 {

	    private static char[][] board = new char[3][3];
	    private static char currentPlayer = 'X';

	    public static void main(String[] args) {
	        initializeBoard();
	        displayBoard();

	        Scanner scanner = new Scanner(System.in);

	        while (!isGameFinished()) {
	            System.out.println("Player " + currentPlayer + "'s turn");
	            System.out.print("Enter row (0, 1, or 2): ");
	            int row = scanner.nextInt();
	            System.out.print("Enter column (0, 1, or 2): ");
	            int col = scanner.nextInt();

	            if (isValidMove(row, col)) {
	                board[row][col] = currentPlayer;
	                displayBoard();
	                if (isWinner()) {
	                    System.out.println("Player " + currentPlayer + " wins!");
	                    return;
	                }
	                if (isDraw()) {
	                    System.out.println("It's a draw!");
	                    return;
	                }
	                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	            } else {
	                System.out.println("Invalid move! Try again.");
	            }
	        }
	    }

	    private static void initializeBoard() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                board[i][j] = '-';
	            }
	        }
	    }

	    private static void displayBoard() {
	        System.out.println("  0 1 2");
	        for (int i = 0; i < 3; i++) {
	            System.out.print(i + " ");
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    private static boolean isValidMove(int row, int col) {
	        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
	    }

	    private static boolean isWinner() {
	       
	        for (int i = 0; i < 3; i++) {
	            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
	                return true;
	            }
	        }
	       
	        for (int j = 0; j < 3; j++) {
	            if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer) {
	                return true;
	            }
	        }
	        // Check diagonals
	        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
	            return true;
	        }
	        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
	            return true;
	        }
	        return false;
	    }

	    private static boolean isDraw() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] == '-') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    private static boolean isGameFinished() {
	        return isWinner() || isDraw();
	    }
	}


