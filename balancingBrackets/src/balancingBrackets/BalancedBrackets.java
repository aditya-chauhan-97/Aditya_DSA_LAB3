package balancingBrackets;

import java.util.*;

public class BalancedBrackets {
 
    static boolean isStringBalanced(String input)
    {
        Deque<Character> stack
            = new ArrayDeque<Character>();
 
        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);
 
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }
 
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        return (stack.isEmpty());
    }
 
    public static void main(String[] args)
    {
        String input;
        try (Scanner sc = new Scanner(System.in)) {
			input = sc.next();
		}
        if (isStringBalanced(input))
            System.out.println("The entered String has Balanced Brackets");
        else
            System.out.println("The entered Strings do not contain Balanced Brackets");
    }
}
