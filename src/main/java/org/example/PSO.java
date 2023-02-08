package org.example;

import lombok.Data;

@Data
public class ParticleSwarmOptimization {
    private double[] globalBestSolution;
    private Particle[] particleSwarm;
    private int epochs;

    double x = random(Constants.MIN, Constants.MAX);
    double y = random(Constants.MIN, Constants.MAX);
    double vx = random(-(Constants.MAX-Constants.MIN), Constants.MAX-Constants.MIN);
    double vy = random(-(Constants.MAX-Constants.MIN), Constants.MAX-Constants.MIN);

    public ParticleSwarmOptimization() {
        this.globalBestSolution = new double[Constants.NUM_DIMESIONS];
        this.particleSwarm = new Particle[Constants.NUM_PARTICLES];
        // generateRandomSolution
        for (int i = 0; i < Constants.NUM_DIMESIONS; i++) {
            double randCoordinates = random(Constants.MIN, Constants.MAX);
            this.globalBestSolution[i] = randCoordinates;
        }
    }

    public void solve() {
        for (int i = 0; i < Constants.NUM_PARTICLES; i++) {
            double[] locations = new double[] {x, y};  // initializeLocation();
            double[] velocity = new double[] {vx, vy}; // initializeVelocity();

            this.particleSwarm[i] = new Particle(locations, velocity);
            this.particleSwarm[i].checkBestPosition(globalBestSolution);
        }

        while (epochs < Constants.MAX_ITERATIONS) {
            for (Particle particle: this.particleSwarm) {
                for (int i = 0; i < particle.getVelocity().length; i++) {
                    double rp = Math.random();
                    double rg = Math.random();

                    particle.getVelocity()[i] = Constants.w *
                            particle.getVelocity()[i] + Constants.localweight * rp * (particle.getBestPosition()[i]- particle.getPositon()[i]) + Constants.globalweight * rg * (globalBestSolution[i]-particle.getPositon()[i]);
                }

                for (int i = 0; i < particle.getPositon().length; i++) {

                    particle.getPositon()[i] += particle.getVelocity()[i];

                    if (particle.getPositon()[i] < Constants.MIN) {
                        particle.getPositon()[i] = Constants.MIN;
                    } else if (particle.getPositon()[i] > Constants.MAX) {
                        particle.getPositon()[i] = Constants.MAX;
                    }
                }

                if( Constants.f(particle.getPositon()) < Constants.f(particle.getBestPosition())) {
                    particle.setBestPosition(particle.getPositon());
                }

                if (Constants.f(particle.getBestPosition()) < Constants.f(globalBestSolution)) {
                    System.arraycopy(particle.getBestPosition(),0, globalBestSolution,0, particle.getBestPosition().length);
                }
            }
            this.epochs++;
        }

    }

    public double random(double min, double max) {
        return min + (max-min) * Math.random();
    }

}
