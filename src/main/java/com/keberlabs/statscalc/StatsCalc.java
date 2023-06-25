/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.keberlabs.statscalc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Write a program that let a user enter a series of numbers and make different
 * statistical operations on them. The program must ask the user to input the
 * quantity of numbers to input, then ask for every value. After all values have
 * been collected, the program must show the user the following statistics:
 *
 * 1. Sum of all input numbers. 
 * 2. Average of input numbers, only taking into account odd numbers. 
 * 3. Max and Min of input numbers, excluding negatives. 
 * 4. Number of prime numbers. 
 * 5. Show input numbers in ascending and descending order. 
 * 6. Show negative input numbers, if any.
 *
 * @author Keber
 *
 */
public class StatsCalc {

    public static boolean isPrime(int n) {
        if (n <= 0) {
            return false;
        }
        if ((n > 0) && (n <= 2)) {
            return true;
        }
        return (boolean) (divisorsOf(n) == 0);
    }

    public static int divisorsOf(int n) {
        int k = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                k++;
            }
        }
        return k;
    }

    public static List<Integer> allDivisorsOf(int n){
        List<Integer> myList = new ArrayList<>();
        int k = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                myList.add(i);
            }
        }
        return myList;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Advanced Statistics Calculator");
        System.out.println("Please enter the number of elements to ingest: ");
        int numberOfElements = myScanner.nextInt();

        long sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int oddAverage = 0;
        int oddN = 0;

        List<Integer> myList = new ArrayList<>();
        
        for (int i = 0; i < numberOfElements; i++) {
            System.out.println("Enter item " + (i + 1) + ": ");
            int n = myScanner.nextInt();
            myList.add(n);
            sum += n;
            if (n % 2 != 0) { // if odd
                oddAverage += n;
                oddN++;
            }
            if (n > 0) {        // exclude negatives
                min = (min > n) ? n : min;
                max = (max < n) ? n : max;
            }            
        }
        oddAverage /= oddN;

        /*
        for(int i=0;i < numberOfElements; i++){
            System.out.println( myList.get(i) + ((isPrimeList.get(i))?" is ":" is not ") + "prime - divisors: " + divisorsOf(myList.get(i)));
        }
         */
        //long primesCount = isPrimeList.stream().filter(p -> p == true).count();
        long primesCount = myList.stream().filter(p -> isPrime(p)).count();

        System.out.println("1. The sum is " + sum);
        System.out.println("2. The odds average is " + oddAverage);
        System.out.println("3. Max is " + max + " and Min is " + min + "(excluding negatives)");
        System.out.println("4. Number of primes is " + primesCount);
        System.out.println("5. Input numbers in ascending order");
        Collections.sort(myList);
        System.out.println(myList);
        System.out.println("5. Input numbers in descending order");
        Collections.reverse(myList);
        System.out.println(myList);
        System.out.println("6. Negative numbers: " + myList.stream().filter(p -> p<0).count() );
        if( myList.stream().filter(p -> p<0).count()>0 ) {        
            //System.out.println(myList.stream().filter(p -> p<0).toList());
        }
    }
}
