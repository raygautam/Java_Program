package inputOutput;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class UsingReader {
        static class MainReader {
            final private int BUFFER_SIZE = 1 << 16;
            private DataInputStream din;
            private byte[] buffer;
            private int bufferPointer, bytesRead;

            public MainReader() {
                din = new DataInputStream(System.in);
                buffer = new byte[BUFFER_SIZE];
                bufferPointer = bytesRead = 0;
            }

            public MainReader(String file_name) throws IOException {
                din = new DataInputStream(new FileInputStream(file_name));
                buffer = new byte[BUFFER_SIZE];
                bufferPointer = bytesRead = 0;
            }

            public int nextInt() throws IOException {
                int ret = 0;
                byte c = read();
                while (c <= ' ') {
                    c = read();
                }
                boolean neg = (c == '-');
                if (neg)
                    c = read();
                do {
                    ret = ret * 10 + c - '0';
                } while ((c = read()) >= '0' && c <= '9');

                if (neg)
                    return -ret;
                return ret;
            }

            private void fillBuffer() throws IOException {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1)
                    buffer[0] = -1;
            }

            private byte read() throws IOException {
                if (bufferPointer == bytesRead)
                    fillBuffer();
                return buffer[bufferPointer++];
            }

            public void close() throws IOException {
                if (din != null)
                    din.close();
            }
        }

        public static void main(String[] args) throws IOException {
            MainReader reader = new MainReader();
            int numberOfElements = reader.nextInt();
            int divisor = reader.nextInt();
            int countOfMultiples = 0;
            long startTime=System.currentTimeMillis();
            while (numberOfElements-- > 0) {
                int element = reader.nextInt();
                if (element % divisor == 0)
                    countOfMultiples++;
            }
            long endTime=System.currentTimeMillis();
            long executingTime=endTime-startTime;
            System.out.println(countOfMultiples);
            System.out.println("Execution time : "+executingTime);
            reader.close();
        }

}
