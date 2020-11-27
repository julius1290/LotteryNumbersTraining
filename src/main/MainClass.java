package main;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        int length;
        int amount;
        int[] lottery;
        MainClass mainClass = new MainClass();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please give the number pool: ");
        length = scan.nextInt();
        System.out.println("Please give the amount to draw: ");
        amount = scan.nextInt();
        lottery = mainClass.drawing(mainClass.initNumbers(length), amount);
        System.out.println("-----------------------------");
        System.out.println("Please give your tip (eg.: 1,2,3,4,5,6): ");
        String tip = scan.next();
        String[] tipByUser = tip.split(",");
        mainClass.testTip(lottery, tipByUser);
    }

    private int[] initNumbers(int givenLength) {
        int[]  numbers = new int[givenLength];
        for (int i = 1; i <=givenLength; i++)
            numbers[i-1] = i;
        return numbers;
    }

    private int[] drawing(int[] numbers, int givenAmount) {
        int[] drawedNumbers = new int[givenAmount];
        for (int i = givenAmount-1; i >= 0; i--){
            int drawedNumber = (int) (Math.random() * numbers.length) ;
            if (numbers[drawedNumber] == -1) {
                i++;
                continue;
            }
            drawedNumbers[i] = numbers[drawedNumber];
            numbers[drawedNumber] = -1;
        }
        return drawedNumbers;
    }

    private void testTip(int[] drawedNumbers, String[] userTip) {
        for (int i = drawedNumbers.length -1; i >= 0; i--)
            System.out.println(drawedNumbers[i]);
        int countOfSuccessTip = 0;
        for (int i = drawedNumbers.length -1; i >= 0; i--)
        {
            int userNumber = Integer.parseInt(userTip[i]);
            for (int j = drawedNumbers.length -1; j >= 0; j--)
                if (userNumber == drawedNumbers[j])
                    countOfSuccessTip++;
        }
        System.out.println("You have " + countOfSuccessTip +" right tips.");
    }
}
