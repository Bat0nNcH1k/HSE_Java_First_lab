public class Matrix {
    private final int rows;
    private final int cols;
    private Complex[][] matrix;

    public Matrix() {
        rows = 0;
        cols = 0;
    }

    public Matrix(Complex[][] matrix) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.matrix = matrix;
    }

    public void setMatrix(Complex[][] matrix) {
        this.matrix = matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Complex getElement(int i, int j) {
        return matrix[i][j];
    }

    public Matrix sumMatrix(Matrix b) {
        if (rows!= b.getRows() || cols!=b.getCols()) {
            System.out.println("Matrix sizes do not combine with each other");
            return null;
        }
        Complex[][] matrixSum = new Complex[rows][cols];

        for(int i = 0; i < rows; ++i) {
            for(int j =0; j < cols; ++j) {
                matrixSum[i][j] = (this.getElement(i,j)).sumComplex(b.getElement(i,j));
            }
        }
        return new Matrix(matrixSum);
    }

    public Matrix multiMatrix(Matrix b) {
        if(this.cols != b.getRows()) {
            System.out.println("Matrix sizes do not combine with each other");
            return null;
        }
        Complex[][] matrixMulti = new Complex[rows][b.getCols()];
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < b.getCols(); ++j) {
                matrixMulti[i][j] = new Complex();
                for (int k = 0; k < cols; ++k)
                    matrixMulti[i][j] = matrixMulti[i][j].sumComplex(matrix[i][k].multiComplex(b.getElement(k, j)));
            }
        return new Matrix(matrixMulti);
    }

    public Complex det() {
        if (this.cols != this.rows) {
            throw new IllegalArgumentException("Could not calculate determinant of non-squared matrix");
        }
        int n = rows;
        if (n == 1) {
            return matrix[0][0];
        }
        Complex res = new Complex(0, 0);
        Complex pow1 = new Complex(1, 0);
        for (int i = 0; i < n; ++i) {
            res = res.sumComplex(matrix[i][0].multiComplex(pow1).multiComplex(minor(i, 0).det()));
            if (pow1.real == 1) pow1.setReal(-1);
            else pow1.setReal(1);
        }
        return res;
    }
    public Matrix minor(int row, int col) {
        Complex[][] temp = new Complex[rows - 1][cols - 1];
        int di = 0;
        int dj = 0;
        for (int i = 0; i < rows - 1; ++i) {
            if (i == row) {
                di = 1;
            }
            dj = 0;
            for (int j = 0; j < cols - 1; ++j) {
                if (j == col) {
                    dj = 1;
                }
                temp[i][j] = this.matrix[i + di][j + dj];
            }
        }
        return new Matrix(temp);
    }

    public Matrix transposeMatrix(){
        Complex[][] matrixTranspose = new Complex[this.cols][this.rows];
        for(int i = 0; i < this.rows; ++i){
            for(int j = 0; j < this.cols; ++j){
                matrixTranspose[j][i] = this.getElement(i, j);
            }
        }
        return new Matrix(matrixTranspose);
    }

    public void printMatrix() {
        for(int i = 0; i < this.rows; ++i){
            for(int j = 0; j < cols; ++j){
                if (matrix[i][j].getImage() > 0)
                    System.out.print(matrix[i][j].getReal() + " + " + matrix[i][j].getImage() + "i\t");
                else if (matrix[i][j].getImage() < 0)
                    System.out.print(matrix[i][j].getReal() + "" + matrix[i][j].getImage() + "i\t");
                else
                    System.out.print(matrix[i][j].getReal()+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
