
//worked code for nesting

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.regex.Pattern;

public class Workedfornesting {
	
	static int totalCNc;
	static String x;
	static String patternString = ".*class\\s+([^{]+)\\s*[:]?([^{]+)\\{";
	static String patternString1 = "^import.*";

	static String patternString_switch = "^switch.*[^\"]$";
	static String pattern_if = "^if.*[^\"]$";
	static String pattern_while = "^while.*[^\"]$";
	static String pattern_for = "^for.*[^\"]$";

	static String pattern_do = "^do.*[^\"]$";
	static String pattern_else_if = "}?[ ]?(else)\\s(if).*[^\"]$";
	static String pattern_try = "}?[ ]?(try)[ {]*[^\"]$";
	static String pattern_else = "}?[ ]?(else)[ {]*[^\"]$"; // working
	static int toTcNc_for_program = 0;
	static Stack stack = new Stack();
	
	
	public static String callFromGUi_for_nesting(String filename2) {
		  System.out.println("________________________________________________________\n");
        System.out.println("\n Complexity of nesting Control Structures\n");
        System.out.println("________________________________________________________\n");
 
	

		
				
				// The name of the file to open. (get the file name from user)
				String fileName = filename2;

				// This will reference one line at a time
				// line = programStatement
				String programStatement = null;

				try {
					// FileReader reads text files in the default encoding.
					FileReader fileReader = new FileReader(fileName);

					BufferedReader bufferedReader = new BufferedReader(fileReader);

					while ((programStatement = bufferedReader.readLine()) != null) { // 1
						totalCNc = 0;
						String with_out_comments = programStatement
								.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "").toLowerCase().trim();

						if ((Pattern.matches(pattern_if, with_out_comments) || Pattern.matches(pattern_for, with_out_comments)
								|| Pattern.matches(pattern_do, with_out_comments)
								|| Pattern.matches(pattern_while, with_out_comments)
								|| Pattern.matches(pattern_else, with_out_comments)
								|| Pattern.matches(pattern_else_if, with_out_comments)) && with_out_comments.endsWith("{")) { // 2
							stack.push("{");
							totalCNc++;
							//toTcNc_for_program = toTcNc_for_program + totalCNc;

//							if (!(with_out_comments.contains("else"))) {
//								System.out.println(with_out_comments + " cnc = " + totalCNc);
//							}
//							if (with_out_comments.trim().isEmpty() || (with_out_comments.equals("else{"))) {
//								System.out.println(with_out_comments);
		//
//							}
							if ((Pattern.matches("^}$", with_out_comments) || Pattern.matches(pattern_else, with_out_comments)
									|| Pattern.matches(pattern_try, with_out_comments) || with_out_comments.trim().isEmpty()
									|| Pattern.matches(patternString, with_out_comments)
									|| Pattern.matches(patternString1, with_out_comments))) { // comments?
								System.out.println(with_out_comments); // haveto come return statement
							} else {
								System.out.println(with_out_comments + " --------------> cnc = " + totalCNc);// haveto come return
								toTcNc_for_program = toTcNc_for_program + totalCNc;
																	

							}
		 
							for (x = bufferedReader.readLine(); !(stack.isEmpty()); x = bufferedReader.readLine()) { // count
																														// //3
																														// of "{
																														// "
																														// becomes
																														// 0
																														// when
																														// last
																														// "}"
																														// met ,
																														// see
																														// dsa
																														// book
								// for (String x = bufferedReader.readLine();( !(x.contains("}")) ||
								// !(x.contains("if")) || !(x.contains("while")) || !(x.contains("for")) ||
								// !(x.contains("do")) ); x = bufferedReader.readLine()) {

								// do {

								x = x.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "").toLowerCase().trim();

								if ((Pattern.matches(pattern_if, x) || Pattern.matches(pattern_for, x)
										|| Pattern.matches(pattern_do, x) || Pattern.matches(pattern_while, x)
										|| Pattern.matches(pattern_else, x) || Pattern.matches(pattern_else_if, x))
										&& x.endsWith("{")) { // 4
									totalCNc++;
									stack.push("{");

									if (x.contains("}")) {

										stack.pop();
										totalCNc--;
									}

									if (Pattern.matches(pattern_else, x) || Pattern.matches(pattern_do, x)) { // 5
										System.out.println(x); // haveto come retun
									} else { // 5
										System.out.println(x + " --------------> cnc =  " + totalCNc); // haveto come return statement
										toTcNc_for_program = toTcNc_for_program + totalCNc;

									}
								}
//								else {
//									System.out.println(x + " cnc = " + totalCNc);
		//
//								}
								// programStatement_for_switch = bufferedReader_for_switch.readLine();

								// System.out.println(x);

								else if (Pattern.matches("^}$", x)) { // 4
									stack.pop();
									totalCNc--;
									System.out.println(x);// haveto come return statemen
								} else if (x.trim().isEmpty()) { // 4
									System.out.println(x);// haveto come return stateme

								} else {
									System.out.println(x +  " --------------> cnc =  "  + totalCNc);// haveto come return statemen
									toTcNc_for_program = toTcNc_for_program + totalCNc;

								}

							} // end of for loop

							// while(!(programStatement_for_switch =
							// bufferedReader_for_switch.readLine()).replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","").toLowerCase().contains("switch")
							// || (programStatement_for_switch = bufferedReader_for_switch.readLine()) !=
							// null );
							with_out_comments = x;
						} else {

							if ((Pattern.matches("^}$", with_out_comments) || Pattern.matches(pattern_else, with_out_comments)
									|| Pattern.matches(pattern_try, with_out_comments) || with_out_comments.trim().isEmpty()
									|| Pattern.matches(patternString, with_out_comments)
									|| Pattern.matches(patternString1, with_out_comments)))// comments??
								System.out.println(with_out_comments); // haveto come return statement
							else {
								System.out.println(with_out_comments +  " --------------> cnc =  " + totalCNc);// haveto come return
								toTcNc_for_program = toTcNc_for_program + totalCNc;
																	
							}

						}

					} // end of while loop

