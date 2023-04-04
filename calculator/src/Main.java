import java.security.PublicKey;
import java.util.Scanner;

public class Main {

     public static void main (String[] arg) throws Exception {
         Scanner in = new Scanner(System.in);
         System.out.println("Введите выражение используя числа от 1 до 10");
         String expression = in.nextLine();
         System.out.println(base(expression));
     }
        public static String base(String expression) throws Exception {
            int num1;
            int num2;
            String oper;
            String result;
            String[] numbers = expression.split("[+\\-*/]");
            if (numbers.length != 2) throw new Exception("Должно быть не больше и не меньше двух чисел");
            oper = defectSign(expression);
            if (oper == null) throw new Exception("Недоступная операция");
            boolean roman;
            if (Rom.roman(numbers[0]) && Rom.roman(numbers[1])) {
                num1 = Rom.Arabian(numbers[0]);
                num2 = Rom.Arabian(numbers[1]);
                roman = true;

            }
            else if (!Rom.roman(numbers[0]) && !Rom.roman(numbers[1])) {
                num1 = Integer.parseInt(numbers[0]);
                num2 = Integer.parseInt(numbers[1]);
                roman = false;

            } else {
                throw new Exception("Числа должны быть в одной системе исчисления");
            }
            if (num1>10||num2>10||num1<1||num2<1) {
                throw new Exception("Можно использовать числа только от 1 до 10 или от I до X");
            }


            int arabian = calc(num1, num2, oper);
            if (roman) {
                if (arabian<=0) {
                    throw new Exception("Число должно быть больше нуля");
                }
                  result = Rom.Roman(arabian);
            }
               else {
                   result = String.valueOf(arabian);
            }
               return result;
        }
            static int calc ( int a, int b, String oper){
                if (oper.equals("+")) return a + b;
                else if (oper.equals("-")) return a - b;
                else if (oper.equals("/")) return a / b;
                else if (oper.equals("*")) return a * b;
                else return a;
            }
            static String defectSign (String expression){
                if (expression.contains("+")) return "+";
                else if (expression.contains("-")) return "-";
                else if (expression.contains("/")) return "/";
                else if (expression.contains("*")) return "*";
                return expression;
            }


            class Rom {
                static String[] romArray = new String[]{"n", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI",
                        "XVII", "XVIII", "XIV", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII",
                        "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII",
                        "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                        "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                        "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

                public static boolean roman(String num) {
                    for (int i = 0; i < romArray.length; i++) {
                        if (num.equals(romArray[i])) {
                            return true;
                        }
                    }

                    return false;
                }

                public static int Arabian(String rom) {
                    for (int i = 0; i < romArray.length; i++) {
                        if (rom.equals(romArray[i])) {
                            return i;
                        }
                    }
                    return -1;
                }
                public static String Roman (int arabian){
                    return romArray[arabian];
                }

            }
     }
