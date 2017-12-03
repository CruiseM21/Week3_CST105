/*
 * Program: Pig Latin Converter
 * File: Pig Latin Converter.java
 * Summary: Reads a small file and converts to Pig Latin
 * Author: Vincent Christaldi
 * Date: 12/03/2017
*/
package pig.latin.converter;

//files to import
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PigLatinConverter 
{
    public static void main(String[] args) 
    {
        //arrays for program
        String[] originalArray = new String[5];
        String[] pigArray = new String[5]; 
        
        //begin try to open file and read it
        try
        {
            //create new reader
            BufferedReader br = new BufferedReader(new FileReader("c:\\TextFile.txt"));
            //while there are data to process
            while(true)
            {
                //read the line
                String str = br.readLine();
                //if end of line break while
                if(str == null)
                    break;
                //otherwise store word into original array
                originalArray = str.split(" ");      
                
            }
            br.close(); //close file
        }
        //catch error if needed
        catch(IOException err)
        {
            err.printStackTrace();
        }
        
        //call convert function to onvert to pig latin
        ConvertArray(pigArray,originalArray);
        
        //display result of both arrays
        for(int index = 0;index != originalArray.length; ++index)
        {
            System.out.print(originalArray[index] + "\t");
            System.out.println(pigArray[index]);
        }
           
    }
    //method to convert text to pig latin
   public static String[] ConvertArray(String[] pigArray, String[] originalArray)
   {
       //pig latin endings
       String ayEnd = "AY";
       String wayEnd = "WAY";
       
       //copy original array to pig array for conversion
       for(int index = 0;index != originalArray.length; ++index)
        {
            //copy elements and convert to uppercase
            pigArray[index] = originalArray[index].toUpperCase();
        }
       
       //search each element for conversion to pig latin
       for(int index = 0;index != pigArray.length;++index)
       {
           //temporary variable for conversion
           String temp = pigArray[index];
           for(int check = 0;check != temp.length();++check)
           {
               //breakdown to individual letters to search for vowels
               char c = temp.charAt(check);
               //if vowel found
               if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
               {
                   //if vowel is not first letter
                   if(check != 0)
                   {
                        pigArray[index] = temp.substring(check)+temp.substring(0,check)+ayEnd;
                   }
                   //if vowel is first letter
                   else
                   {
                       pigArray[index] = temp.substring(check)+temp.substring(0,check)+wayEnd;
                   }
                   //leave loop to search next word
                   break;
               }
           }
           
       }      
       //return final result
       return pigArray;
   }
    
}
