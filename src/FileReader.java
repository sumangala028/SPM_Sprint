import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
 
public class FileReader {
	

	String fileName;  
	
    static ArrayList<Mapper> readClasses = new ArrayList<Mapper>();
    static int lines = 0;
    static String strCurrentLine;
 
    public FileReader(String string) {
        // TODO Auto-generated constructor stub
    }
 
    private static int findIndexOfClassByName(String className) {
        for (int i = 0; i < readClasses.size(); i++) {
            if (new String(className).equals(readClasses.get(i).getMainClassName())) {
                return i;
            }
        }
        // If not in the list, create new class and add to arrayList
        readClasses.add(new Mapper(className));
        return (readClasses.size() - 1); // last one is newly added class
    }
 
    private static int getAncestorClassCount(Mapper childClass) {
        if (childClass.getParentClass() == null) {
            return 0;
        } else {
            return 1 + getAncestorClassCount(childClass.getParentClass()); // recursive method
        }
    }
 //
    
    public static String callFromGUi_for_inheritance(String filename2)throws IOException {
		
    	

		
		
		// The name of the file to open. (get the file name from user)
		String fileName = filename2;
		
	      // File Read
        BufferedReader objReader = null;
 
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader location = new BufferedReader(in);
 
//        System.out.println("Enter The location");
//        String name = location.readLine();
//         
        // File file = new
        // File("C:\\Users\\Sumi\\eclipse-workspace\\SPM_final\\src\\spm.java");
        File file = new File(fileName);
 
        try {
 
            java.io.FileReader fr = new java.io.FileReader(file);
 
            objReader = new BufferedReader(fr);
 
            Mapper childClassObject = null;
 
            // ArrayList<String> classlist = new ArrayList<String>();
            // ArrayList<String> ancestorlist = new ArrayList<String>();
 
            // Loop Lines in the file
            while ((strCurrentLine = objReader.readLine()) != null) {
                String originlLine = strCurrentLine;
                //strCurrentLine = strCurrentLine.trim().toUpperCase();
                String[] excludedLineChars = new String[] { "{", "}", "{{", "}}", "{{{", "}}}", "//", "///", "/*", "*", "*/"};
                List<String> excludedLineCharsList = Arrays.asList(excludedLineChars);
                
                //System.out.println("line before if condition");
 
                if (strCurrentLine != "" && !excludedLineCharsList.contains(strCurrentLine)) {
                    // Excluding methods
                    if (!strCurrentLine.startsWith("PUBLIC") && !strCurrentLine.startsWith("PRIVATE")
                            && !strCurrentLine.startsWith("PROTECTED") && !strCurrentLine.startsWith("STATIC")
                            && !strCurrentLine.startsWith("VOID") && !strCurrentLine.trim().startsWith("//") 
                            && !strCurrentLine.trim().startsWith("/*") && !strCurrentLine.trim().startsWith("*") 
                            && !strCurrentLine.trim().startsWith("*/") && !strCurrentLine.trim().startsWith("}") ) {
 
                        lines++;
                        
                        
                        
                        // regular expression
                        String rel = "class\\s+((?:[a-z][a-z]*[0-9]*[a-z0-9]*))\\sextends\\s((?:[a-z][a-z]*[0-9]*[a-z0-9]*))";
 
                        Pattern p = Pattern.compile(rel, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
                        Matcher m = p.matcher(strCurrentLine);
                         //System.out.println("regular");
                        //System.out.println("printing lines ==> " +strCurrentLine);
                        //
 
                        if (m.find()) {
                        	//System.out.println("line debugging ");
                            String childClassName = m.group(1);
                            String parentClassName = m.group(2);
 
                           
                            if (parentClassName != null) {
                            	
                                int parentClassIndex = findIndexOfClassByName(parentClassName); // add to the
                                                                                                // readClasses
                                                                                                // and return the index
                                Mapper parentClassObject = readClasses.get(parentClassIndex);
 
                                int childClassIndex = findIndexOfClassByName(childClassName);
                                childClassObject = readClasses.get(childClassIndex);
 
                                childClassObject.addParentClass(parentClassObject);
                            } else {
                                // when we call findIndexOfClassByName, will also add to readClasses if not
                                // exist
                                findIndexOfClassByName(childClassName);
                            }
 
                        }
 
                        if (childClassObject != null) {
                            childClassObject.addOneLine(originlLine.trim());
                        }
 
                    } else {
                         //System.out.println("Starting with excluding methods : " + strCurrentLine);
                    }
                }
            }
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
        // finally loop the readclasses and print the ancestor count
        int maxAncestorClasscount = 0;
 
        int sum = 0;
        //System.out.println("Initial sum = \n\n"+sum);
        System.out.println("________________________________________________________\n");
        System.out.println("\nInheritance value for line by line in the sample code");
        System.out.println("________________________________________________________\n");
 
        for (Mapper readClass : readClasses) {
        	//System.out.println("loop of readclass");
            int weight = 0;
            int ancestorClassCount = getAncestorClassCount(readClass);
            int totLines = readClass.getTotalLines();
            weight = (ancestorClassCount + 1) * totLines;
            
            
            System.out.print(readClass.getMainClassName() + " [Lines " + totLines + " ]");
            System.out.println(" ==> Ancestor Class Count : " + ancestorClassCount + " | Sum : " + sum);
           
            if (ancestorClassCount > maxAncestorClasscount) {
                maxAncestorClasscount = ancestorClassCount;
            }
 
            for (String line : readClass.getLines()) {
                System.out.println(line + "-----------------> " + (ancestorClassCount + 1));
                sum +=  (ancestorClassCount + 1);
            }
            System.out.print("\n\n");
        } // end of for loop readclass
        
        
        // get the total lines in the program
        System.out.println("------------------------------------");
        System.out.println("Total Lines in the program : " + lines);
        System.out.println("-------------------------------------");
        
        //formula
        System.out.println(
                "\n\nComplexity of a class due its inheritance(CCi) = Number of ancestor classes of the class+1");
        System.out.println("CCi = " + (maxAncestorClasscount + 1));
 
       // System.out.println("\n========================================================================");
        
        //finally
        System.out.println("\n__________________________________");
        System.out.println("Total sum of Inheritance is : " + sum );
        System.out.println("___________________________________");
		return ("Total sum of Inheritance is : " + sum );
   
 
    }
		
    
    
    
    
    
    
    
    //
    public static void main(String args[]) throws IOException {
 
  
    }
 
}
 

