/* generate all prime numbers between two given numbers! */


/* package whatever; // don't place package name! */

import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        BigInteger bg = null;
        int n = sc.nextInt();
        int a, b;
        while(n-->0)
        {
            a = sc.nextInt();
            b = sc.nextInt();
            for(int j=a; j<=b; j++)
            {
                bg = new BigInteger("" + j);
                if(bg.isProbablePrime(10))
                {
                    System.out.println(bg);
                }
            }
            
        }
    }
}