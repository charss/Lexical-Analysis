import java.util.*;  
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.*;  

public class lexical {
    public static void main(String[] args) {
        String[] keywords = new String[]{"auto","break","case","char","const","continue","default",
                             "do","double","else","enum","extern","float","for","goto",
                             "if","int","long","register","return","short","signed",
                             "sizeof","static","struct","switch","typedef","union",
                             "unsigned","void","volatile","while", "main"};
        List<String> keywordList = new ArrayList<>(Arrays.asList(keywords));
        String[] operators = new String[]{"+", "-", "*", "/", "%", "=", ">"};
        List<String> operatorsList = new ArrayList<>(Arrays.asList(operators));

        try {
            // Creating an object of the file for reading the data
            File myObj = new File("program.txt");  
            Scanner scan = new Scanner(myObj);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                String words[] = data.split("\\s");  
                for (String word:words) {
                    word = word.replaceAll("[\\(\\)\\{\\}\\[\\],;]", "");
                    
                    if (!word.equals("")) {
                        if (keywordList.contains(word)) {
                            System.out.println(word + " is keyword");
                        } else if (operatorsList.contains(word)) {
                            System.out.println(word + " is operator");
                        } else if (Pattern.matches("\\d+", word)) {
                            System.out.println(word + " is Integer constant");
                        } else if (Pattern.matches("\".*?\"", word)) {
                            System.out.println(word + " is String constant");
                        } else {
                            System.out.println(word + " is identifier");
                        }
                    
                    }
                    
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}