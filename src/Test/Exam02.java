package Test;

import java.util.Scanner;

public class Exam02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your row: ");
        int row = scanner.nextInt();
        System.out.println("Please enter your row: ");
        int col = scanner.nextInt();

        int[][] myArr = new int[row][col];

        while (true) {
            System.out.println("Menu");
            System.out.println("1.Enter elements value");
            System.out.println("2. Print the value of all elements in matrix form");
            System.out.println("3. Calculate the amount of elements that is divided by 2 and 3");
            System.out.println("4.Print the value and calculate the sum of all elements in main boundary,diagonal and sub-diagonal in matrix");
            System.out.println("5.Sort the matrix with the column of the matrix");
            System.out.println("6.Print all the prime numbers in the array");
            System.out.println("7.Using insertion sort to sort all the elements on the main diagonal of the matrix");
            System.out.println("8.Enter 1 dimension array with length is the row of our array and the index row that want to add. Add that row into the new array");
            System.out.println("9. Exit");
            System.out.println("Please enter your choice");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i <row ; i++) {
                        for (int j = 0; j < col; j++) {
                            System.out.printf("The value at index [%d][%d]",i,j);
                            myArr[i][j]=scanner.nextInt();
                        }
                    }
                    break;
                case 2:
                    for (int i=0;i<row;i++){
                        for (int j=0;j<col;j++){
                            System.out.print(myArr[i][j]+"\t");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    int count=0;
                    for (int i=0;i<row;i++){
                        for (int j=0;j<col;j++){
                            if(myArr[i][j]%3==0 && myArr[i][j]%2==0){
                                count++;
                            }
                        }

                    }
                    System.out.println("The amount of elements that are divided by 2 and 3 are "+count);
                    break;
                case 4:
                    int sumMainDiagonal=0,sumSubDiagonal=0,sumBoundary=0;
                    int[][] mySquareArray;
                    if(row==col){
                        mySquareArray = new int[row][col];
                        mySquareArray=myArr;
                    }else {
                        while (row!=col){
                            System.out.println("Please enter a square matrix");
                            System.out.println("Please enter your row: ");
                            row = scanner.nextInt();
                            System.out.println("Please enter your row: ");
                            col = scanner.nextInt();

                        }

                            mySquareArray= new int[row][col];
                            for (int i = 0; i <row ; i++) {
                                for (int j = 0; j < col; j++) {
                                    System.out.printf("The value at index [%d][%d]",i,j);
                                    mySquareArray[i][j]=scanner.nextInt();
                                }
                            }
                            myArr=mySquareArray;

                    }





                    System.out.println("All the elements on main diagonal are");
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if(i==j){
                                System.out.println(mySquareArray[i][j]);
                                sumMainDiagonal+=mySquareArray[i][j];
                            }
                        }
                    }
                    System.out.println("All the elements on sub diagonal are");
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if(i+j==row-1){
                                System.out.println(mySquareArray[i][j]);
                                sumSubDiagonal+=mySquareArray[i][j];
                            }
                        }
                    }

                    System.out.println("All the value at the boundary is ");
                    for(int i=0;i<row;i++){
                        for(int j=0;j<col;j++){
                            if(i==0 || j==0 || i==row-1 || j==col-1){
                                System.out.println(mySquareArray[i][j]);
                                sumBoundary+=mySquareArray[i][j];
                            }
                        }
                    }
                    System.out.println("Sum of all elements in Main Diagonal is "+sumMainDiagonal);
                    System.out.println("Sum of all elements in Main Diagonal is "+sumSubDiagonal);
                    System.out.println("Sum of all elements in Main Diagonal is "+sumBoundary);

                    break;
                case 5:
                    for (int j=0;j<col;j++){
                        for (int i=0;i<row-1;i++){
                            for(int k=i+1;k<row;k++){
                                if(myArr[i][j]<myArr[k][j]){
                                    int temp=myArr[i][j];
                                    myArr[i][j]=myArr[k][j];
                                    myArr[k][j]=temp;
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    int primeCount = 0;
                    boolean isPrime=false;
                    for (int i = 0; i < row; i++) {
                        for (int k = 0; k < col; k++) {
                            if(myArr[i][k]<2){
                                isPrime=false;
                            }
                            for (int j = 2; j < Math.sqrt(myArr[i][k]); j++) {
                                if(myArr[i][k]%j==0){
                                    isPrime=false;
                                    break;
                                }
                                isPrime=true;
                            }
                            if(isPrime){
                                primeCount++;
                            }
                        }
                    }
                    System.out.printf("The amount of Prime Numbers in this array is %d",primeCount);
                    break;
                case 7:
                    int[] myMainDiagonalArray;
                    while (row!=col){
                        System.out.println("Please enter a square matrix");
                        System.out.println("Please enter your row: ");
                        row = scanner.nextInt();
                        System.out.println("Please enter your row: ");
                        col = scanner.nextInt();
                    }
                    myMainDiagonalArray= new int[row];
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if(i==j){
                                myMainDiagonalArray[i]=myArr[i][j];
                            }
                        }
                    }
                    for (int i = 1; i < myMainDiagonalArray.length; ++i) {
                        int key = myMainDiagonalArray[i];
                        int j = i - 1;


                        while (j >= 0 && myMainDiagonalArray[j] < key) {
                            myMainDiagonalArray[j + 1] = myMainDiagonalArray[j];
                            j = j - 1;
                        }


                        myMainDiagonalArray[j + 1] = key;
                    }

                    for (int i = 0; i < row; i++) {
                        myArr[i][i]=myMainDiagonalArray[i];
                    }
                    System.out.println("Array after sorting ");
                    for (int i=0;i<row;i++){
                        for (int j=0;j<col;j++){
                            System.out.print(myArr[i][j]+"\t");
                        }
                        System.out.println();
                    }
                    break;
                case 8:
                    int[][] myNewArr=new int[row][col+1];
                    int[] addArr=new int[row];
                    int indexAdd=100;
                    System.out.println("Please enter the one dimension array that you want to fill in");
                    for (int i = 0; i < row; i++) {
                        System.out.printf("Element at position %d have value:",i);
                        addArr[i]=scanner.nextInt();
                    }
                    while (indexAdd>col+1){
                        System.out.println("please enter the position that you want to add this arr");
                        indexAdd= scanner.nextInt();
                    }
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col+1; j++) {
                            if(j<indexAdd){
                                myNewArr[i][j]=myArr[i][j];
                            } else if (j==indexAdd) {
                                myNewArr[i][j]=addArr[i];
                            }else {
                                myNewArr[i][j]=myArr[i][j-1];
                            }
                        }
                    }
                    System.out.println("The new Array after add is ");
                    for (int i=0;i<row;i++){
                        for (int j=0;j<col+1;j++){
                            System.out.print(myNewArr[i][j]+"\t");
                        }
                        System.out.println();
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
