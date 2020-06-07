import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(new File("input.txt"));
        Scanner in = new Scanner(System.in);
        TreeMap<Integer, String> numerals = new TreeMap<>();
        TreeMap<String, Integer> reverse = new TreeMap<>();
        numerals.put(1000, "M");
        numerals.put(900, "CM");
        numerals.put(500, "D");
        numerals.put(400, "CD");
        numerals.put(100, "C");
        numerals.put(90, "XC");
        numerals.put(50, "L");
        numerals.put(40, "XL");
        numerals.put(10, "X");
        numerals.put(9, "IX");
        numerals.put(5, "V");
        numerals.put(4, "IV");
        numerals.put(1, "I");
        int numCase = in.nextInt();
        while (numCase-- > 0) {
            System.out.println(translate(in.next(),reverse));
        }
        for (int i : numerals.keySet()){
            reverse.put(numerals.get(i), i);
        }

        //int numCase = in.nextInt(); in.nextLine();
        while (numCase-- > 0){
            String input = in.nextLine();
            System.out.println(translate(input, reverse));
        }
    }

    public static int translate(String input, TreeMap<String, Integer> keys){
        int result = 0;
        int temp = 0;
        for (int i = input.length()-1; i > 0; i--){
            if (keys.containsKey(input.substring(i-1, i+1))){
                result += keys.get(input.substring(i-1, i+1));
                i--;
            } else {
                result += keys.get(input.substring(i, i+1));
            }
            temp = i;
        }

        if (temp != 0){
            result += keys.get(input.substring(0,1));
        }
        return result;
    }

    public static String translate(int input, TreeMap<Integer, String> keys){
        int last = keys.floorKey(input);
        if (input == last){
            return keys.get(last);
        } else {
            return keys.get(last) + translate(input-last, keys);
        }
    }
}