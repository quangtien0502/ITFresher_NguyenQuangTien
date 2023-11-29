package Exam01;

import java.util.Arrays;
import java.util.Scanner;

public class Exam01 {
    public static void main(String[] args) {

        int[] myArr= new int[15];
        while (true){
            Scanner scanner=new Scanner(System.in);
            System.out.println("Menu:");
            System.out.println("1. Enter the amount of numbers that you want to fill in the array and fill it");
            System.out.println("2. Print all the elements value");
            System.out.println("3. Calculate the average of positive numbers in array");
            System.out.println("4. Print the indexes that have value equal k where k is the value that you will enter");
            System.out.println("5. Use Bubble Sort to sort the array in descending order");
            System.out.println("6. Calculate the amount of Prime Number in array");
            System.out.println("7. Sort all the elements that divided by 3 with ascending order, odd elements that divided by 3 with descending order");
            System.out.println("8. Enter value m from key board, add value m in array(descending order) in correct position");
            System.out.println("9. Exit");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Please enter the amount of elements that you want to enter");
                    int n= scanner.nextInt();

                    for (int i = 0; i < n; i++) {
                        System.out.printf("Elements at position %d has value :",i);
                        myArr[i]=scanner.nextInt();
                    }
                    break;
                case 2:
                    for (int value:myArr
                    ) {
                        System.out.println(value);
                    }
                    break;
                case 3:
                    int sum=0,count=0;
                    for (int i=0;i< myArr.length;i++){
                        if(myArr[i]>0){
                            sum+=myArr[i];
                            count++;
                        }
                    }
                    if(count>0){
                        System.out.println("The average of all positive number in array is "+sum/count);
                    }else {
                        System.out.println("The average of all positive number in array is 0");
                    }
                    break;
                case 4:
                    System.out.println("Please enter value k");
                    int k= scanner.nextInt();
                    for (int i = 0; i < myArr.length; i++) {
                        if(myArr[i]==k){
                            System.out.printf("Array at index %d has the value equal %d",i,k);
                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < myArr.length-1; i++) {
                        for (int j = 0; j < myArr.length-i-1; j++) {
                            if(myArr[j]<myArr[j+1]){
                                int temp = myArr[j];
                                myArr[j] = myArr[j + 1];
                                myArr[j + 1] = temp;

                            }
                        }
                    }
                    break;
                case 6:
                    int primeCount = 0;
                    boolean isPrime=false;
                    for (int i = 0; i < myArr.length; i++) {
                        if(myArr[i]<2){
                            isPrime=false;
                        }
                        for (int j = 2; j < Math.sqrt(myArr[i]); j++) {
                            if(myArr[i]%j==0){
                                isPrime=false;
                                break;
                            }
                            isPrime=true;
                        }
                        if(isPrime){
                            primeCount++;
                        }
                    }
                    System.out.printf("The amount of Prime Numbers in this array is %d",primeCount);
                    break;
                case 7:
                    int amountEvenDivided3=0;  // This is the amount of elements that divided by 3 and Even
                    int amountOddDivided3=0;   // This is the amount of elements that divided by 3 and Odd
                    int amountRest=0;
                    int[] evenDivided3;     // This array contains elements that divided by 3 and Even
                    int[] oddDivided3;      // This array contains elements that divided by 3 and Odd
                    int[] rest;             // This array contains the rest of the array
                    int indexEven=0;
                    int indexOdd=0;
                    int indexRest=0;
                    for (int i = 0; i < myArr.length; i++) {
                        if(myArr[i]%3==0 && myArr[i]%2==0){
                            amountEvenDivided3++;
                        }
                        if(myArr[i]%3==0 && myArr[i]%2==1){
                            amountOddDivided3++;
                        }
                    }
                    amountRest=myArr.length-amountEvenDivided3-amountOddDivided3;
                    evenDivided3=new int[amountEvenDivided3];
                    oddDivided3= new int[amountOddDivided3];
                    rest= new int[amountRest];

                    for (int i = 0; i < myArr.length; i++) {
                        if(myArr[i]%3==0 && myArr[i]%2==0){
                            evenDivided3[indexEven]=myArr[i];
                            indexEven++;
                        }
                        else if(myArr[i]%3==0 && myArr[i]%2==1){
                            oddDivided3[indexOdd]=myArr[i];
                            indexOdd++;
                        }else {
                            rest[indexRest]=myArr[i];
                        }
                    }

                    indexEven=0;
                    indexOdd=0;
                    indexRest=0;
                    Arrays.sort(evenDivided3);
                    Arrays.sort(rest);

                    for (int i = 0; i < oddDivided3.length - 1; i++) {
                        for (int j = 0; j < oddDivided3.length - i - 1; j++) {
                            if (oddDivided3[j] < oddDivided3[j + 1]) {
                                // Swap arr[j] and arr[j+1]
                                int temp = oddDivided3[j];
                                oddDivided3[j] = oddDivided3[j + 1];
                                oddDivided3[j + 1] = temp;
                            }
                        }
                    }

                    for (int i=0;i<myArr.length;i++){
                        if(i<amountEvenDivided3){
                            myArr[i]=evenDivided3[i];
                        } else if (i<(amountEvenDivided3+amountRest)) {
                            myArr[i]=rest[i-amountEvenDivided3];
                        }else {
                            myArr[i]=oddDivided3[i-amountEvenDivided3-amountRest];
                        }
                    }
                    System.out.println("The array after sorting is: ");
                    for (int value:myArr
                    ) {
                        System.out.println(value);
                    }

                    break;
                case 8:
                    System.out.println("Please enter value m");
                    int m=scanner.nextInt();

                    int[] myNewArr = new int[myArr.length+1];
                    for (int i = 0; i < myNewArr.length; i++) {
                        if(i<myArr.length){
                            myNewArr[i]=myArr[i];
                        }else {
                            myNewArr[i]=m;
                        }
                    }

                    for (int i = 0; i < myNewArr.length - 1; i++) {
                        for (int j = 0; j < myNewArr.length - i - 1; j++) {
                            if (myNewArr[j] < myNewArr[j + 1]) {
                                // Swap arr[j] and arr[j+1]
                                int temp = myNewArr[j];
                                myNewArr[j] = myNewArr[j + 1];
                                myNewArr[j + 1] = temp;
                            }
                        }
                    }

                    System.out.println("New Array after add an element and sort is: ");
                    for (int value:myNewArr
                    ) {
                        System.out.println(value);
                    }
                    break;
                case 9:
                    System.out.println("Exiting");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Please enter value from 1-9");
            }
        }



    }
}
