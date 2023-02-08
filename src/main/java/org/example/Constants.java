package org.example;

public class Constants {

    private Constants() {
    }

    public final static int NUM_DIMESIONS = 2;
    public final static int NUM_PARTICLES = 10;
    public final static double MIN = -2;
    public final static double MAX = 2;
    public final static double w = 0.729;
    public final static double localweight = 1.49;
    public final static double globalweight = 1.49;
    public final static double MAX_ITERATIONS = 10000;

    public static double f(double[] data) {
        return Math.exp(-data[0]*data[0]-data[1]*data[1])*Math.sin(data[0]);
    }


}
