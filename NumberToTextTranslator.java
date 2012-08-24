/**
 * Challenge #83 (Easy) - http://www.reddit.com/r/dailyprogrammer/comments/xdwyb/7302012_challenge_83_easy_long_scale_and_short/
 */
public class NumberToTextTranslator
{
	public String toLongScale(long n) {
		return toText(Long.toString(n), new String[] {
			"", "thousand", "million", "milliard", "billion", "billiard", "trillion", "trilliard"
		});
	}

	public String toShortScale(long n) {
		return toText(Long.toString(n), new String[] {
			"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion"
		});
	}

	private String toText(String num, String[] table) {
		StringBuilder sb = new StringBuilder();
		java.util.Stack<String> stack = new java.util.Stack<String>();
		for (int i = 3; i <= num.length(); i += 3) {
			stack.push(num.substring(num.length() - i, num.length() - i + 3));
		}
		if (num.length() % 3 != 0) {
			stack.push(num.substring(0, num.length() % 3));
		}
		int stackSize = stack.size();
		for (int i = stackSize - 1; i >= 0; i--) {
			if (i == 0 && stackSize > 1) {
				sb.replace(sb.length() - 2, sb.length(), " and ");
			}
			sb.append(stack.pop() + ((i != 0) ? " " + table[i] + ", " : ""));
		}
		return sb.toString();
	}

    public static void main(String[] args) {
        NumberToTextTranslator numToText = new NumberToTextTranslator();
        System.out.println("Short scale: " + numToText.toShortScale(1234567891111L));
        System.out.println("Long scale:  " + numToText.toLongScale(1234567891111L));
    }
}