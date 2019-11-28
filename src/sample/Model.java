package sample;

public class Model {

    public float calculate(float number1, float number2, String operator) {
        switch(operator) {
            case "+": return number1 + number2;
            case "-": return number1 - number2;
            case "*": return number1 * number2;
            case "/": if (number2 == 0)
                return 0;
            return number1 / number2;
        }

        System.out.println("Unknown operator - " + operator);
        return 0;
    }
    public int countCharOccurences (String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