					// Always close files.
					bufferedReader.close();

				} catch (FileNotFoundException ex) {
					System.out.println("Unable to open file '" + fileName + "'");
				} catch (IOException ex) {
					System.out.println("Error reading file '" + fileName + "'");
				}

				// put return statement here, when integratingsys
			System.out.println("Total Complexity due to nesting of control structures =  "+toTcNc_for_program);
return ("Total Complexity due to nesting of control structures =  "+toTcNc_for_program);
				
	}

	public static void main(String[] args) {
		

		
	}

}

//***************************************************************************
// last worked code
// public class Test_nesting {
//
// public static void main(String[] args) {
// int totalCNc;
// String x;
//
// Stack stack = new Stack();
//
// // The name of the file to open. (get the file name from user)
// String fileName = "C:\\Users\\Amuthini\\Desktop\\this time will not come
// again\\test_folder\\test1.txt";
//
// // This will reference one line at a time
// // line = programStatement
// String programStatement = null;
//
// try {
// // FileReader reads text files in the default encoding.
// FileReader fileReader = new FileReader(fileName);
//
// BufferedReader bufferedReader = new BufferedReader(fileReader);
//
// while ((programStatement = bufferedReader.readLine()) != null) {
// totalCNc = 0;
// String with_out_comments = programStatement
// .replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)",
// "").toLowerCase().trim();
//
// if (with_out_comments.contains("if") || with_out_comments.contains("for")
// || with_out_comments.contains("do") || with_out_comments.contains("while")
// || with_out_comments.contains("else") && with_out_comments.contains("{")) {
// stack.push("{");
// totalCNc++;
//
// if (!(with_out_comments.contains("else"))) {
// System.out.println(with_out_comments + " cnc = " + totalCNc);
// }
//
// for (x = bufferedReader.readLine(); (!(x.contains("}"))); x =
// bufferedReader.readLine()) { // count
// // of "{
// // "
// // becomes
// // 0
// // when
// // last
// // "}"
// // met ,
// // see
// // dsa
// // book
// // for (String x = bufferedReader.readLine();( !(x.contains("}")) ||
// // !(x.contains("if")) || !(x.contains("while")) || !(x.contains("for")) ||
// // !(x.contains("do")) ); x = bufferedReader.readLine()) {
//
// // do {
//
// x = x.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)",
// "").toLowerCase().trim();
//
// if (x.contains("if") || x.contains("for") || x.contains("do") ||
// x.contains("while")) {
// totalCNc++;
// System.out.println(x + " cnc = " + totalCNc);
// } else {
// System.out.println(x + " cnc = " + totalCNc);
//
// }
// // programStatement_for_switch = bufferedReader_for_switch.readLine();
//
// // System.out.println(x);
//
// if (x.contains("}")) {
// totalCNc--;
// }
// if(with_out_comments.trim().isEmpty()) {
// System.out.println(with_out_comments);
//
// }
//
// } // end of for loop
//
// // while(!(programStatement_for_switch =
// //
// bufferedReader_for_switch.readLine()).replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","").toLowerCase().contains("switch")
// // || (programStatement_for_switch = bufferedReader_for_switch.readLine()) !=
// // null );
//
// } else {
// String patternString = ".*class.*";
// String patternString1 = "^import.*";
//
// if ((with_out_comments.equals("}") || with_out_comments.trim().isEmpty()
// || Pattern.matches(patternString, with_out_comments)
// || Pattern.matches(patternString1, with_out_comments))) // comments??
// System.out.println(with_out_comments);
// else
// System.out.println(with_out_comments + " cnc = " + totalCNc);
//
// }
//
// }
//
// // Always close files.
// bufferedReader.close();
//
// } catch (FileNotFoundException ex) {
// System.out.println("Unable to open file '" + fileName + "'");
// } catch (IOException ex) {
// System.out.println("Error reading file '" + fileName + "'");
// }
//
// // put return statement here, when integrating
// }
//
// }
//******************************************************* 17/09/2019

