import java.util.Scanner;

class MatrixMultiplier implements Runnable {
    private int[][] A, B, result;
    private int row, col, size;

    public MatrixMultiplier(int[][] A, int[][] B, int[][] result, int row, int col, int size) {
        this.A = A;
        this.B = B;
        this.result = result;
        this.row = row;
        this.col = col;
        this.size = size;
    }

    @Override
    public void run() {
        for (int k = 0; k < size; k++) {
            result[row][col] += A[row][k] * B[k][col];
        }
    }
}

class Task10 {
    public static int[][] multiplyMatrices(int[][] A, int[][] B, int size) {
        int[][] result = new int[size][size];
        Thread[][] threads = new Thread[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                threads[i][j] = new Thread(new MatrixMultiplier(A, B, result, i, j, size));
                threads[i][j].start();
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                try {
                    threads[i][j].join();
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter matrix size (N x N): ");
        int size = sc.nextInt();

        int[][] A = new int[size][size];
        int[][] B = new int[size][size];

        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        int[][] result = multiplyMatrices(A, B, size);

        System.out.println("Resultant Matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
