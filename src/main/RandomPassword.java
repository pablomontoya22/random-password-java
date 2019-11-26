package main;

import java.util.Random;

public class RandomPassword {

	public static void main(String[] args) {
		for (String type : new String[] {"NUMERIC", "UPPER_LETTERS",
				"LOWER_LETTERS", "UPPER_ALFANUMERIC", "LOWER_ALFANUMERIC",
				"ALFANUMERIC", "Default"})
			System.out.println(String.format("\n\t%s: %s", type, getRandomPassword(10, type)));
	}

	public static String getRandomPassword(int length, String type) {
	    int leftUpper = 65; 	// letter 'A'
	    int rightUpper = 90; 	// letter 'Z'
	    int leftNumb = 48; 		// letter '0'
	    int rightNumb = 57; 	// letter '9'
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(length);
	    for (int i = 0; i < length; i++) {
	    	int randomLimitedInt;
	    	switch (type) {
				case "NUMERIC":
					randomLimitedInt = leftNumb  + (int) (random.nextFloat() * (rightNumb -  leftNumb  + 1));
					break;
				case "UPPER_LETTERS":
					randomLimitedInt = leftUpper + (int) (random.nextFloat() * (rightUpper - leftUpper + 1));
					break;
				case "LOWER_LETTERS":
					randomLimitedInt = leftUpper + (int) (random.nextFloat() * (rightUpper - leftUpper + 1)) + 32;
					break;
				case "UPPER_ALFANUMERIC":
					randomLimitedInt = random.nextInt() % 2 == 0
		        		? leftUpper + (int) (random.nextFloat() * (rightUpper - leftUpper + 1))
		        		: leftNumb  + (int) (random.nextFloat() * (rightNumb -  leftNumb  + 1));
					break;
				case "LOWER_ALFANUMERIC":
					randomLimitedInt = random.nextInt() % 2 == 0
		        		? leftUpper + (int) (random.nextFloat() * (rightUpper - leftUpper + 1)) + 32
		        		: leftNumb  + (int) (random.nextFloat() * (rightNumb -  leftNumb  + 1));
					break;
				case "ALFANUMERIC":
				default:
					randomLimitedInt = random.nextInt() % 2 == 0
		        		? leftUpper + (int) (random.nextFloat() * (rightUpper - leftUpper + 1)) + (random.nextInt() % 2 == 0 ? 32 : 0)
		        		: leftNumb  + (int) (random.nextFloat() * (rightNumb -  leftNumb  + 1));
			}
	        buffer.append((char) randomLimitedInt);
	    }
	    return buffer.toString();
	}
}
