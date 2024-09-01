package EBI;

import java.util.function.Function;

public class Lab2 {

    public static void main(String[] args) {
        Data Coeff = new Data(-6, 36, 59);
        
        Function<Data, Roots[]> QuadraticRoots = params -> {
            double a = params.getA(); // Use params instead of Coeff
            double b = params.getB();
            double c = params.getC();
            
            double discriminant = (b * b) - (4 * a * c);
            Roots[] roots = new Roots[2]; // Declare roots array inside lambda
            
            double root_re = (-b) / (2 * a);
            
            if (discriminant >= 0) {
                // Real roots
                double sqrtDiscriminant = Math.sqrt(discriminant);
                double root1_Re = root_re + sqrtDiscriminant / (2 * a);
                double root2_Re = root_re - sqrtDiscriminant / (2 * a);
                roots[0] = new Roots(root1_Re, 0);
                roots[1] = new Roots(root2_Re, 0);
            } else {
                // Complex roots
                double sqrtNegativeDiscriminant = Math.sqrt(-discriminant);
                roots[0] = new Roots(root_re, sqrtNegativeDiscriminant / (2 * a));
                roots[1] = new Roots(root_re, -sqrtNegativeDiscriminant / (2 * a));
            }
            return roots;
        };

        Roots[] roots1 = QuadraticRoots.apply(Coeff);

        // Print the roots
        System.out.println("Root 1: " + roots1[0]);
        System.out.println("Root 2: " + roots1[1]);
    }

    public static class Data {
        private double a;
        private double b;
        private double c;

        // Constructor
        public Data(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        // Getter for a
        public double getA() {
            return a;
        }

        // Setter for a
        public void setA(double a) {
            this.a = a;
        }

        // Getter for b
        public double getB() {
            return b;
        }

        // Setter for b
        public void setB(double b) {
            this.b = b;
        }

        // Getter for c
        public double getC() {
            return c;
        }

        // Setter for c
        public void setC(double c) {
            this.c = c;
        }
    }

    public static class Roots {
        private double Re;
        private double Im;

        // Constructor
        public Roots(double Re, double Im) {
            this.Re = Re;
            this.Im = Im;
        }

        // Getter for Re
        public double getRe() {
            return Re;
        }

        // Setter for Re
        public void setRe(double Re) {
            this.Re = Re;
        }

        // Getter for Im
        public double getIm() {
            return Im;
        }

        // Setter for Im
        public void setIm(double Im) {
            this.Im = Im;
        }

        @Override
        public String toString() {
            return "Roots{" +
                    "Re=" + Re +
                    ", Im=" + Im +
                    '}';
        }
    }
}
