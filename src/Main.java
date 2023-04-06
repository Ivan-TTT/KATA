import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static String [] rimNumArr = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C", "CI", "CII", "CIII", "CIV", "CV", "CVI", "CVII", "CVIII", "CIX", "CX"};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Напишите пример: "); calc(in.nextLine());
        in.close();
    }
    public static void calc(String input) {
        String [] arguments = input.trim().split(" ");

        if (arguments.length >3){
            try {
                throw new Exception();
            }catch (Exception e){
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                return;
            }
        }

        try {
            int x = Integer.parseInt(arguments[0]);
            int y = Integer.parseInt(arguments[2]);
            res(x,arguments[1],y,false);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("т.к. строка не является математической операцией");
        }
        catch (NumberFormatException nfe){
            try {
                int a = 0;
                int b = 0;

                for (int i = 0; i<rimNumArr.length; i++){
                    if (arguments[0].equals(Main.rimNumArr[i])) {
                        a = i + 1;
                    }
                    if (arguments[2].equals(rimNumArr[i])) {
                        b = i + 1;
                    }
                }

                if ((a == 0) || (b == 0)){
                    try {
                        throw new Exception();
                    }catch (Exception e){
                        System.out.println("т.к. используются одновременно разные системы счисления");
                        return;
                    }
                }
                res(a,arguments[1],b, true);
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("т.к. строка не является математической операцией");
            }
        }
    }
    static void res(int x, String operator, int y, boolean rimNum){
        int otvet;

        if((x<1)||(y<1)||(x>10)||(y>10)){
            try {
                throw new Exception();
            }catch (Exception e){
                System.out.println("т.к формат ввода не удовлетворяет заданию - операнды от 1 до 10 включительно");
                return;
            }
        }

        if(Objects.equals(operator, "+")){
            otvet = x + y;
        } else if(operator.equals("-")){
            otvet = x - y;
        } else if(operator.equals("*")){
            otvet = x * y;
        } else if(operator.equals("/")){
            otvet = x / y;
        } else {
            try {
                throw new Exception();
            }catch (Exception e){
                System.out.println("т.к введен некорректный математический оператор");
                return;
            }
        }

        if (rimNum && otvet < 0) {
            try {
                throw new Exception();
            }catch (Exception e){
                    System.out.println("т.к. в римской системе нет отрицательных чисел");
            }
        } else if (rimNum) {
            System.out.println(rimNumArr[(otvet)-1]);
        } else {
            System.out.println(otvet);
        }
    }
}