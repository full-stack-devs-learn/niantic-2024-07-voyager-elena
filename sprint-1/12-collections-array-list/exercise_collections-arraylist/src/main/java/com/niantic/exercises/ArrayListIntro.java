package com.niantic.exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListIntro {
    /*
    1. Create an ArrayList of Strings and add the names of your
       5 favorite heroes.

    Return the list.
     */
    public ArrayList<String> getHeroesList() {

//        ArrayList<String> myFavoriteHeroes = new ArrayList<>(5);
//
//        myFavoriteHeroes.add("Wolverine");
//        myFavoriteHeroes.add("Superman");
//        myFavoriteHeroes.add("Captain America");
//        myFavoriteHeroes.add("Black Widow");
//        myFavoriteHeroes.add("Mystique");


        // another way to do it
        ArrayList<String> myFavoriteHeroes = new ArrayList<>(Arrays.asList(new String[]{"Wolverine", "Superman", "Captain America", "Black Widow", "Mystique"}));

        return myFavoriteHeroes;
    }

    /*
    2. Given a list of integers, create and return a new list of just the
       even numbers in the list

       findEvens( [1, 2, 3, 4] )            ->  [2, 4]
       findEvens( [21, 98, 78, 5, 6, 8] )   ->  [98, 78, 6, 8]
     */
    public ArrayList<Integer> findEvens(ArrayList<Integer> numbers) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        for (var num : numbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }

        return evenNumbers;
    }

    /*
    3. Given a list of integers, return the sum of all numbers

       sum( [1, 2, 3, 4] )            ->  10
       sum( [21, 98, 78, 5, 6, 8] )   ->  216
     */
    public int sum(ArrayList<Integer> numbers) {
        int sum = 0;

        for (var num : numbers) {
            sum += num;
        }

        return sum;
    }

    /*
    4. Given a list of integers, return the highest number

       sum( [1, 2, 3, 4] )            ->  4
       sum( [21, 98, 78, 5, 6, 8] )   ->  98
     */
    public int max(ArrayList<Integer> numbers) {
        int maxNumber = Integer.MIN_VALUE;

        for (var num : numbers) {
            maxNumber = Math.max(maxNumber, num);
        }

        return maxNumber;
    }

    /*
    5. Given a list of integers, return the lowest number

       sum( [1, 2, 3, 4] )            ->  1
       sum( [21, 98, -78, 5, 6, 8] )  ->  -78
     */
    public int min(ArrayList<Integer> numbers) {
        int minNumber = Integer.MAX_VALUE;

        for (var num : numbers) {
            minNumber = Math.min(minNumber, num);
        }

        return minNumber;
    }

    /*
    6. Given a list of integers, return the average of all numbers
       This should return the average as an integer, not a floating point

       sum( [3, 1, 59, -4, 81, 23] )    ->  27
       sum( [21, 98, -78, 5, 6, 8] )    ->  53
     */
    public int average(ArrayList<Integer> numbers) {
        // what's a little bit strange that we need to return integer here
        return sum(numbers) / numbers.size();
    }

    /*
    7.  Build an arrayList that holds the fibonacci sequence

        The fibonacci sequence is a numeric pattern 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        - each new number is added by calculating the sum of the previous 2 numbers
          0 + 1 = 1
          1 + 1 = 2
          1 + 2 = 3
          2 + 3 = 5
          etc.
        - the sequence must begin with 0, 1 so size will never be lower than 2

        Include as many numbers as is specified by the size input
     */
    public ArrayList<Integer> buildFibonacci(int size) {
        ArrayList<Integer> fibonacciiList = new ArrayList<>(size);

        fibonacciiList.add(0);
        fibonacciiList.add(1);

        for (int i = 2; i < size; i++) {
            fibonacciiList.add(fibonacciiList.get(i - 2) + fibonacciiList.get(i - 1));
        }

        return fibonacciiList;
    }
}
