import java.util.*;

/**
 * Challenge #82 (Difficult) - http://www.reddit.com/r/dailyprogrammer/comments/x8r90/7272012_challenge_82_difficult_bowling_scores/
 */
public class BowlingScorer
{
	private class Frame { int score; String mark; }

	public void printFrames(String input) {
		String[] rolls = input.split(" ");
		Map<Integer, Frame> frames = new LinkedHashMap<Integer, Frame>();

		int totalScore = 0;
		for (int frame = 1, x = 0; frame <= 10; frame++) {
			Frame f = new Frame();
			int r1 = Integer.parseInt(rolls[x++]);
			int r2 = Integer.parseInt(rolls[x]);

			if (r1 == 10) {
				f.mark = "X";
				f.score = totalScore + 10 + r2 + Integer.parseInt(rolls[x+1]);
			} else if (r1 + r2 == 10) {
				f.mark = r1 + " /";
				f.score = totalScore + 10 + Integer.parseInt(rolls[++x]);
			} else {
				f.mark = r1 + " " + r2;
				f.score = totalScore + r1 + r2;
				x++;
			}
			if (frame == 10 && (r1 + r2 >= 10)) {
				int r3 = Integer.parseInt(rolls[x]);

				if (r2 + r3 == 20) f.mark += " X X";
				else if (r3 == 10) f.mark += " X";
				else f.mark += (r2 + r3 == 10) ? " /" : " " + r3;
			}
			totalScore = f.score;
			frames.put(frame, f);
		}
		for (Map.Entry<Integer, Frame> entry : frames.entrySet()) {
			System.out.printf("%2s: %5s (%d)\n",
				entry.getKey(),
				entry.getValue().mark,
				entry.getValue().score
			);
		}
	}

	public static void main(String[] args) {
		new BowlingScorer().printFrames("10 7 3 7 2 9 1 10 10 10 2 3 6 4 7 3 3");
		new BowlingScorer().printFrames("10 10 10 10 10 10 10 10 10 10 10 10");
		new BowlingScorer().printFrames("10 9 1 8 1 7 3 5 2 8 1 4 6 8 2 10 9 1 3");
		new BowlingScorer().printFrames("10 10 10 0 8 10 10 0 0 7 0 6 2 9 0");
	}
}
