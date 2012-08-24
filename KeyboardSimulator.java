/**
 * Challenge #78 (Easy) - http://www.reddit.com/r/dailyprogrammer/comments/wrqbr/7182012_challenge_78_easy_keyboard_locale/
 */
public class KeyboardSimulator
{
    public static void main(String[] args) {
        KeyboardSimulator.translate("^sm^Sy e-mail address ^s9^Sto send the ^s444^S to^s0^S is ^cfake^s2^Sgmail.com^C");
    }

    public static void translate(String input) {
        final String[] symbols = { ")", "!", "@", "#", "$", "%", "^", "&", "*", "(" };

        StringBuilder output = new StringBuilder();
        boolean shiftPressed = false, capsLockOn = false;

        String[] chars = input.split("");
        for (int i = 0; i < chars.length; i++) {
            if ("^".equals(chars[i])) {
                String modifier = chars[++i];
                if ("s".equalsIgnoreCase(modifier)) shiftPressed = !shiftPressed;
                if ("c".equalsIgnoreCase(modifier)) capsLockOn = !capsLockOn;
                if (++i >= chars.length) break;
            }
            if (chars[i].matches("[0-9]") && shiftPressed) {
                chars[i] = symbols[Integer.parseInt(chars[i])];

            } else if (shiftPressed ^ capsLockOn) {
                chars[i] = chars[i].toUpperCase();
            }
            output.append(chars[i]);
        }
        System.out.println(output.toString());
    }
}
