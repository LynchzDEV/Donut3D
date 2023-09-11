package Test;

import java.util.Arrays;

public class Donut {
    public static void main(String[] args) throws InterruptedException {
        int k;
        double A = 0, B = 0, i, j;

        // Adjustable variables
        int screenWidth = 80; // Number of columns in the output screen
        int screenHeight = 25; // Number of rows in the output screen
        double rotationSpeedA = 0.03; // Speed of rotation for variable A
        double rotationSpeedB = 0.01; // Speed of rotation for variable B
        int frameDelay = 10; // Delay between frames in milliseconds

        double[] z = new double[screenWidth * screenHeight];
        char[] b = new char[screenWidth * screenHeight];
        for (;;) {
            Arrays.fill(b, 0, screenWidth * screenHeight, ' ');
            Arrays.fill(z, 0, screenWidth * screenHeight, 0);
            for (j = 0; 6.28 > j; j += 0.07)
                for (i = 0; 6.28 > i; i += 0.02) {
                    double c = Math.sin(i),
                            d = Math.cos(j),
                            e = Math.sin(A),
                            f = Math.sin(j),
                            g = Math.cos(A),
                            h = d + 2,
                            D = 1 / (c * h * e + f * g + 5),
                            l = Math.cos(i),
                            m = Math.cos(B),
                            n = Math.sin(B),
                            t = c * h * g - f * e;
                    int x = (int) (40 + 30 * D * (l * h * m - t * n)),
                            y = (int) (12 + 15 * D * (l * h * n + t * m)),
                            o = x + screenWidth * y,
                            N = (int) (8 * ((f * e - c * d * g) * m - c * d * e - f * g - l * d * n));
                    if (y >= 0 && y < screenHeight && x >= 0 && x < screenWidth && D > z[o]) {
                        z[o] = D;
                        b[o] = new char[] { '.', ',', '-', '~', ':', ';', '=', '!', '*', '#', '$', '@' }[Math.max(N,
                                0)];
                    }
                }
            System.out.print("\u001b[H");
            for (k = 0; screenWidth * screenHeight > k; k++)
                System.out.print(k % screenWidth > 0 ? b[k] : 10);
            A += rotationSpeedA;
            B += rotationSpeedB;

            Thread.sleep(frameDelay);
        }
    }
}

