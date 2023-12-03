package com.JDBCConnectivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dimensions (m and n)
        System.out.print("Enter the number of rows (m): ");
        int m = scanner.nextInt();
        System.out.print("Enter the number of columns (n): ");
        int n = scanner.nextInt();

        // Input targets, columnIndices, and rowPointers
        List<Character> targets = new ArrayList<>();
        List<Integer> columnIndices = new ArrayList<>();
        List<Integer> rowPointers = new ArrayList<>();
        
        int totalElements = m * n;

        for (int i = 0; i < totalElements; i++) {
            System.out.print("Enter target for element " + i + ": ");
            char target = scanner.next().charAt(0);
            targets.add(target);

            System.out.print("Enter column index for element " + i + ": ");
            int columnIndex = scanner.nextInt();
            columnIndices.add(columnIndex);
        }

        // Calculate rowPointers
        rowPointers.add(0);
        int currentIndex = 0;
        for (int rowIndex = 0; rowIndex < m; rowIndex++) {
            int rowCount = 0;
            for (int i = currentIndex; i < totalElements; i++) {
                if (i >= currentIndex && i < currentIndex + n) {
                    rowCount++;
                } else {
                    break;
                }
            }
            currentIndex += rowCount;
            rowPointers.add(currentIndex);
        }

        // Display the matrix structure
        System.out.println("Targets: " + targets);
        System.out.println("Column Indices: " + columnIndices);
        System.out.println("Row Pointers: " + rowPointers);

        // Example usage: Get an element at a specific row and column
        int row = 2; // Example row
        int col = 3; // Example column

        char element = getElement(row, col, targets, columnIndices, rowPointers);
        if (element != '0') {
            System.out.println("Element at row " + row + ", column " + col + ": " + element);
        } else {
            System.out.println("Element not found at row " + row + ", column " + col);
        }

        scanner.close();
    }

    public static char getElement(int row, int col, List<Character> targets, List<Integer> columnIndices, List<Integer> rowPointers) {
        int start = rowPointers.get(row);
        int end = rowPointers.get(row + 1);

        for (int i = start; i < end; i++) {
            if (columnIndices.get(i) == col) {
                return targets.get(i);
            }
        }

        return '0'; // Element not found
    }
}