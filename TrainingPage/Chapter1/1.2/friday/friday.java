import java.io.IOException;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;

// 
// Decompiled by Procyon v0.5.36
// 

class friday
{
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader("friday.in"));
        final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        final int int1 = Integer.parseInt(new StringTokenizer(bufferedReader.readLine()).nextToken());
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 1;
        for (int i = 1900; i < 1900 + int1; ++i) {
            for (int j = 1; j < 13; ++j) {
                int n9 = 0;
                switch (j) {
                    case 9: {
                        n9 = 30;
                        break;
                    }
                    case 4: {
                        n9 = 30;
                        break;
                    }
                    case 6: {
                        n9 = 30;
                        break;
                    }
                    case 11: {
                        n9 = 30;
                        break;
                    }
                    case 2: {
                        n9 = 28;
                        break;
                    }
                    default: {
                        n9 = 31;
                        break;
                    }
                }
                if (i % 100 == 0 && j == 2) {
                    if (i % 400 == 0) {
                        n9 = 29;
                    }
                }
                else if (i % 4 == 0 && j == 2) {
                    n9 = 29;
                }
                for (int k = 1; k < n9 + 1; ++k) {
                    if (k == 13) {
                        switch (n8 % 7) {
                            case 0: {
                                ++n7;
                                break;
                            }
                            case 1: {
                                ++n;
                                break;
                            }
                            case 2: {
                                ++n2;
                                break;
                            }
                            case 3: {
                                ++n3;
                                break;
                            }
                            case 4: {
                                ++n4;
                                break;
                            }
                            case 5: {
                                ++n5;
                                break;
                            }
                            default: {
                                ++n6;
                                break;
                            }
                        }
                    }
                    ++n8;
                }
            }
        }
        System.out.println(n6 + " " + n7 + " " + n + " " + n2 + " " + n3 + " " + n4 + " " + n5);
        printWriter.close();
    }
}