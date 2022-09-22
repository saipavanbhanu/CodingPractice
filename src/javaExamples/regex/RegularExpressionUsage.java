package javaExamples.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* character - John - matches the entire characters
 * character class - [John] - matches any one character in the brackets
 * Predefined Character Classes - \d - represent digit
 * Boundary Matchers - ^ or $ - start of the line or end of the line
 * Quantifiers - * => zero or more; + => one or more
 * Reference: https://jenkov.com/tutorials/java-regex/syntax.html
 * */

public class RegularExpressionUsage {

	public static void main(String[] args) {
		/* using the static method to check whether a string matches the given regex */
		String text = "This is the text to be searched " + "for occurrences of the pattern.";
		boolean matches = Pattern.matches(".*is.*", text);
		System.out.println("Pattern matches: " + matches);

		/*
		 * using the pattern object and matcher object to check whether a string matches
		 * a given regex
		 */
		String patternString = "http://.*";
		Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
		text = "http://www.google.com";
		Matcher matcher = pattern.matcher(text);
		matches = matcher.matches();
		System.out.println("matches = " + matches);

		/* printing all the matched strings with regex */
		System.out.println("Printing all the matched regex in the string ");
		text = "This is the text which is to be searched for occurrences of the word 'is'.";
		patternString = "is";
		pattern = Pattern.compile(patternString);
		matcher = pattern.matcher(text);
		int count = 0;
		while (matcher.find()) {
			count++;
			System.out.println("found: " + count + " : " + matcher.start() + " - " + matcher.end());
		}

		System.out.println("Groups in regex");
		text = "John writes about this, and John writes about that," + " and John writes about everything. ";
		String patternString1 = "(Jo)(hn)";
		pattern = Pattern.compile(patternString1);
		matcher = pattern.matcher(text);
		while (matcher.find()) {
			System.out.println("found: " + "group1 - " + matcher.group(1) + "; group0 - " + matcher.group(0));
		}

	}
}
