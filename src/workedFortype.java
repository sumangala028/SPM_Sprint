
//worked code for type

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class workedFortype {
	static String patternString = ".*class\\s+([^{]+)\\s*[:]?([^{]+)\\{";
	static String patternString1 = "^import.*";
	static String patternString_switch = "^switch.*[^\"]$";
	
	static String pattern_if ="^if.*[^\"]$";
	static String pattern_while ="^while.*[^\"]$";
	static String pattern_for ="^for.*[^\"]$";
	
	static String pattern_do ="^do.*[^\"]$";
	static String pattern_else_if ="}?[ ]?(else)\\s(if).*[^\"]$";
	static String pattern_try = "}?[ ]?(try)[ {]*[^\"]$";

	static String pattern_else ="}?[ ]?(else)[ {]*[^\"]$"; //working
	
	public static String fileName_for_switch;
	public static String programStatement_for_switch;
	public static FileReader fileReader_for_switch;
	public static BufferedReader bufferedReader_for_switch;
	public static String stringForSwitch = "";
	public static int count_case_for_switch = 0;
	static int toTcTc_for_program = 0;
	static String fileName;
	
	public static String callFromGUi_for_type(String filename2) {
		
		  System.out.println("________________________________________________________\n");
	     System.out.println("\n Complexity of type Control Structures\n");
	        System.out.println("________________________________________________________\n");
	
		
		// The name of the file to open. (get the file name from user)
		 fileName = filename2;

		

		int totalCtc = 0;


		// This will reference one line at a time
		// line = programStatement
		String programStatement = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((programStatement = bufferedReader.readLine()) != null) {
				totalCtc = 0;
				String with_out_comments = programStatement.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "").toLowerCase().trim();

				if (Pattern.matches(patternString_switch, with_out_comments)) {

					stringForSwitch = stringForSwitch.concat(with_out_comments);
					// System.out.println(stringForSwitch); // yes its worked

					// System.out.println(calc_case_for_switch(with_out_comments));
					totalCtc = totalCtc + calc_case_for_switch(with_out_comments);
					toTcTc_for_program = toTcTc_for_program + totalCtc;
					System.out.println(with_out_comments + " --------------> ctc =  " + totalCtc); // here we have to change it to
																					// return totalCtc 
																					

				} else {

					totalCtc = totalCtc + measureComplexityByType(with_out_comments);
					toTcTc_for_program = toTcTc_for_program + totalCtc;
					
					if ((with_out_comments.equals("}") || Pattern.matches(pattern_do, with_out_comments) || Pattern.matches(pattern_try, with_out_comments)|| with_out_comments.trim().isEmpty() || Pattern.matches(patternString, with_out_comments) ||Pattern.matches(pattern_else, with_out_comments)|| Pattern.matches(patternString1, with_out_comments)))// comments??
						System.out.println(with_out_comments);
					else {
						System.out.println(with_out_comments + " --------------> ctc =  " + totalCtc);						
					}
					
//here also, we call the nesting  method to print cnc
				}

			}

		
			// Always close files.
			bufferedReader.close();

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
System.out.println( "Total  Complexity due to type of control structures = "+toTcTc_for_program );
		// put return statement here, when integrating
	return ( "Total  Complexity due to type of control structures = "+toTcTc_for_program );
	
	}
	public static void main(String[] args) {

		
	}

	public static int calc_case_for_switch(String with_out_comments) {

		count_case_for_switch = 0; // always initialize to zero

		// The name of the file to open. (get the file name from user)
		//fileName_for_switch = "C:\\Users\\User\\Desktop\\test_folder\\check_regex.txt";
		fileName_for_switch = fileName;


		// This will reference one line at a time
		// line = programStatement
		programStatement_for_switch = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader_for_switch = new FileReader(fileName_for_switch);

			bufferedReader_for_switch = new BufferedReader(fileReader_for_switch);

			// while(!(programStatement_for_switch =
			// bufferedReader_for_switch.readLine()).contains("with_out_comments")) {
			while ((programStatement_for_switch = bufferedReader_for_switch.readLine()) != null) {

				String with_out_comments2 = programStatement_for_switch.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "").toLowerCase();

				if (with_out_comments2.contains(with_out_comments)) {
					for (String x = bufferedReader_for_switch.readLine(); ((x != null)&& !(x.contains("switch"))); x = bufferedReader_for_switch.readLine()) {
						// do {

						x = x.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "").toLowerCase().trim();
						if (x.contains("case")) {
							count_case_for_switch++;
						}
						// programStatement_for_switch = bufferedReader_for_switch.readLine();

						// System.out.println(x);

					} // while(!(programStatement_for_switch =
						// bufferedReader_for_switch.readLine()).replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","").toLowerCase().contains("switch")
						// || (programStatement_for_switch = bufferedReader_for_switch.readLine()) !=
						// null );

					break;
				}
				// else { // else part no need
				// // System.out.println(programStatement_for_switch);
				//
				// continue;
				// }

			}

			// Always close files.
			bufferedReader_for_switch.close();

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName_for_switch + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName_for_switch + "'");
		}

		return count_case_for_switch;

	}

	// to calculate the complexity by type of one program statement
	public static int measureComplexityByType(String programStatement) throws IOException {
		String[] array_of_strings_in_program_statement;

		int arraySize;
		int cTC = 0;

//		if (programStatement.contains("if")) {

	if(Pattern.matches(pattern_if, programStatement) || Pattern.matches(pattern_else_if, programStatement))	{
		cTC++;

			array_of_strings_in_program_statement = programStatement.split("\\s");

			arraySize = array_of_strings_in_program_statement.length;

			// to check one program statement
			for (int i = 0; i < arraySize; i++) {

				
			//String one_or = 	"(?=[^\\\"]*(?:\\\"[^\\\"]*\\\"[^\\\"]*)*$)[|](?=[^\"]*(?:\"[^\"]*\"[^\"]*)*$)";
			//System.out.println(array_of_strings_in_program_statement[i]);
//				if(Pattern.matches(or, array_of_strings_in_program_statement[i]) || Pattern.matches(one_or, array_of_strings_in_program_statement[i])) {				
//
//					cTC++;
//			}
							if (array_of_strings_in_program_statement[i].contains("||")|| array_of_strings_in_program_statement[i].contains("|")){

								cTC++;
								}

				if (array_of_strings_in_program_statement[i].contains("&&")|| array_of_strings_in_program_statement[i].contains("&")) {

					cTC++;
				}

			}

		}

		// start of "while" or "for" or "do-while"
	//	if (programStatement.contains("while") || programStatement.contains("for")) {
	if(Pattern.matches(pattern_while, programStatement) || Pattern.matches(pattern_for, programStatement)){

			cTC += 2;

			array_of_strings_in_program_statement = programStatement.split("\\s");

			arraySize = array_of_strings_in_program_statement.length;

			// to check one program statement
			for (int i = 0; i < arraySize; i++) {

				if (array_of_strings_in_program_statement[i].contains("&&")|| array_of_strings_in_program_statement[i].contains("&"))

					cTC += 2;

				if (array_of_strings_in_program_statement[i].contains("||")|| array_of_strings_in_program_statement[i].contains("|"))

					cTC += 2;

			}
		}

		if (Pattern.matches("}?\\s?(catch).*[^\"]$", programStatement)) {
			cTC++;

		}

		return cTC;
	}

}

// have to trim output
