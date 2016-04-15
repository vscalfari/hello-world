package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * @author Victoria Scalfari
 * Class: Data Structures, Section 82
 * Date: 4/13/16
 * 
 * The HuffmanDriver class is the driver class for lab 3.
 * It opens and reads through the input file, determining
 * if the line is to be encoded or decoded. Then, it calls
 * methods from the HuffCoding class to either encode or
 * decode the line from the file. After the line has been
 * evaluated, the HuffmanDriver class writes the output
 * to the output file. The main command line string arguments
 * are assumed to be [input file] [output file].
 * 
 */
public class HuffmanDriver 
{
	String output = "";
	/**
	 * The readfile method uses a scanner object to read the 
	 * lines from the input file and generates the encoded or
	 * decoded versions of the lines in the file. Appropriate 
	 * error messages are printed for file errors and input 
	 * file size errors
	 * 
	 * @param inFile - the input file
	 * @param outFile - the output file to write to
	 * @return Matrix[] - the Matrices in the input file
	 * 
	 */
	public void readFile(String inFile, String outFile)
	{
		//create new File and Scanner objects to read the file
	     File inputFile = new File(inFile);
	     Scanner scanFile = null;
	     //a string to store the next line
	     String next = "";
	     //a separate string to store a line
	     String line = "";
	     char currentChar;
	     boolean invalidChar= false;
	     boolean encode = false;
	     boolean decode = false;

	    //use a try so we can handle errors
	     try 
	     {
	
	        //create a new scanner object to read the file with
	    	 scanFile = new Scanner(inputFile);
	            
	         /*while the file has a next line, read the line
	          * and either encode or decode
	         */
	    	 
	         while (scanFile.hasNextLine()) 
	         {
	        	//check if invalidchar flag is set
	        	 
				// get the next line
				line = scanFile.nextLine();
				// if the line is blank
				if (line.equals(" ") || line.equals("") || line.equals("\n")) 
				{
					// skip this line
				} // end if its a blank line
				else 
				{
					//convert line to all lower case
					line.toLowerCase();
					//iterate through each char in the string
					for(int i=0; i<line.length(); i++)
					{
						currentChar = line.charAt(i);
						if(currentChar=='1' || currentChar == '0')
						{
							//we need to decode
							decode = true;
						}//end if 1 or 0
						//if char is a-z
						else if((int)currentChar >=97 && (int)currentChar <= 122)
						{
							encode = true;
						}//end else a-z
						/*
						 * otherwise, the char is INVALID and we should just
						 * ignore it
						 */
				         else
				         {
				        	 //skip line
				        	 invalidChar = true;
				         }//end else invalid char
					}

				} // end else (it's not a blank line)

			} // end while there's a next line
				// we must close the file when we're finished
			scanFile.close();
	     }//end try
	         
	     //if the file cannot be found, exit the program
	     catch (FileNotFoundException exception) 
	     {
	    	 String notFound = "File not found for " + inFile;
	
	    	 //write output to file
	    	 writeOutput(outFile, notFound);
	    	 
	    	 //exit gracefully
	    	 System.exit(1);
	     }//end catch

     
	}//end readline method

	/**
	 * The writeOutput method writes the output and
	 * any error messages to the output file given
	 * 
	 * @param outFile - the output file to write to
	 * @param output - the output that will be written
	 * @return none
	 * 
	 */
	public static void writeOutput(String outFile, String output)
	{
		//use a try so we can error handle
	     try 
	     {
	
	         /*Set up the file writer objects and write the instructions
	          * to the given output file
	          */
	        File outputFile = new File(outFile);
	        FileWriter outWriter = new FileWriter (outputFile);
	        PrintWriter pWriter = new PrintWriter (outWriter);
	        pWriter.println (output);
	        
	        //close the stream when we're finished
	        outWriter.close();
	        pWriter.close();
	     }
	     
	     //if the output file cannot be found, exit the program
	     catch (IOException e) 
	     {
	        /**send an error message to the command 
	         * line (since there's no output file)
	         */
	    	 System.err.println("Error writing to output file: " + outFile);
	    	 
	    	 //exit gracefully
	         System.exit(1);
		} //end catch

	}//end writeOutput method
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
