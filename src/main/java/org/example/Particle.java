package org.example;

public class Particle {

    private double[] positon;
    private double[] velocity;
    private double[] bestPosition;

    public Particle(double[] positon, double[] velocity) {
        this.positon = positon;
        this.velocity = velocity;
        this.bestPosition = new double[Constants.NUM_DIMESIONS];
        System.arraycopy(velocity,0,this.velocity,0,velocity.length);
        System.arraycopy(positon,0,this.positon,0,positon.length);
    }

    public double[] getPositon() {
        return positon;
    }

    public void setPositon(double[] positon) {
        this.positon = positon;
    }

    public double[] getVelocity() {
        return velocity;
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public double[] getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(double[] bestPosition) {
        this.bestPosition = bestPosition;
    }

    public void checkBestPosition(double[] globalBestPosition) {
        if (Constants.f(this.bestPosition) < Constants.f(globalBestPosition)) {
            globalBestPosition = bestPosition;
        }
    }

    @Override
    public String toString() {
        return "Best coordinates so far: " +
                "x " + this.bestPosition[0] + " - y " + this.bestPosition[1];
    }
}
