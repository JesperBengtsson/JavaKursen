import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = "";

        while(true) {

            System.out.println("Choose operator (+,-,*,/):");
            try {
                command = br.readLine();
                if (! command.equals("+") && ! command.equals("-") && ! command.equals("*") && ! command.equals("/")){
                    throw new NumberFormatException();
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Only (+,-,*,/) is allowed");
                continue;
            }
            if (command.equals("+") || command.equals("-")){

                ArrayList<Double> numbers = new ArrayList<>();

                double result = 0;
                String nr = "0";
                while (!nr.equals("")){
                    System.out.println("Choose values to calculate, when you're done press Enter: ");
                    nr = br.readLine();
                    double nrToWorkwith = 0;
                    try{
                        nrToWorkwith = Double.parseDouble(nr);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("only numbers allowed");
                        continue;
                    }
                    numbers.add(nrToWorkwith);
                }
                if (command.equals("+")) {
                    result = 0;
                    for (Double db : numbers) {

                        result = result + db.doubleValue();
                    }
                    System.out.println("Result:" + result);
                }
                if (command.equals("-")) {
                    result = numbers.get(0) + numbers.get(0);
                    for (Double aDb : numbers) {

                        result = result - aDb.doubleValue();
                    }
                    System.out.println("Result:" + result);
                }
            }


            if (command.equals("*") || command.equals("/")){

                double n1 = 0;
                double n2 = 0;

                System.out.println("Choose number 1:");

                try {
                    n1 = Double.parseDouble(br.readLine());
                }
                catch (NumberFormatException e) {
                    System.out.println("Only numbers allowed");
                    continue;
                }
                System.out.println("Choose number 2:");
                try {
                    n2 = Double.parseDouble(br.readLine());
                }
                catch (NumberFormatException e) {
                    System.out.println("Only numbers allowed");
                    continue;
                }
                try {
                    System.out.println("Result:" + Double.toString(calculate(n1, n2, command)));
                }
                catch (ArithmeticException e) {
                    System.out.println("Can't divide by 0");
                    continue;
                }
            }
        }
    }

    public static double calculate(double n1, double n2, String command) {

        double result = 0;

        if (command.equals("*")) {
            result = n1 * n2;
            return result;
        }
        if (command.equals("/")) {
            result = n1 / n2;
            return result;
        }
        return result;
    }

}