import java.io.*;

/**
 * Challenge 79 (Intermediate) - http://www.reddit.com/r/dailyprogrammer/comments/wvcv9/7182012_challenge_79_intermediate_plain_pgm_file/
 */
public class PGMViewer
{
    private File file;
    private int width, height, maxval, offset;

    public PGMViewer(File pgmFile) throws IOException {
        this.file = pgmFile;

        InputStreamReader is = new InputStreamReader(new FileInputStream(pgmFile));
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(is));
        st.commentChar('#');

        st.nextToken(); // skip "P2"
        st.nextToken(); this.width  = (int) st.nval;
        st.nextToken(); this.height = (int) st.nval;
        st.nextToken(); this.maxval = (int) st.nval;
        st.nextToken(); this.offset = st.lineno() - 1;

        is.close();
    }

    public String toASCII() throws FileNotFoundException {
        StringBuilder out = new StringBuilder();

        java.util.Scanner in = new java.util.Scanner(file);
        for (int i = 0; i < offset; i++) in.nextLine();

        char[] gradient = { ' ', '.', ':', ';', '+', '=', '%', '$', '#' };
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int i = (int) ((in.nextDouble() / maxval) * (gradient.length-1));
                out.append(gradient[i]);
            }
            out.append("\n");
        }
        in.close();
        return out.toString();
    }

    public static void main(String args[]) {
        if (args.length < 1) {
            System.err.println("Usage: java PGMViewer file.pgm");
            System.exit(1);
        }
        try {
            File pgmFile = new File(args[0]);
            if (!pgmFile.exists() || !pgmFile.isFile() || !pgmFile.canRead()) {
                throw new IOException("Invalid filepath");
            }
            System.out.print(new PGMViewer(pgmFile).toASCII());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
