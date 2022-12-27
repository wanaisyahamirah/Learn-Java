package demo;

public class BackwardHelloWorld {

    public static void main(String[] args){

		String inputString = "dlrow olleh";

		String output = reveresedInput(inputString);
		
		System.out.println("The reversed value of the " +inputString+ " is: " + output);
			
	}

    public static String reveresedInput(String input){

        String reversedInput = "";
        for (int i = input.length()-1; i>=0; i--){
			reversedInput = reversedInput + input.charAt(i);
		}

        return reversedInput;
    }

}
