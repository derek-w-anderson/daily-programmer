import java.util.Stack;

/**
 * Challenge #73 (Easy) - http://www.reddit.com/r/dailyprogrammer/comments/w4l6e/762012_challenge_73_easy/
 */
public class RPNCalculator
{
    public static void solve(String input) {
        java.util.Stack<Integer> ops = new java.util.Stack<Integer>();
        for (String x : input.split(" ")) {
            if (x.matches("[-]?[0-9]+")) {
                ops.push(Integer.parseInt(x));
            } else {
                int b = ops.pop(), a = ops.pop();
                if ("+".equals(x)) ops.push(a + b);
                if ("-".equals(x)) ops.push(a - b);
                if ("*".equals(x)) ops.push(a * b);
            }
        }
        System.out.println(ops.pop());
    }
    
    public static void main(String[] args) {
        RPNCalculator.solve("3 4 * 6 2 - +");
    }
}
