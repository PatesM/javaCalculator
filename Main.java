import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

  static Scanner userInput = new Scanner(System.in);
  static int[] allowedValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

  public static String calc(String input) {

    /*
    Description of the calculator
     */
    System.out.println("""
        ----------------------------------\s
        Console application 'Calculator'\s
        ----------------------------------""");
    System.out.println("""
        Basic calculator rules: \s
        1. The calculator performs the following operations: \s
          1.1 Addition (+); \s
          1.2 Subtraction (-); \s
          1.3 Multiplication (*); \s
          1.4 Division (/). \s
        2. The calculator accepts only: \s
          2.1 Arabic numbers from 1 to 10 inclusive; \s
          2.2 Numbers must be integers. \n""");
    System.out.println("Enter expression:");

    /*
    Adding spaces to an expression if they are missing
     */
    input = userInput.nextLine().replaceAll("[-+*/]", " $0 ").replace("  ", " ").trim();
    String[] elements = input.split(" ");

    double a = Double.parseDouble(elements[0]);
    double b = Double.parseDouble(elements[2]);
    char operation = elements[1].charAt(0);

    /*
    Checking the valid value of a variable 'a'
     */
    boolean allowableA = Arrays.stream(allowedValues)
        .boxed()
        .collect(Collectors.toSet())
        .contains((int) a);

    /*
    Checking the valid value of a variable 'b'
     */
    boolean allowableB = Arrays.stream(allowedValues)
        .boxed()
        .collect(Collectors.toSet())
        .contains((int) b);

    if (a < 1 | a > 10 | b < 1 | b > 10) {
      throw new ArithmeticException("Please enter a valid value");
    }

    if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
      throw new ArithmeticException("Please enter a valid operation");
    }

    /*
    Result calculation
     */
    if (allowableA & allowableB) {
        switch (elements[1]) {
            case "+" -> {
                int result = (int) a + (int) b;
                return Integer.toString(result);
            }
            case "-" -> {
                int result = (int) a - (int) b;
                return Integer.toString(result);
            }
            case "*" -> {
                int result = (int) a * (int) b;
                return Integer.toString(result);
            }
            case "/" -> {
                int result = (int) a / (int) b;
                return Integer.toString(result);
            }
        }
    }
    return "Something went wrong";
  }

  public static void main(String[] args) {
    System.out.println(calc(userInput.toString()));
  }
}