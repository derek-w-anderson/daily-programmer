import java.util.ArrayList;
import java.util.List;

/**
 * Challenge #79 (Easy) - http://www.reddit.com/r/dailyprogrammer/comments/wvc21/7182012_challenge_79_easy_counting_in_steps/
 */
public class StepCounter
{
    public static void main(String[] args) {
        System.out.println(StepCounter.stepCount(18.75, -22.00, 5)); // [18.75, 8.5625, -1.625, -11.8125, -22.0]
        System.out.println(StepCounter.stepCount(-5.75,  12.00, 5)); // [-5.75, -1.3125, 3.125, 7.5625, 12.0]
        System.out.println(StepCounter.stepCount(13.50, -20.75, 3)); // [13.5, -3.625, -20.75]
        System.out.println(StepCounter.stepCount( 9.75,   3.00, 9)); // [9.75, 8.90625, 8.0625, 7.21875, 6.375, 5.53125, 4.6875, 3.84375, 3.0]
    }

    public static List<Double> stepCount(double a, double b, int steps) {
        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < steps; i++) {
            list.add(a - ((a - b) / (steps - 1) * i));
        }
        return list;
    }
}
