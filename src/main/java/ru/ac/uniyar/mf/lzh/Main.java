package ru.ac.uniyar.mf.lzh;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static String calculate(String num1, String operation, String num2)
    {
        String[] dop1 = num1.split("/");
        String[] dop2 = num2.split("/");
        /*if (dop1.length == 1 && dop2.length == 1)
        {
            int x1;
            int x2;
            try
            {
                x1 = Integer.parseInt(num1);
                x2 = Integer.parseInt(num2);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Not right input");
                return null;
            }
            int result;
            switch (operation)
            {
                case "+":
                    result = x1 + x2;
                    break;
                case "-":
                    result = x1 - x2;
                    break;
                case "*":
                    result = x1 * x2;
                    break;
                case "/":
                    if (x2 != 0)
                    {
                        result = x1 / x2;
                        break;
                    }
                    else
                    {
                        System.out.println("Division by zero");
                        return null;
                    }
                default:
                    System.out.println("Unknown sign");
                    return null;
            }

            System.out.println("Answer: " + result);
            String str_result = String.valueOf(result);
            return str_result;
        }*/

        Drob d1 = new Drob(), d2 = new Drob();
        d1.ch = Integer.parseInt(dop1[0]);
        d2.ch = Integer.parseInt(dop2[0]);
        if (dop1.length == 2)
        {
            d1.zn = Integer.parseInt(dop1[1]);
            if (d1.zn == 0)
            {
                System.out.println("Division by zero");
                return "Division by zero";
            }
        }
        if (dop2.length == 2)
        {
            d2.zn = Integer.parseInt(dop2[1]);
            if (d2.zn == 0)
            {
                System.out.println("Division by zero");
                return "Division by zero";
            }
        }

        Drob result = new Drob();
        switch (operation)
        {
            case "+":
                result.ch = d1.ch * d2.zn + d2.ch * d1.zn;
                result.zn = d1.zn * d2.zn;
                break;
            case "-":
                result.ch = d1.ch * d2.zn - d2.ch * d1.zn;
                result.zn = d1.zn * d2.zn;
                break;
            case "*":
                result.ch = d1.ch * d2.ch;
                result.zn = d1.zn * d2.zn;
                break;
            case "/":
                if (d2.ch != 0)
                {
                    result.ch = d1.ch * d2.zn;
                    result.zn = d1.zn * d2.ch;
                    break;
                }
                else
                {
                    System.out.println("Division by zero");
                    return "Division by zero";
                }
            default:
                System.out.println("Unknown sign");
                return "Unknown sign";
        }

        for (int i = Math.abs(result.ch) / 2 + 1; i != 1; i--)
        {
            if (result.zn % i == 0 && result.ch % i == 0)
            {
                result.zn = result.zn / i;
                result.ch = result.ch / i;
            }
        }

        if (result.zn == 1)
        {
            System.out.println("Answer: " + result.ch);
            String str_result = String.valueOf(result.ch);
            return str_result;
        }
        else
        {
            System.out.println("Answer: " + result.ch + "/" + result.zn);
            String str_result = String.valueOf(result.ch);
            String dop = String.valueOf(result.zn);
            str_result = str_result + "/" + dop;
            return str_result;
        }
    }

    /*public static int Moda(String num1, String num2)
    {
        ArrayList <Integer> numbers = new ArrayList <> (10);
        for (int i = 0; i < 10; i++)
        {
            numbers.add(0);
        }
        for (int i = 0; i < num1.length(); i++)
        {
            if (num1.charAt(i) <= '0' && num1.charAt(i) <= '9')
            {
                int dop = num1.charAt(i) - 48;
                numbers.set(dop, numbers.get(dop) + 1);
            }
        }
        for (int i = 0; i < num2.length(); i++)
        {
            if (num2.charAt(i) <= '0' && num2.charAt(i) <= '9')
            {
                int dop = num2.charAt(i) - 48;
                numbers.set(dop, numbers.get(dop) + 1);
            }
        }
        int iter_of_max = 0;
        for (int i = 0; i < 10; i++)
        {
            if (numbers.get(iter_of_max) < numbers.get(i))
            {
                iter_of_max = i;
            }
        }
        System.out.println("Moda: " + iter_of_max);
        return iter_of_max;
    }*/

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String num1 = in.next();
        String operation = in.next();
        String num2 = in.next();
        calculate(num1, operation, num2);
        //Moda(num1, num2);
    }
}