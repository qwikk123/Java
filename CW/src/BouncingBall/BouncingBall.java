package BouncingBall;

import java.util.stream.Stream;

public class BouncingBall {

    public static int bouncingBall(double h, double bounce, double window) {
        return (h <= 0 || bounce >= 1 || bounce <= 0 || window >= h) ? -1 :
                (int) Stream.iterate(h, x -> x > window, x -> x*bounce).count()*2-1;
    }
}
