package inputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class UserdefinedFastReaderClass {
//}

// Working program with FastReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserDefinedFastReaderClass {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public void close() throws IOException {
            if (br != null)
                br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        System.out.println("Enter value : ");
        int n = s.nextInt();
        System.out.println("Enter value : ");
        int k = s.nextInt();
        int count = 0;
        long startTime = System.currentTimeMillis(); // Start time measurement
        while (n-- > 0) {
            int x = s.nextInt();
            if (x % k == 0)
                count++;
        }
        long endTime = System.currentTimeMillis(); // End time measurement
        long executionTime = endTime - startTime; // Calculate execution time
        System.out.println(count);
        System.out.println("Execution time: " + executionTime + " milliseconds");
        s.close();
    }
}

