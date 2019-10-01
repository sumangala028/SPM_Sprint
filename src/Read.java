
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.FileReader;
import java.io.IOException;


public class Read {
	
	static BufferedReader objReader = null;
	static int opr_count = 0;
	static int x = 1;
	static int Cs;
	int lines = 0;
	
	public static  String calcArithmeticComplexity(String filename2){
		
		
		  System.out.println("________________________________________________________\n");
		   System.out.println("\n Complexity of due to Size\n");
	        System.out.println("________________________________________________________\n");
	 
		

			
					
					// The name of the file to open. (get the file name from user)
					String fileName = filename2;

					
				
		
		
		try {
			String programStatement;
			objReader = new BufferedReader(new FileReader(fileName));
			
			while((programStatement = objReader.readLine()) != null) {
					
					String currentLine = programStatement.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "").toLowerCase().trim();
					String[] arr = currentLine .split(" ");
					String opr = null;
					
					int num = arr.length;
					for(int i =0; i<num;i++) {
						opr = arr[i];
					
					
			if((!currentLine.startsWith("{")) || (!currentLine.startsWith("}")) || (!currentLine.startsWith("static"))){
					//lines++;
					//System.out.println(currentLine +" x " );
				if((currentLine.startsWith("public"))) {
					continue;
				}
				
				if(!opr.contains(" \" ")){
					//Arithmetic operator count
					if(opr.equals("+")) {
						opr_count++;
					}
					if(opr.equals("-")) {
						opr_count++;
					}
					if(opr.equals("*")) {
						opr_count++;
					}
					if(opr.equals("/")) {
						opr_count++;
					}
					if(opr.equals("=")) {
						opr_count++;
					}
					if(opr.equals("%")) {
						opr_count++;
					}
					if(opr.contains("++")) {
						opr_count++;
					}
					if(opr.contains("--")) {
						opr_count++;
					}
					
					//Relation operator count
					if(opr.contains("==")) {
						opr_count++;
					}
					if(opr.contains("!=")) {
						opr_count++;
					}
					if(opr.equals(">")) {
						opr_count++;
					}
					if(opr.equals("<")) {
						opr_count++;
					}
					if(opr.equals("<=")) {
						opr_count++;
					}
					if(opr.equals(">=")) {
						opr_count++;
					}
					
					//Logical operator count
					if(opr.contains("&&")) {
						opr_count++;
					}
					if(opr.contains("||")) {
						opr_count++;
					}
					if(opr.equals("!")) {
						opr_count++;
					}
					
					//Bitwise operator count
					if(opr.equals("|")) {
						opr_count++;
					}
					if(opr.equals("^")) {
						opr_count++;
					}
					if(opr.equals("~")) {
						opr_count++;
					}
					if(opr.equals("<<")) {
						opr_count++;
					}
					if(opr.equals(">>")) {
						opr_count++;
					}
					if(opr.equals("<<<")) {
						opr_count++;
					}
					if(opr.equals(">>>")) {
						opr_count++;
					}
					
					//Miscellaneous operator count
					if(opr.equals(",")) {
						opr_count++;
					}
					if(opr.equals("->")) {
						opr_count++;
					}
					if(opr.contains(".")) {
						opr_count++;
					}
					if(opr.equals("::")) {
						opr_count++;
					}
					
					//Assignment operator count
					if(opr.equals("+=")) {
						opr_count++;
					}
					if(opr.equals("-=")) {
						opr_count++;
					}
					if(opr.equals("*=")) {
						opr_count++;
					}
					if(opr.equals("/=")) {
						opr_count++;
					}
					if(opr.equals("=")) {
						opr_count++;
					}
					if(opr.equals(">>>=")) {
						opr_count++;
					}
					if(opr.equals("|=")) {
						opr_count++;
					}
					if(opr.equals("&=")) {
						opr_count++;
					}
					if(opr.equals("%=")) {
						opr_count++;
					}
					if(opr.equals("<<=")) {
						opr_count++;
					}
					if(opr.equals(">>=")) {
						opr_count++;
					}
					if(opr.equals("^=")) {
						opr_count++;
					}
					
					//keyword count
					if(opr.contains("void")) {
						opr_count++;
					}
					if(opr.equals("double")) {
						opr_count++;
					}
					if(opr.contains("int")) {
						opr_count++;
					}
					if(opr.equals("float")) {
						opr_count++;
					}
					if(opr.contains("String")) {
						opr_count++;
					}
					if(opr.equals("printf")) {
						opr_count++;
					}
					if(opr.contains("println")) {
						opr_count++;
					}
					if(opr.equals("cout")) {
						opr_count++;
					}
					if(opr.equals("cin")) {
						opr_count++;
					}
					if(opr.equals("if")) {
						opr_count++;
					}
					if(opr.contains("for")) {
						opr_count++;
					}
					if(opr.contains("while")) {
						opr_count++;
					}
					if(opr.contains("switch")) {
						opr_count++;
					}
					if(opr.equals("case")) {
						opr_count++;
					}
					if(opr.equals("abstract")) {
						opr_count++;
					}
					if(opr.equals("continue")) {
						opr_count++;
					}
					if(opr.equals("new")) {
						opr_count++;
					}
					if(opr.equals("assert")) {
						opr_count++;
					}
					if(opr.equals("default")) {
						opr_count++;
					}
					if(opr.equals("super")) {
						opr_count++;
					}
					if(opr.equals("native")) {
						opr_count++;
					}
					if(opr.equals("const")) {
						opr_count++;
					}
					if(opr.equals("strictfp")) {
						opr_count++;
					}
					if(opr.equals("long")) {
						opr_count++;
					}
					if(opr.equals("goto")) {
						opr_count++;
					}
					if(opr.equals("static")) {
						opr_count++;
					}
					if(opr.equals("package")) {
						opr_count++;
					}
					if(opr.equals("synchronized")) {
						opr_count++;
					}
					if(opr.equals("boolean")) {
						opr_count++;
					}
					if(opr.equals("do")) {
						opr_count++;
					}
					if(opr.equals("break")) {
						opr_count++;
					}
					if(opr.equals("private")) {
						opr_count++;
					}
					if(opr.equals("this")) {
						opr_count++;
					}
					if(opr.equals("implements")) {
						opr_count++;
					}
					if(opr.equals("protected")) {
						opr_count++;
					}
					if(opr.equals("throw")) {
						opr_count++;
					}
					if(opr.equals("byte")) {
						opr_count++;
					}
					if(opr.equals("else")) {
						opr_count++;
					}
					if(opr.equals("import")) {
						opr_count++;
					}
					if(opr.equals("public")) {
						opr_count++;
					}
					if(opr.equals("throws")) {
						opr_count++;
					}
					if(opr.equals("enum")) {
						opr_count++;
					}
					if(opr.equals("instanceof")) {
						opr_count++;
					}
					if(opr.equals("return")) {
						opr_count++;
					}
					if(opr.equals("transient")) {
						opr_count++;
					}
					if(opr.equals("catch")) {
						opr_count++;
					}
					if(opr.equals("extends")) {
						opr_count++;
					}
					if(opr.equals("short")) {
						opr_count++;
					}
					if(opr.equals("try")) {
						opr_count++;
					}
					if(opr.equals("char")) {
						opr_count++;
					}
					if(opr.equals("final")) {
						opr_count++;
					}
					if(opr.equals("interface")) {
						opr_count++;
					}
					
					//manipulators count
					if(opr.equals("endl")) {
						opr_count++;
					}
					if(opr.contains("\n")) {
						opr_count++;
					}
					if(opr.equals("setw")) {
						opr_count++;
					}
					if(opr.equals("setprecision")) {
						opr_count++;
					}
					if(opr.equals("setf")) {
						opr_count++;
					} 
					
				}
				
				if(opr.contains("\"")) {
					opr_count++;
				}
				}
				}
				System.out.println("line " + x + " Cs = " + opr_count);
				Cs = Cs + opr_count;
				opr_count = 0;
				x++;
			 }
			
			
			//Cs = opr_count;
			System.out.println("Cs " + Cs);
			//System.out.println("Cs = " + opr_count);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(objReader != null)
					objReader.close();
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		System.out.println("Total Complexity due to Size =  "+Cs);
return ("Total Complexity due to Size  =  "+Cs);
			
	}
	
}
