import java.util.Scanner;

class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

   // Representacao em String da matriz
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }   

   public static Matrix identity(int n) {
	Matrix m = new Matrix(n, n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i == j) m.data[i][j] = 1;
			else m.data[i][j] = 0;
		}
	}
	return m;
   }

   public Matrix transpose() {
	Matrix m = new Matrix(this.cols, this.rows);

	for (int i = 0; i < m.rows; i++) {
		for (int j = 0; j < m.cols; j++) {
			m.data[i][j] = this.data[j][i];
		}
	}

	return m;
   }

   public Matrix sum(Matrix m) {
	Matrix A = new Matrix(this.rows, this.cols);
	for (int i = 0; i < m.rows; i++) {
		for (int j = 0; j < m.cols; j++) {
			A.data[i][j] = this.data[i][j] + m.data[i][j];
		}
	}

	return A;
   }

   public Matrix multiply(Matrix m) {
	Matrix A = new Matrix(this.rows, m.cols);

	for (int i = 0; i < A.rows; i++) {
		for (int j = 0; j < A.cols; j++) {
			A.data[i][j] = 0;
			for (int k = 0; k < this.cols; k++) {
				A.data[i][j] += this.data[i][k]*m.data[k][j];
			}
		}
	}
	return A;
   }
}
