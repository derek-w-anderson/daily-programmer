import java.util.Arrays;

/**
 * Challenge #69 (Easy) - http://www.reddit.com/r/dailyprogrammer/comments/vmblw/6262012_challenge_69_easy/
 */
public class InputTabulator {

    private String[] headers;
    private String[][] data;
    private int[] maxLengths;
    private String rowSeparator;

    public InputTabulator(String[] headers, String[][] data) {
        this.headers = headers;
        this.data = data;

        this.maxLengths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j].length() > maxLengths[i]) {
                    maxLengths[i] = data[i][j].length();
                }
            }
        }
        StringBuilder rs = new StringBuilder("+");
        for (int len : maxLengths) {
            char[] arr = new char[len + 2];
            Arrays.fill(arr, '-');
            rs.append(new String(arr) + "+");
        }
        this.rowSeparator = rs.toString();
    }

    public void printTable() {
        System.out.println(rowSeparator + "\n" + getRow(headers));
        for (int i = 0; i < data.length; i++) {
            System.out.println(rowSeparator + "\n" + getRow(data[i]));
        }
        System.out.println(rowSeparator);
    }

    private String getRow(String[] cols) {
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < cols.length; i++) {
            row.append("| " + cols[i] + " ");
            for (int len = cols[i].length(); len < maxLengths[i]; len++) {
                row.append(" ");
            }
        }
        row.append("|");
        return row.toString();
    }
    
    public static void main(String[] args) {
        String[] headers = { "Name", "Address", "Description" };
        String[][] data = {
            { "reddit",     "www.reddit.com",   "the frontpage of the internet" },
            { "Wikipedia",  "en.wikipedia.net", "The Free Encyclopedia" },
            { "xkcd",       "xkcd.com",         "Sudo make me a sandwich." }
        };
        new InputTabulator(headers, data).printTable();
    }
}

