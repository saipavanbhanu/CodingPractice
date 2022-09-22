package javaExamples.regex.problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Paypal online assessment question - validate ipv4 or ipv6 or neither */

public class ValidateIpAddress {
	
	public static boolean isValidIpV4(String ip) {
		
		String ipV4patternStr = "(\\d{1,3}\\.){3}(\\d){1,3}";
		Pattern ipV4DotPattern = Pattern.compile(ipV4patternStr);
		Matcher mDotPattern = ipV4DotPattern.matcher(ip);
		
		String ipV4GroupStr = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
		Pattern groupValidPattern = Pattern.compile(ipV4GroupStr);
		Matcher m = groupValidPattern.matcher(ip);
		if( mDotPattern.matches() && m.matches()) {
			//System.out.println("Groups: "+m.group(0)+" "+m.group(1)+" "+m.group(2)+" "+m.group(3)+" "+m.group(4));
			boolean valid = true;
			for(int i = 1; i < 5; i++) {
				String value = m.group(i);
				Integer intValue = Integer.parseInt(value);
				if(intValue >= 0 && intValue <= 255) {
					valid = true;
				}else {
					valid = false;
					break;
				}
			}
			if(valid) {
				return true;
			}else
				return false;
			
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		String arr[] = {"10.62.100.155","256.62.100.100", "192.168.10.11", "192.168.10.11.",".192.168.10.11","192.168.10.11.12"};
		for(String in : arr) {
			System.out.println(in+" - "+isValidIpV4(in));
		}
		
	}

}
