package pl.edu.bogdan.mutations;

public class Library {
    public int foo(int a, int b, int c) {
        int x = 0;
        if (a > b) {
            x = a*b;
        } else {
            x = 0;
        }

        if (b < c) {
            return c*x;
        } else {
            return c/x;
        }
    }
}
