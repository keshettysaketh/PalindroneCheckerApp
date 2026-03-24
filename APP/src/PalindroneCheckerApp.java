import java.util.*;

public class PalindroneCheckerApp {

    public static boolean stackMethod(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dequeMethod(String input) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static boolean twoPointerMethod(String input) {
        int left = 0, right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        long start, end;

        start = System.nanoTime();
        boolean result1 = stackMethod(input);
        end = System.nanoTime();
        long stackTime = end - start;

        start = System.nanoTime();
        boolean result2 = dequeMethod(input);
        end = System.nanoTime();
        long dequeTime = end - start;

        start = System.nanoTime();
        boolean result3 = twoPointerMethod(input);
        end = System.nanoTime();
        long twoPointerTime = end - start;

        System.out.println("Stack Result: " + result1 + " Time: " + stackTime + " ns");
        System.out.println("Deque Result: " + result2 + " Time: " + dequeTime + " ns");
        System.out.println("Two Pointer Result: " + result3 + " Time: " + twoPointerTime + " ns");

        sc.close();
    }
}