package ru.ac.uniyar.mf.lzh;

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

        int ch1, zn1 = 1, ch2, zn2 = 1;
        ch1 = Integer.parseInt(dop1[0]);
        ch2 = Integer.parseInt(dop2[0]);
        if (dop1.length == 2)
        {
            zn1 = Integer.parseInt(dop1[1]);
            if (zn1 == 0)
            {
                System.out.println("Division by zero");
                return "Division by zero";
            }
        }
        if (dop2.length == 2)
        {
            zn2 = Integer.parseInt(dop2[1]);
            if (zn2 == 0)
            {
                System.out.println("Division by zero");
                return "Division by zero";
            }
        }
        int res_ch, res_zn;
        switch (operation)
        {
            case "+":
                res_ch = ch1 * zn2 + ch2 * zn1;
                res_zn = zn1 * zn2;
                break;
            case "-":
                res_ch = ch1 * zn2 - ch2 * zn1;
                res_zn = zn1 * zn2;
                break;
            case "*":
                res_ch = ch1 * ch2;
                res_zn = zn1 * zn2;
                break;
            case "/":
                if (ch2 != 0)
                {
                    res_ch = ch1 * zn2;
                    res_zn = zn1 * ch2;
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

        for (int i = res_ch / 2 + 1; i != 1; i--)
        {
            if (res_zn % i == 0 && res_ch % i == 0)
            {
                res_zn = res_zn / i;
                res_ch = res_ch / i;
            }
        }

        if (res_zn == 1)
        {
            System.out.println("Answer: " + res_ch);
            String str_result = String.valueOf(res_ch);
            return str_result;
        }
        else
        {
            System.out.println("Answer: " + res_ch + "/" + res_zn);
            String str_result = String.valueOf(res_ch);
            String dop = String.valueOf(res_zn);
            str_result = str_result + "/" + dop;
            return str_result;
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String num1 = in.next();
        String operation = in.next();
        String num2 = in.next();
        calculate(num1, operation, num2);
    }
}