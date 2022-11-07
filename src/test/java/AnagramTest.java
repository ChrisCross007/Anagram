import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {
    Anagram anagram;

    @BeforeEach
    void setUp() {
        anagram = new Anagram();
    }



    @Test
    void should_ReturnThree_InputAnagram() {
        String input = "anagram";

        Map<Character,Integer> outputMap = anagram.generateFrequencyMap(input);
        assertEquals(3 , outputMap.get('a'));
    }

    @Test
    void should_ReturnTwo_InputHello() {
        String input = "Hello";
        Map<Character,Integer> outputMap = anagram.generateFrequencyMap(input);
        assertEquals(2 , outputMap.get('l'));

    }

    @Test
    void should_ReturnFalse_EmptyString() {
        String inputA = "";
        String inputB = "";
        boolean output = anagram.isAnagram(inputA,inputB);
        assertFalse(output);
    }

    @Test
    void should_ReturnFalse_UnEqualStringLength(){
        String inputA = "hall";
        String inputB = "hal";

        boolean output = anagram.isAnagram(inputA,inputB);
        assertFalse(output);
    }

    @Test
    void should_ReturnFalse_LengthOverFiftyInputA(){
        String inputA = "ajdlkjsdlkjadskljdsaljkldsajkjdaskjadsdaskjsdajkdsakjlsadjkdsakjlsdajksad";
        String inputB = "hal";

        boolean output = anagram.isAnagram(inputA,inputB);
        assertFalse(output);
    }

    @Test
    void should_ReturnFalse_LengthOverFiftyInputB(){
        String inputA = "adsa";
        String inputB = "ajdlkjsdlkjadskljdsaljkldsajkjdaskjadsdaskjsdajkdsakjlsadjkdsakjlsdajksad";

        boolean output = anagram.isAnagram(inputA,inputB);
        assertFalse(output);
    }



    @Test
    void should_ReturnTrue_IfAnagram() {
        String inputA = "anagram";
        String inputB = "margana";
        boolean output = anagram.isAnagram(inputA,inputB);
        assertTrue(output);
    }



    @Test
    void should_ReturnFalse_NotAnagram() {
        String inputA = "anagramm";
        String inputB = "marganaa";
        boolean output = anagram.isAnagram(inputA,inputB);
        assertFalse(output);
    }


    @Test
    void should_ReturnTrue_IfUppercaseLetter() {
        String inputA = "Hello";
        String inputB = "heLlo";
        boolean output = anagram.isAnagram(inputA,inputB);
        assertTrue(output);
    }

    @Test
    void should_ReturnFalse_NoneEnglishLetter(){
        String inputA = "7";
        boolean output = anagram.isEnglishLetters(inputA);
        assertFalse(output);
    }

    @Test
    void should_ReturnFalse_NorwigianLetter(){
        String inputA = "æå";
        boolean output = anagram.isEnglishLetters(inputA);
        assertFalse(output);
    }

    @Test
    void should_ReturnTrue_EnglishLetter(){
        String inputA = "adajas";
        boolean output = anagram.isEnglishLetters(inputA);
        assertTrue(output);
    }

    @Test
    void should_ReturnFalse_nonEnglishAlphabeticNumber() {
        String inputA = "Hell7o";
        String inputB = "HeLl7o";
        boolean output = anagram.isAnagram(inputA,inputB);
        assertFalse(output);
    }


}