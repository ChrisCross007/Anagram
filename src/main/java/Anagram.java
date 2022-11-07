import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public boolean isAnagram(String a, String b){

        boolean isEmptyString = a.length() <1 || b.length() < 1;
        boolean isNotSameLength = a.length() != b.length();
        boolean isLengthOverFifty = a.length() >= 50 || b.length() >= 50;

        if(isEmptyString || isNotSameLength || isLengthOverFifty){
            return false;
        }
        if(!isEnglishLetters(a) || !isEnglishLetters(b)){
            return false;
        }

        return generateFrequencyMap(a).equals(generateFrequencyMap(b));
    }

    public Map<Character, Integer> generateFrequencyMap(String a) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {

            Character charLowerCase = Character.toLowerCase((a.charAt(i)));
            if(frequencyMap.containsKey(a.charAt(i))){
                frequencyMap.put(charLowerCase, frequencyMap.get(a.charAt(i)) +1);
            } else {
                frequencyMap.put(charLowerCase, 1);
            }
        }
        return frequencyMap;
    }

    public boolean isEnglishLetters(String input) {
        return input.matches("[a-zA-Z]+");
    }


}