//worked code for nesting
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Stack;
//import java.util.regex.Pattern;
//
//public class Workedfornesting {
//
//	public static void main(String[] args) {
//		int totalCNc;
//		String x;
//		String patternString = ".*class\\s+([^{]+)\\s*[:]?([^{]+)\\{";
//		String patternString1 = "^import.*";
//
//		String patternString_switch = "^switch.*[^\"]$";
//		String pattern_if = "^if.*[^\"]$";
//		String pattern_while = "^while.*[^\"]$";
//		String pattern_for = "^for.*[^\"]$";
//
//		String pattern_do = "^do.*[^\"]$";
//		String pattern_else_if = "}?[ ]?(else)\\s(if).*[^\"]$";
//		String pattern_try = "}?[ ]?(try)[ {]*[^\"]$";
//		String pattern_else = "}?[ ]?(else)[ {]*[^\"]$"; // working
//		int toTcNc_for_program = 0;
//		Stack stack = new Stack();
//
//		// The name of the file to open. (get the file name from user)
//		String fileName = "C:\\Users\\User\\Desktop\\test_folder\\check_regex.txt";
//
//		// This will reference one line at a time
//		// line = programStatement
//		String programStatement = null;
//
//		try {
//			// FileReader reads text files in the default encoding.
//			FileReader fileReader = new FileReader(fileName);
//
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//			while ((programStatement = bufferedReader.readLine()) != null) { // 1
//				totalCNc = 0;
//				String with_out_comments = programStatement
//						.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "").toLowerCase().trim();
//
//				if ((Pattern.matches(pattern_if, with_out_comments) || Pattern.matches(pattern_for, with_out_comments)
//						|| Pattern.matches(pattern_do, with_out_comments)
//						|| Pattern.matches(pattern_while, with_out_comments)
//						|| Pattern.matches(pattern_else, with_out_comments)
//						|| Pattern.matches(pattern_else_if, with_out_comments)) && with_out_comments.endsWith("{")) { // 2
//					stack.push("{");
//					totalCNc++;
//					//toTcNc_for_program = toTcNc_for_program + totalCNc;
//
////					if (!(with_out_comments.contains("else"))) {
////						System.out.println(with_out_comments + " cnc = " + totalCNc);
////					}
////					if (with_out_comments.trim().isEmpty() || (with_out_comments.equals("else{"))) {
////						System.out.println(with_out_comments);
////
////					}
//					if ((Pattern.matches("^}$", with_out_comments) || Pattern.matches(pattern_else, with_out_comments)
//							|| Pattern.matches(pattern_try, with_out_comments) || with_out_comments.trim().isEmpty()
//							|| Pattern.matches(patternString, with_out_comments)
//							|| Pattern.matches(patternString1, with_out_comments))) { // comments?? //3
//						System.out.println(with_out_comments); // haveto come return statement9999999999
//					} else {
//						System.out.println(with_out_comments + " --------------> cnc = " + totalCNc);// haveto come return
//						toTcNc_for_program = toTcNc_for_program + totalCNc;
//															// statement9999999999 //3
//
//					}
////!(x.contains("}")) 
//					for (x = bufferedReader.readLine(); !(stack.isEmpty()); x = bufferedReader.readLine()) { // count
//																												// //3
//																												// of "{
//																												// "
//																												// becomes
//																												// 0
//																												// when
//																												// last
//																												// "}"
//																												// met ,
//																												// see
//																												// dsa
//																												// book
//						// for (String x = bufferedReader.readLine();( !(x.contains("}")) ||
//						// !(x.contains("if")) || !(x.contains("while")) || !(x.contains("for")) ||
//						// !(x.contains("do")) ); x = bufferedReader.readLine()) {
//
//						// do {
//
//						x = x.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "").toLowerCase().trim();
//
//						if ((Pattern.matches(pattern_if, x) || Pattern.matches(pattern_for, x)
//								|| Pattern.matches(pattern_do, x) || Pattern.matches(pattern_while, x)
//								|| Pattern.matches(pattern_else, x) || Pattern.matches(pattern_else_if, x))
//								&& x.endsWith("{")) { // 4
//							totalCNc++;
//							stack.push("{");
//
//							if (x.contains("}")) {
//
//								stack.pop();
//								totalCNc--;
//							}
//
//							if (Pattern.matches(pattern_else, x) || Pattern.matches(pattern_do, x)) { // 5
//								System.out.println(x); // haveto come return statement9999999999
//							} else { // 5
//								System.out.println(x + " cnc = " + totalCNc); // haveto come return statement9999999999
//								toTcNc_for_program = toTcNc_for_program + totalCNc;
//
//							}
//						}
////						else {
////							System.out.println(x + " cnc = " + totalCNc);
////
////						}
//						// programStatement_for_switch = bufferedReader_for_switch.readLine();
//
//						// System.out.println(x);
//
//						else if (Pattern.matches("^}$", x)) { // 4
//							stack.pop();
//							totalCNc--;
//							System.out.println(x);// haveto come return statement9999999999
//						} else if (x.trim().isEmpty()) { // 4
//							System.out.println(x);// haveto come return statement9999999999
//
//						} else {
//							System.out.println(x + " cnc = " + totalCNc);// haveto come return statement9999999999 //4
//							toTcNc_for_program = toTcNc_for_program + totalCNc;
//
//						}
//
//					} // end of for loop
//
//					// while(!(programStatement_for_switch =
//					// bufferedReader_for_switch.readLine()).replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","").toLowerCase().contains("switch")
//					// || (programStatement_for_switch = bufferedReader_for_switch.readLine()) !=
//					// null );
//					with_out_comments = x;
//				} else {
//
//					if ((Pattern.matches("^}$", with_out_comments) || Pattern.matches(pattern_else, with_out_comments)
//							|| Pattern.matches(pattern_try, with_out_comments) || with_out_comments.trim().isEmpty()
//							|| Pattern.matches(patternString, with_out_comments)
//							|| Pattern.matches(patternString1, with_out_comments)))// comments?? //4
//						System.out.println(with_out_comments); // haveto come return statement9999999999
//					else {
//						System.out.println(with_out_comments + " cnc = " + totalCNc);// haveto come return
//						toTcNc_for_program = toTcNc_for_program + totalCNc;
//															// statement9999999999 //4
//					}
//
//				}
//
//			} // end of while loop
//
//			// Always close files.
//			bufferedReader.close();
//
//		} catch (FileNotFoundException ex) {
//			System.out.println("Unable to open file '" + fileName + "'");
//		} catch (IOException ex) {
//			System.out.println("Error reading file '" + fileName + "'");
//		}
//
//		// put return statement here, when integratingsys
//		System.out.println(toTcNc_for_program);
//	}
//
//}