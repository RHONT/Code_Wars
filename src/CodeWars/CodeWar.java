package CodeWars;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;


public class CodeWar {
    static String HightResult = new String();

    public static void main(String[] args) {
        long startMethod = System.nanoTime();

//        System.out.println(Arrays.toString(monkeyCount(10)));
//        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
//        System.out.println(disemvowel("FUUCK"));
//        System.out.println(sortDesc(55511122));
//        System.out.println(Arrays.deepToString(partlist(new String[]{"First","Second","Third","Fourth","Fives"})));
//        System.out.println(makeReadable(9025));
//        System.out.println(high("aa b"));

//        long finishMethod=System.nanoTime();
//        System.out.println(digital_root(999));
//        System.out.println("Метод работал:" +((finishMethod-startMethod)/100000));
        System.out.println(print(41));


    }

    public static int[] monkeyCount(final int n) {
        return IntStream.rangeClosed(1, n).toArray();
    }

    //    public static String createPhoneNumber(int[] numbers) {
//        String a = "",b="",c="";
//        for(int i=0;i<numbers.length;i++){
//            if (i<3) a=a.concat(String.valueOf(numbers[i]));
//            if (i>2 && i<6) b=b.concat(String.valueOf(numbers[i]));
//            if (i>5) c=c.concat(String.valueOf(numbers[i]));
//        }
//        return String.format("(%s) %s-%s", a, b, c);
//    }
//    // Альтернативные решения
    //Boxed тут нужен, так как приходит int а необходим для этой операции Integer
    public static String createPhoneNumber(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", Arrays.stream(numbers).boxed().toArray());
//        IntStream.of(numbers).boxed().toArray()); так тоже можно
    }

    //    public static String createPhoneNumber(int[] numbers) {
//        String phoneNumber = "(xxx) xxx-xxxx";
//
//        for (int i : numbers) {
//            phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
//        }
//
//        return phoneNumber;
//    }
    public static String disemvowel(String str) {
        // Code away...
        return str.replaceAll("[AEIOUaeiou]", "");

    }

    public static int sortDesc(final int num) {
        Function<Integer, Integer> fun = (a) -> {
            String[] strArray = String.valueOf(a).split("");
            Arrays.sort(strArray, Collections.reverseOrder());
            return Integer.valueOf(String.join("", strArray));
        };

        return fun.apply(num);

    }

    public static String[][] partlist(String[] arr) {
        //Очищаем массив от пробелов и пустых значений
        arr = Arrays.stream(arr).map((a) -> a.replaceAll("\\s", "")).filter(a -> a.length() > 0).toArray(String[]::new);
        if (arr.length == 0) {
            return new String[][]{{"Empty"}};
        }
        if
        (arr.length == 1) {
            //Возвращаем массив с одним значением, минуя дальнейшие вычисления
            return new String[][]{{arr[0]}};
        }
        int counter = 0;
        // Всегда количество вариантов будет (-1) от общего числа компонентов
        // А глубина массива всегда 2, поэтому этот вариант хардкод.
        String[][] stringsResult = new String[arr.length - 1][2];

        for (int i = 0; i < stringsResult.length; i++) {
            stringsResult[i][0] = String.join(" ", Arrays.copyOfRange(arr, 0, ++counter));
            stringsResult[i][1] = String.join(" ", Arrays.copyOfRange(arr, counter, arr.length));
        }
        return stringsResult;
    }

    public static String makeReadable(int seconds) {

        // временная переменная, она скорее для наглядности, чем для пользы
//        int temp;
//        int hours=Math.round(seconds/3600);
//        temp=hours*3600;
//        int min=Math.round((seconds-temp)/60);
//        temp=hours*3600+min*60;
//        int sec=seconds-temp;
//
//        // Функция для корректного строкового вывода числа
//        Function<Integer,String> fun=a->{
//            if (String.valueOf(a).length()<2)
//                return "0" + a;
//            return String.valueOf(a);
//        };
        // пусть мой вариант многословен, но для меня он понятен и очевиден, а то что ниже...
        // Хрень какая-то, но работает.
//        return String.format("%s:%s:%s",fun.apply(hours),fun.apply(min),fun.apply(sec))


        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
    }

    public static String high(String s) {

        HightResult = HightResult.concat(" ").concat(s);

        String[] strMas = HightResult.replaceAll("[.,!?]", "").toLowerCase(Locale.ROOT).split(" ");
        System.out.println(Arrays.toString(strMas));

        Integer inc = 1;
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, inc++);
        }

        Function<String, Integer> fun = (a) -> {
            int sumResult = 0;
            char[] chars = a.toCharArray();
            for (char c : chars) {
                if (map.containsKey(c)) sumResult += map.get(c);
            }
            return sumResult;
        };

        for (String str : strMas) {
            resultMap.putIfAbsent(str, fun.apply(str));
        }

        String key = resultMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

// Пидоры они короче.
        return key;
    }

    public static int digital_root(int n) {
        return (n != 0 && n % 9 == 0) ? 9 : n % 9;
//        if (n==0) return 0;
//
//        List<Integer> listResult=new ArrayList<>();
//        Optional<Integer> result;
//        listResult=fillArrayInts(n);
//
//        while (listResult.size()>1){
//            result=listResult.stream().reduce(Integer::sum);
//            listResult.clear();
//            listResult=fillArrayInts(result.get());
//        }
//        return listResult.get(0);

//        String s = String.valueOf(n);
//        String [] arrStr=s.split("");
//        int sum=0;
//        do {
//            for (String c:arrStr) {
//                sum+= Integer.parseInt(c);
//            }
//            s=String.valueOf(sum);
//            if (s.length()>1) {
//                arrStr=s.split("");
//                sum=0;
//            }
//        } while (sum==0);
//        return sum;


    }

    public static List<Integer> fillArrayInts(int n) {

        int bufferInt = n;
        List<Integer> listResult = new ArrayList<>();

        IntFunction<Integer> fun = a -> a % 10;

        while (bufferInt != 0) {
            listResult.add(fun.apply(bufferInt));
            bufferInt /= 10;
        }
        return listResult;
    }

    public static String print(int n) {
        if (n % 2 == 0 || n < 0) {
            return null;
        }
        int indexForSpace = n;
        StringBuilder stringBuilder = new StringBuilder();
        String diamond = "*";
        String space = " ";

        for (int i = 1; i <= n; i += 2) {
            stringBuilder.append(space.repeat(indexForSpace / 2)).append(diamond.repeat(i)).append("\n");
            indexForSpace -= 2;
        }

        indexForSpace = 3;

        for (int i = n - 2; i >= 1; i -= 2) {
            stringBuilder.append(space.repeat(indexForSpace / 2)).append(diamond.repeat(i)).append("\n");
            indexForSpace += 2;
        }

        return stringBuilder.toString();

    }

}
