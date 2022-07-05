package ru.ac.uniyar.mf.lzh;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String[] parts = str.split(" ");

        int num1;
        int num2;
        try
        {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Not right");
            return;
        }
        int result;
        switch (parts[1])
        {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0)
                {
                    result = num1 / num2;
                    break;
                }
                else
                {
                    System.out.println("Not right");
                    return;
                }
            default:
                System.out.println("Not right");
                return;
        }
        System.out.println("Answer: " + result);
    }
}