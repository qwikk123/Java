package BouncingBall;

import java.util.stream.Stream;

public class BouncingBall {

    public static int bouncingBall(double h, double bounce, double window) {
        if (h <= 0 || bounce >= 1 || bounce <= 0 || window >= h) return -1;
        return (int) Stream.iterate(h, x -> x*bounce)
                .takeWhile(x -> x > window)
                .count()*2-1;
    }
}
