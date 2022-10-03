package StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isBalanced = true;
        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();

        for (char parenthesis:input.toCharArray()) {
            if (parenthesis == '(' || parenthesis == '{' || parenthesis == '[') {
                openingBrackets.push(parenthesis);
            } else {

                if (openingBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                if (parenthesis == ')' && openingBrackets.pop() != '(') {
                    isBalanced = false;
                    break;
                }
                if (parenthesis == '}' && openingBrackets.pop() != '{') {
                    isBalanced = false;
                    break;
                }
                if (parenthesis == ']' && openingBrackets.pop() != '[') {
                    isBalanced = false;
                    break;
                }
            }

        }

        if (isBalanced && openingBrackets.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
