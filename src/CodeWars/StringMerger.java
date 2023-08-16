package CodeWars;

import java.util.HashMap;
import java.util.Map;

public class StringMerger {
    public static void main(String[] args) {
        String input = "Can we merge it? Yes, we can!";
        String part1 = "Can werg? Y we!";
        String part2 = "e me ites, can";

        System.out.println(isMerge(input, part1, part2));
    }

    public static boolean isMerge(String s, String part1, String part2) {
//        String inputString = s.replaceAll(" ", "");
        StringBuilder accumParts = new StringBuilder(part1 + part2);

        if (s.length() != accumParts.length()) {
            return false;
        }

        Map<Integer, Character> bankChar = fillBankChar(s);

        return checkMap(bankChar, part1.toCharArray(), part2.toCharArray());
    }

    private static boolean checkMap(Map<Integer, Character> bankChar, char[]... parts) {
        int counter = 0;
        Map<Integer, Character> copyBankChar = new HashMap<>(bankChar);

        for (var part : parts) {

            for (var element : bankChar.entrySet()) {

                if (part[counter] == element.getValue()) {
                    copyBankChar.remove(element.getKey());
                    counter++;
                    if (counter > part.length - 1) {
                        break;
                    }
                }
            }
            if (counter < part.length) {
                return false;
            }
            System.out.println(counter);
            counter = 0;
            bankChar.clear();
            bankChar.putAll(copyBankChar);
        }

        return true;
    }

    private static Map<Integer, Character> fillBankChar(String inputString) {
        Map<Integer, Character> bankChar = new HashMap<>();
        int incr = 0;

        for (int i = 0; i < inputString.length(); i++) {
            bankChar.put(incr++, inputString.charAt(i));
        }

        return bankChar;
    }


}
