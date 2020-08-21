import java.io.*;

public class InputOutput {
    public static void main(String args[]) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("/Users/nborgohain/Documents/personal/Progarmming/codechef/src/input.txt");
            out = new FileOutputStream("/Users/nborgohain/Documents/personal/Progarmming/codechef/src/output.txt");

            int c;

//            int c;
//            while ((c = in.read()) != -1) {
//                out.write(c);
//            }
        }finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
