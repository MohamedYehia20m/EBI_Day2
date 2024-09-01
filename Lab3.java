package EBI;

public class Lab3 {

    public static void main(String[] args) {
        ComplexNumber<Double> x = new ComplexNumber<>(3.0, 4.0);
        ComplexNumber<Double> y = new ComplexNumber<>(2.0, 4.0);

        x.subComplex(y);

        System.out.println("y real: " + y.getRe());
        System.out.println("y img: " + y.getIm());

        x.mulComplex(y);

        System.out.println("y real after multiplication: " + y.getRe());
        System.out.println("y img after multiplication: " + y.getIm());

        x.divComplex(y);

        System.out.println("y real after division: " + y.getRe());
        System.out.println("y img after division: " + y.getIm());
    }

    public static class ComplexNumber<T extends Number> {
        private T Re;
        private T Im;

        // Constructor
        public ComplexNumber(T Re, T Im) {
            this.Re = Re;
            this.Im = Im;
        }

        // Getter for Re
        public T getRe() {
            return Re;
        }

        // Setter for Re
        public void setRe(T Re) {
            this.Re = Re;
        }

        // Getter for Im
        public T getIm() {
            return Im;
        }

        // Setter for Im
        public void setIm(T Im) {
            this.Im = Im;
        }

        public ComplexNumber<T> addComplex(ComplexNumber<T> num) {
            this.Re = castToT(this.Re.doubleValue() + num.Re.doubleValue());
            this.Im = castToT(this.Im.doubleValue() + num.Im.doubleValue());
            return this;
        }

        public ComplexNumber<T> subComplex(ComplexNumber<T> num) {
            this.Re = castToT(this.Re.doubleValue() - num.Re.doubleValue());
            this.Im = castToT(this.Im.doubleValue() - num.Im.doubleValue());
            return this;
        }

        public ComplexNumber<T> mulComplex(ComplexNumber<T> num) {
            double tempRe = this.Re.doubleValue() * num.Re.doubleValue() - this.Im.doubleValue() * num.Im.doubleValue();
            double tempIm = this.Re.doubleValue() * num.Im.doubleValue() + this.Im.doubleValue() * num.Re.doubleValue();
            this.Re = castToT(tempRe);
            this.Im = castToT(tempIm);
            return this;
        }

        public ComplexNumber<T> divComplex(ComplexNumber<T> num) {
            double denominator = num.Re.doubleValue() * num.Re.doubleValue() + num.Im.doubleValue() * num.Im.doubleValue();
            double tempRe = (this.Re.doubleValue() * num.Re.doubleValue() + this.Im.doubleValue() * num.Im.doubleValue()) / denominator;
            double tempIm = (this.Im.doubleValue() * num.Re.doubleValue() - this.Re.doubleValue() * num.Im.doubleValue()) / denominator;
            this.Re = castToT(tempRe);
            this.Im = castToT(tempIm);
            return this;
        }

        // Method to cast double to T
        @SuppressWarnings("unchecked")
        private T castToT(double value) {
            if (Re instanceof Double) {
                return (T) Double.valueOf(value);
            } else if (Re instanceof Integer) {
                return (T) Integer.valueOf((int) value);
            } else if (Re instanceof Float) {
                return (T) Float.valueOf((float) value);
            } else if (Re instanceof Long) {
                return (T) Long.valueOf((long) value);
            } else {
                throw new UnsupportedOperationException("Type not supported");
            }
        }
    }
}
