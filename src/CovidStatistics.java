
/**
 * <p>The CovidStatistics class is used for displaying patient count for different provinces through different months. </p>
 * <p>It also displays the total amount of recovered patients for each month. </p>
 * <p>It has a method to calculate the average of each row (province). </p>
 * <p>The average will be rounded up if it is exactly half way between two integers. </p><br>
 * 
 * <p>Limitations: </p>
 * <p>This program has a fixed number of provinces (7) and a fixed number of months (8). </p>
 * <p>If the number of provinces or months change, the program would have to be changed accordingly. </p>
 * <p>This program has no user input. Province names, month names and patient counts are hard-coded in the program. </p>
 * <p>This program does not check for data validity. </p>
 * <p>Patient count has to be an integer (a whole number between -2147483648 and 2147483647) </p>
 * <p>Will produce java.lang.Error if patient count is invalid</p>
 * <p>If the patient number, province count, or month count is modified, the program may produce incorrect results or errors. </p><br>
 * 
 * <p>File name: CovidStatistics.java </p>
 * <p>Author: Ben Nguyen </p>
 * <p>Date: Jun 3, 2023 </p>
 * <p>Purpose: Calculate and display Covid statistics for some Canadian provinces over several months.</p>
 */
public class CovidStatistics
{
    /**
     * @param args The command-line arguments (not used)
     */
public static void main(String[] args)
 {
   final int ROWS = 7;
   final int COLUMNS = 8;

   // 2D array for patients
   int[][] patients = 
      { 
         {  2200, 1100, 1200, 1000, 1015, 2000, 1092, 2204 },
         {  5020, 6105, 2009, 9047, 1016, 2014, 2708, 2308 }, 
         {  1720, 2406, 3054, 1018, 1023, 3100, 1406, 1502 }, 
         {  1490, 2002, 2016, 5008, 2044, 1055, 1607, 2201 },
         {  1520, 1007, 1092, 2065, 1023, 1010, 1046, 1502 },
         {  1670, 1201, 2008, 2001, 1086, 1009, 1041, 1706 },
         {  1870, 2001, 2078, 1006, 1053, 1702, 1009, 1406 }
         
      };

   String[] provinces = 
      { 
         "Ontario", 
         "Quebec", 
         "Nova Scotia",
         "New Brunswick", 
         "Manitoba", 
         "British Columbia",
	     "Prince Edward Island"         
      };
   
   // Changed the spacing between the months from the original code to match the sample output file.
   // Added "Avg" at the end to display the average patient count for each province.
   System.out.println("             Month      Feb     March   April   May     June    July    Aug     Sept    Avg");
   System.out.println();

   for (int row = 0; row < ROWS; row++) {
	   
	   // Outer for loop to display the province names
	   // Use left padding of 20 characters to match the sample output file
	   System.out.printf("%20s",provinces[row]);
	   
	   for (int i = 0; i < COLUMNS; i++) {	   
		   // Inner for loop to display the patient count for each province
		   // Use left padding of 8 characters to match the sample output file
		   System.out.printf("%8d",patients[row][i]);
	   }
	   // Call and print out the result of aveByProvince method for the current month
	   // Use left padding of 8 characters to so that the output would look uniform
	   System.out.printf("%8d", aveByProvince(patients, row) );
	   System.out.println(); // Go to a new line each outer loop
   }

   System.out.println();
   
   System.out.print("   Recovered Patients"); // Changed the spacing from the original code to match the sample output file
   

    // Nested for loop to calculate the sum of each column in the 2D array and print the column sum.
   for (int ii = 0; ii < COLUMNS; ii++) {   
   int sum = 0; // Initialize 'sum' to 0 to calculate a new column every outer loop
	   for (int i = 0; i < ROWS; i++) {   	   
		   sum = sum + patients[i][ii]; // Accumulate the patient numbers in each column of the 2D array
   }
	   System.out.printf("%8d",sum); // Print the column sum, padded to 8 characters to match the sample output file
   }
   
   System.out.println("\n"); // Added a line break from the original code to match the sample output file
   System.out.println(); 
   
// Changed the spacing from the original code to match the sample output file.
   System.out.println("               Vaccinate and maintain good health practices!" );
 }

/**
 * <p>Calculates the average number of patients in a given row (province). </p>
 * <p>If the average is exactly halfway between two integers, it will be rounded up (3.5 will be rounded up to 4.0) </p>
 *
 * @param patients the 2D array representing the number of patients in each province for each month
 * @param row the index of the row (province) to calculate the average for
 * @return the average number of patients in the specified province
 */
public static long aveByProvince(int[][] patients, int row) {  // Method returns a long value because Math.round() returns a long value
	
	int numMonth = 8;
	
	 /* Although sum is an integer, I have to declare it as a double
	  * Because the Math.round method does not work with integers.
	  */
	double sum = 0.0;
	long average = 0;

	// For loop to calculate the sum of a given row
   for (int column = 0; column < 8; column++) {
	   sum = sum + patients[row][column];
   }
   
   average = Math.round(sum/numMonth); // Calculate and round the average
   return average;
}
}