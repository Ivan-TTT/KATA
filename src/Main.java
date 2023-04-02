import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calc("");
    }
    public static void calc(String input) {
        Scanner in = new Scanner(System.in);
        System.out.print("Напишите пример: "); input = in.nextLine();
        in.close();

        String [] arguments = input.trim().split(" ");
        String [] rimNum = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX"};

        if (arguments.length >3){
            try {
                throw new Exception();
            }catch (Exception e){
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            return;
        }

        try {
            int x = Integer.parseInt(arguments[0]);
            int y = Integer.parseInt(arguments[2]);

            if(x<=10 && y<=10 && x != 0 && y !=0){
                if(Objects.equals(arguments[1], "+")){
                    System.out.println(x + y);

                } else if(arguments[1].equals("-")){
                    System.out.println(x - y);

                } else if(arguments[1].equals("*")){
                    System.out.println(x * y);

                } else if(arguments[1].equals("/")){
                    System.out.println(x / y);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("т.к. строка не является математической операцией");
        }
        catch (NumberFormatException nfe){
            int a = 0;
            int b = 0;

            for (int i = 0; i<rimNum.length; i++){
                if (arguments[0].equals(rimNum[i])) {
                    a = i + 1;
                }
                if (arguments[2].equals(rimNum[i])) {
                    b = i + 1;
                }
            }
            if ((a == 0) || (b == 0)){
                try {
                    throw new Exception();
                }catch (Exception e){
                    System.out.println("т.к. используются одновременно разные системы счисления");
                }
            }
            if((a <= 10) && (b <= 10) && (a != 0) && (b != 0)){
                try {
                    if(arguments[1].equals("+")){
                        System.out.println(rimNum[(a + b)-1]);

                    } else if(arguments[1].equals("-")){
                        System.out.println(rimNum[(a - b)-1]);

                    } else if(arguments[1].equals("*")){
                        System.out.println(rimNum[(a * b)-1]);

                    } else if(arguments[1].equals("/")){
                        System.out.println(rimNum[(a / b)-1]);

                    }
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("т.к. в римской системе нет отрицательных чисел");
                }
            }
        }
    }
}
