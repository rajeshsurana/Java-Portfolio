import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexMatcher {
  public static void main(String[] args) {
    String regex = "(.*)(\\d+)(.*)";
    String line = "I have 3 sport cars.";

    // Compile Pattern
    Pattern p = Pattern.compile(regex);

    // Create Matcher Object
    Matcher m = p.matcher(line);
    
    // Output the match result
    if (m.find()) {
      System.out.println(m.group(0));
      System.out.println(m.group(1));
      System.out.println(m.group(2));
      System.out.println(m.group(3));
    } else {
    	System.out.println("No Match");
    }

    String regex1 = "hack";
    String line1 = "hackerrank";

    Pattern p1 = Pattern.compile(regex1);
    Matcher m1 = p1.matcher(line1);

    // lookingAt matches start of the input
    System.out.println("Matcher.lookingAt: " + m1.lookingAt());

    // matches needs complete input to be matched to be true
    System.out.println("Matcher.matches: " + m1.matches());
  }
}
