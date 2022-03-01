import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Search {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Input
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your letters: ");
		String letters = input.nextLine().toLowerCase();
		
		//referring through word list
		Map<Character, Integer> lettersMap = caller(letters);
		BufferedReader file = new BufferedReader(new FileReader("Insert path to your word list"));
	
		//looking to see if we can make those words
		for(String words = file.readLine(); words != null; words = file.readLine()) {
			boolean test = true;
			Map<Character, Integer> lettersMap1 = caller(words);
			for(Character character : lettersMap1.keySet()) {
				int currentWordCharCount = lettersMap1.get(character);
				int lettersCharCount = lettersMap.containsKey(character) ?
						lettersMap.get(character) : 0;
				if(currentWordCharCount > lettersCharCount) {
					test = false;
					break;
				}	
			}
			if(test) {
				System.out.println(words);	
			}		
		}
	}
		private static Map<Character, Integer> caller(String letters) {
			Map<Character, Integer> lettersMap = new HashMap<>();
			
			for(int i = 0; i < letters.length(); i++) {
				char Char = letters.charAt(i);
				int counter = lettersMap.containsKey(Char) ?
						lettersMap.get(Char) : 0;
				lettersMap.put(Char, counter + 1);			
			}
			return lettersMap;
		}
	} 