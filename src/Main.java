import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
        System.out.println("Java Lab 2 ");
        // 1
        System.out.println("№1 \n");
        class Triangle {
            private double sideA, sideB, sideC;
            private double angleA, angleB, angleC;
        
            public Triangle(double sideA, double sideB, double sideC, double angleA, double angleB, double angleC) {
                this.sideA = sideA;
                this.sideB = sideB;
                this.sideC = sideC;
                this.angleA = angleA;
                this.angleB = angleB;
                this.angleC = angleC;
            }
        
            // Периметр трикутника
            public double getPerimeter() {
                return sideA + sideB + sideC;
            }
        
            // Площа трикутника за формулою Герона
            public double getArea() {
                double s = getPerimeter() / 2;
                return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
            }
        
            // Висоти трикутника
            public double getHeightA() {
                return (2 * getArea()) / sideA;
            }
        
            public double getHeightB() {
                return (2 * getArea()) / sideB;
            }
        
            public double getHeightC() {
                return (2 * getArea()) / sideC;
            }

            public String getTriangleType() {
                if (isEquilateral()) {
                    return "Рівносторонній трикутник";
                } else if (isIsosceles()) {
                    return "Рівнобедрений трикутник";
                } else if (isRightAngled()) {
                    return "Прямокутний трикутник";
                } else {
                    return "Різносторонній трикутник";
                }
            }
        
            // Рівносторонній трикутник
            private boolean isEquilateral() {
                return sideA == sideB && sideB == sideC && angleA == angleB && angleB == angleC;
            }
        
            // Рівнобедрений трикутник
            private boolean isIsosceles() {
                return (sideA == sideB || sideB == sideC || sideA == sideC) || 
                       (angleA == angleB || angleB == angleC || angleA == angleC);
            }
        
            // Прямокутний трикутник
            private boolean isRightAngled() {
                return Math.round(angleA) == 90 || Math.round(angleB) == 90 || Math.round(angleC) == 90;
            }
        }

        
        Triangle triangle = new Triangle(15, 20, 25, 90, 60, 30);
        System.out.println("Периметр трикутника: " + triangle.getPerimeter());
        System.out.println("Площа трикутника: " + triangle.getArea());
        System.out.println("Висота на сторону A, B i C: " + triangle.getHeightA() + ", " + triangle.getHeightB() + ", " + triangle.getHeightC());
        System.out.println("Тип трикутника: " + triangle.getTriangleType());

        
        // 2 
        System.out.println("№2 \n");
        class ComplexNum {
            private double real;
            private double imaginary;
        
            public ComplexNum(double real, double imaginary) {
                this.real = real;
                this.imaginary = imaginary;
            }
        
            public double modulus() {
                return Math.sqrt(real * real + imaginary * imaginary);
            }
        
            public ComplexNum add(ComplexNum other) {
                return new ComplexNum(real + other.real, imaginary + other.imaginary);
            }
        
            public ComplexNum subtract(ComplexNum other) {
                return new ComplexNum(real - other.real, imaginary - other.imaginary);
            }
        
            public ComplexNum multiply(ComplexNum other) {
                double newReal = real * other.real - imaginary * other.imaginary;
                double newImaginary = real * other.imaginary + imaginary * other.real;
                return new ComplexNum(newReal, newImaginary);
            }
        
            public ComplexNum divide(ComplexNum other) {
                double denominator = other.real * other.real + other.imaginary * other.imaginary;
                double newReal = (real * other.real + imaginary * other.imaginary) / denominator;
                double newImaginary = (imaginary * other.real - real * other.imaginary) / denominator;
                return new ComplexNum(newReal, newImaginary);
            }
        
            // Комплексне спряжене
            public ComplexNum conjugate() {
                return new ComplexNum(real, -imaginary);
            }

            public String toString() {
                return real + " + " + imaginary + "i";
            }
        }

        ComplexNum num1 = new ComplexNum(1, 3);
        ComplexNum num2 = new ComplexNum(1, 0);

        System.out.println("Додавання: " + num1.add(num2));
        System.out.println("Віднімання: " + num1.subtract(num2));
        System.out.println("Множення: " + num1.multiply(num2));
        System.out.println("Ділення: " + num1.divide(num2));
        System.out.println("Модуль num1: " + num1.modulus());
        System.out.println("Спряжене num1: " + num1.conjugate());

        // 3
        System.out.println("№3 \n");

        class VeryLongNumber {
        private double value;

    public VeryLongNumber(String value) {
        this.value = Double.parseDouble(value);
    }

    public VeryLongNumber add(VeryLongNumber other) {
        return new VeryLongNumber(Double.toString(this.value + other.value));
    }

    public VeryLongNumber subtract(VeryLongNumber other) {
        return new VeryLongNumber(Double.toString(this.value - other.value));
    }

    public VeryLongNumber multiply(VeryLongNumber other) {
        return new VeryLongNumber(Double.toString(this.value * other.value));
    }

    public VeryLongNumber divide(VeryLongNumber other) {
        return new VeryLongNumber(Double.toString(this.value / other.value));
    }

    // Піднесення в натуральний степінь
    public VeryLongNumber pow(int exponent) {
        return new VeryLongNumber(Double.toString(Math.pow(this.value, exponent)));
    }

    public String toString() {
        return Double.toString(value);
    }
}

    Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть перше довге число:");
        VeryLongNumber num3 = new VeryLongNumber(scanner.nextLine());

        System.out.println("Введіть друге довге число:");
        VeryLongNumber num4 = new VeryLongNumber(scanner.nextLine());

        System.out.println("Додавання: " + num3.add(num4));
        System.out.println("Віднімання: " + num3.subtract(num4));
        System.out.println("Множення: " + num3.multiply(num4));
        System.out.println("Ділення: " + num3.divide(num4));
        System.out.println("Перше число в степені 2: " + num3.pow(2));
    }
}
