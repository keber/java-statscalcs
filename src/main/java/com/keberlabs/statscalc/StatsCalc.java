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
 * 3. Max and Min of input numbers, exlcuding negatives.
 * 4. Number of prime numbers.
 * 5. Show input numbers in ascending and descending order.
 * 6. Show negative input numbers, if any
 * 
 * @author Keber
 * 
 */


public class StatsCalc {

    public static boolean isPrime(int n){
        if (n<=0) return false;
        if ((n>0) && (n<=2)) return true;
        return (boolean)(divisorsOf(n)==1);
    }
    
    public static int divisorsOf(int n){
        int k=0;
        for(int i=1;i<=n/2;i++){
            if(n%i==0) k++;
        }
        return k;
    }
    
    public static void main(String[] args) {
        Scanner myScanner = new Scanner( System.in);
        
        System.out.println("Advanced Statistics Calculator");
        System.out.println("Please enter the number of elements to ingest: ");
        int numberOfElements = myScanner.nextInt();
        
        long sum=0;
        int min=32767;
        int max=0;
        int oddAverage=0;
        int oddN=0;
        
        List<Integer> myList = new ArrayList<>();
        List<Integer> myNegativeList = new ArrayList<>();
        List<Boolean> isPrimeList = new ArrayList<>();
        for(int i = 0; i < numberOfElements ; i++){
            System.out.println("Enter item " + (i+1) + ": ");
            int n = myScanner.nextInt();
            myList.add(n);
            sum+=n;
            if(n%2!=0){ // if odd
                oddAverage+=n;
                oddN++;
            }
            if(n>0){        // exclude negatives
                min=(min>n)?n:min;
                max=(max<n)?n:max;
            }
            else {
                myNegativeList.add(n);
            }
            isPrimeList.add(isPrime(n));
        }
        oddAverage/=oddN;
        
        /*
        for(int i=0;i < numberOfElements; i++){
            System.out.println( myList.get(i) + ((isPrimeList.get(i))?" is ":" is not ") + "prime - divisors: " + divisorsOf(myList.get(i)));
        }
        */
        
        //long primesCount = isPrimeList.stream().filter(p -> p == true).count();
        long primesCount = myList.stream().filter(p -> isPrime(p)).count();
        
        System.out.println("1. The sum is " + sum);
        System.out.println("2. The odds average is " + oddAverage);
        System.out.println("3. Max is " + max + "and Min is " + min);
        System.out.println("4. Number of primes is " + primesCount);
        System.out.println("5. Input numbers in ascending order");
        Collections.sort(myList);        
        for ( Integer number: myList ){
            System.out.println(number);
        }
        System.out.println("5. Input numbers6 in descending order");
        Collections.reverse(myList);        
        for ( Integer number: myList ){
            System.out.println(number);
        }
    }
}
