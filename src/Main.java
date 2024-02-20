public class Main {
    public static void main(String[] args) {
        TestComplex();
        TestMatrix();
    }
    public static void PrintComplex(Complex complex){
        System.out.println();
        System.out.print("Complex number algebraic form:");
        complex.print();
    }

    public static void TestComplex(){
        System.out.println("Test Complex");
        Complex complex = new Complex(1, 2);
        PrintComplex(complex);

        Complex complex2 = new Complex(2, -3);
        PrintComplex(complex);

        System.out.println();
        System.out.println("Sum of 1 and 2 number:");
        Complex complexSum = complex.sumComplex(complex2);
        PrintComplex(complexSum);

        System.out.println();
        System.out.println("Product of 1 and 2 number:");
        Complex complexMulti = complex.multiComplex(complex2);
        PrintComplex(complexMulti);
    }
    public static void TestMatrix() {
        System.out.println("Test Matrix");
        Complex[][] complexes1 = new Complex[2][2];
        complexes1[0][0] = new Complex(-1.0, 0.0);
        complexes1[0][1] = new Complex(5.0, -3.0);
        complexes1[1][0] = new Complex(4.0, -8.0);
        complexes1[1][1] = new Complex(3.0, 1.0);
        Matrix matrix1 = new Matrix(complexes1);
        System.out.println();
        System.out.println("Introduced matrix:");
        matrix1.printMatrix();


        Complex[][] test = new Complex[4][4];
        test[0][0] = new Complex(-6.0, -8.0);
        test[0][1] = new Complex(7.0, -1.0);
        test[0][2] = new Complex(-3.0, -1.0);
        test[0][3] = new Complex(6.0, 5.0);
        test[1][0] = new Complex(1.0, 5.0);
        test[1][1] = new Complex(8.0, -2.0);
        test[1][2] = new Complex(0.0, 6.0);
        test[1][3] = new Complex(-8.0, -3.0);
        test[2][0] = new Complex(-4.0, 5.0);
        test[2][1] = new Complex(-3.0, 3.0);
        test[2][2] = new Complex(3.0, 9.0);
        test[2][3] = new Complex(8.0, -8.0);
        test[3][0] = new Complex(2.0, 5.0);
        test[3][1] = new Complex(4.0, 8.0);
        test[3][2] = new Complex(-5.0, 2.0);
        test[3][3] = new Complex(3.0, -3.0);
        Matrix t = new Matrix(test);
        t.printMatrix();
        System.out.println("Determinant of the matrix:");
        t.det().print();
        System.out.println();

        System.out.println("Transposed matrix:");
        Matrix matrixTransposed = matrix1.transposeMatrix();
        matrixTransposed.printMatrix();

        Complex[][] complexes2 = new Complex[2][2];
        complexes2[0][0] = new Complex(9.0, 8.0);
        complexes2[0][1] = new Complex(1.0, -10.0);
        complexes2[1][0] = new Complex(-8.0, -9.0);
        complexes2[1][1] = new Complex(-10.0, -7.0);
        Matrix matrix2 = new Matrix(complexes2);
        System.out.println();
        System.out.println("Introduced matrix:");
        matrix2.printMatrix();

        System.out.println("Sum of two matrices:");
        Matrix matrixSum = matrix1.sumMatrix(matrix2);
        matrixSum.printMatrix();

        System.out.println("Product of two matrices:");
        Matrix matrixMulti = matrix1.multiMatrix(matrix2);
        matrixMulti.printMatrix();
    }
}
