# Project2_Design-Analysis-of-Algorithm_CSCI_6212

## QuickSelect Algorithm Implementation in Java

## Overview

This project is a Java implementation of the QuickSelect algorithm which finds the k-th smallest element in an unordered list or array. The QuickSelect algorithm works by partially sorting the array using a variation of the QuickSort algorithm.

## Prerequisites

- JDK installed on your machine. You can download the latest version of JDK from the [official Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html) or install it using a package manager relevant to your operating system.

## How to Run

1. Open a command prompt or terminal in the directory containing the `QuickSelect.java` file.
2. Run the command `javac QuickSelect.java` to compile the Java file into bytecode.
3. After successful compilation, run `java QuickSelect` to execute the program.

## Usage

Upon running the program, the user will be prompted to enter the following inputs:

1. **Number of Elements in the Array:** The total count of elements that the array will contain.
2. **Array Elements:** The elements of the array, separated by spaces. Input all elements in a single line.
3. **Value of k:** The k-th position whose element you wish to find in the sorted version of the provided array. For example, if k is 1, the program will return the smallest element in the array.

## Code Structure

- `main(String[] args)`: The main method that drives the program. It handles user input, input validation, and calls the `quickSelect` method to find the k-th smallest element.

- `quickSelect(int[] array, int startIdx, int endIdx, int k)`: A recursive method that implements the QuickSelect algorithm to find the k-th smallest element in the array.

- `findMedianOfMedians(int[] array, int startIdx, int endIdx)`: A helper method to find the pivot value for the `quickSelect` method.

- `findMedian(int[] array, int startIdx, int endIdx)`: Another helper method to find the median of a section of the array.

- `partition(int[] array, int startIdx, int endIdx, int pivotValue)`: A method that partitions the array around a pivot value and returns the index of the pivot after partitioning.

- `swap(int[] array, int idx1, int idx2)`: A utility method to swap two elements in the array.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgements

- The implementation is based on the QuickSelect algorithm, a selection algorithm to find the k-th smallest element in an unordered list.
