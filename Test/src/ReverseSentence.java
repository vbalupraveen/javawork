public class ReverseSentence {
	public static void main(String[] args) {
		StringBuilder output = new StringBuilder();
		String input=args[0];
		String[] splitArray = input.split(" ");
		for (int i = (splitArray.length - 1); i >= 0; i--) {
			output.append(splitArray[i] + " ");
		}
		output.insert(0,"\"").insert(output.length()-1,"\"");
		System.out.println(output);
	}
}
