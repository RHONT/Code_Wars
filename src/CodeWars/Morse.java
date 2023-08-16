package CodeWars;

import java.text.Normalizer;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Morse {
    static int incrForDictionary = 0;

    static final Character[] english = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            ',', '.', '?', '!'};

    static final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----",
            "--..--", ".-.-.-", "..--..", "−−··−−"};

    static Map<String, Character> dictionary = Arrays.stream(morse).collect(Collectors.toMap(Function.identity(), (a) -> english[incrForDictionary++]));

    public static void main(String[] args) {

        System.out.println(dictionary);

        System.out.println(decode("···---··· −−··−−   - .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .---. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-"));

        System.out.println(decode(".... . -.--   .--- ..- -.. ."));

        System.out.println(decode("···−−−··· −−··−− "));

        System.out.println(code("SOS! THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG."));


    }

    public static String decode(String morseCode) {


        Function<String, String[]> makeArray = Morse::makeArray;
        Function<String[], String> deleteSpace = Morse::deleteSpaceAndDecode;
        Function<String, String> composeFunc = makeArray.andThen(deleteSpace);

        return composeFunc.apply(morseCode);
    }


    public static String code(String message) {
        incrForDictionary = 0;

        Map<Character, String> dictionary = Arrays.stream(english).collect(Collectors.toMap(Function.identity(), (a) -> morse[incrForDictionary++]));

        Function<String, String> funToCode = input -> {
            StringBuilder result = new StringBuilder();
            char[] ch = input.toCharArray();
            for (var temp : ch) {
                result.append(dictionary.get(temp)).append(" ");
            }

            return String.valueOf(result).trim();
        };

        String[] first = Arrays.stream(message.toLowerCase().split(" ")).map(funToCode).toArray(String[]::new);

        incrForDictionary = 0;

        return String.join("   ", first);

    }

    public static String[] makeArray(String input) {
        System.out.println(Normalizer.isNormalized(input, Normalizer.Form.NFKD));

        input = Normalizer.normalize(input, Normalizer.Form.NFKD);
        return input.trim().split("   ");
    }

    public static String deleteSpaceAndDecode(String[] input) {
        String[] result = new String[input.length];
        StringBuilder tempWord = new StringBuilder();

        for (int j = 0; j < input.length; j++) {
            String[] simbols = input[j].split(" ");
            for (var simbol : simbols) {
                if (Objects.equals(simbol, "Â·")) {
                    tempWord.append("SOS");
                } else
                    tempWord.append(dictionary.get(simbol));
            }
            result[j] = tempWord.toString();
            tempWord = new StringBuilder();
        }
        return String.join(" ", result).toUpperCase();

    }


}
