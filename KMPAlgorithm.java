//Riddhi Gupta _SE CMPN B1_05
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KMPAlgorithm {
    public static void main(String[] args) {
   	 Scanner scanner = new Scanner(System.in);
   	 System.out.print("Enter the text: ");
   	 String t = scanner.nextLine();
   	 System.out.print("Enter the pattern: ");
   	 String p = scanner.nextLine();

   	 int[] prefixTable = createPrefixTable(p);

   	 System.out.println("Prefix Table:");
   	 for (int i = 0; i < prefixTable.length; i++) {
   		 System.out.print(prefixTable[i] + " ");   	 System.out.println();

   	 int[] matches = findMatches(t, p, prefixTable);
   	 System.out.println("Positions where pattern is found:");
   	 }

   	 for (int i = 0; i < matches.length; i++) {
   		 System.out.print(matches[i] + " ");
   	 }
   	 System.out.println();
    }
// Creates the prefix table
	private static int[] createPrefixTable(String pattern) {
  	  int[] prefixTable = new int[pattern.length()];
  	  int i = 0;
  	  for (int j = 1; j < pattern.length(); j++) {
  		  while (i > 0 && pattern.charAt(i) != pattern.charAt(j)) {
  			  i = prefixTable[i-1];
  		  }
  		  if (pattern.charAt(i) == pattern.charAt(j)) {
  			  i++;
  		  }
  		  prefixTable[j] = i;
  	  }
  	  return prefixTable;
	}
   	 private static int[] findMatches(String text, String pattern, int[] prefixTable) {
   	 int[] matches = new int[text.length()]; // matches[i] will be 1 if pattern is found starting at i, 0 otherwise
   	 int i = 0;
   	 for (int j = 0; j < text.length(); j++) {
   		 while (i > 0 && text.charAt(j) != pattern.charAt(i)) {
       		 i = prefixTable[i-1];
   		 }
   		 if (text.charAt(j) == pattern.charAt(i)) {
       		 i+=1;
   		 }
   		 if (i == pattern.length()) { // pattern found
       		 matches[j - pattern.length() + 2] = 1;
       		 i = prefixTable[i-1];
   		 }
   	 }

   	 List<Integer> positions = new ArrayList<Integer>();
   	 for (i = 0; i < matches.length; i++) {
   		 if (matches[i] == 1) {
       		 positions.add(i);
   		 }
   	 }

   	 int[] result = new int[positions.size()];
   	 for (i = 0; i < result.length; i++) {
   		 result[i] = positions.get(i);
   	 }
   	 return result;
    

    }
}
