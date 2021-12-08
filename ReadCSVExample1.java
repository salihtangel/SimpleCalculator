import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadCSVExample1
{

    public static void main(String[] args) throws Exception
    {
        //parsing a CSV file into Scanner class constructor

        BufferedReader filer;
        String line;
        filer = new BufferedReader(new FileReader("3550mhz_v4_realized_gain.txt"));

       // System.out.println(sc.next().getClass().getName());
        Double[][] arr = new Double[10000000][8];
        int i=0;
        filer.readLine();

        while ((line=filer.readLine())!= null)  //returns a boolean value
        {


            String[] values = line.split(",");
            for (int j = 0; j < values.length; ++j) {
                
                try {

                    arr[i][j]=(Double.parseDouble(values[j]));

                }
                catch (NoSuchElementException  |  NumberFormatException a){}
            }
            ++i;
        }
        filer.close();  //closes the scanner
        System.out.println("i : " + i);
        
        FileWriter file;
        file = new FileWriter("output.csv");

        for (int k = 0; k < i; ++k) {

            for (int l = 0; l < 8; ++l) {

            	if (l == 7)
                	file.write(arr[k][l] + "\n");
                else
                	file.write(arr[k][l] + ",");
            }
        }


        file.close();
    }

    public static void main(String[] args) {

    }

}