// 檔案名稱：IntegralImage.java
public class IntegralImage {

    public static int[][] computeIntegralImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        
        // 建立長寬各加 1 的積分影像陣列（包含最左上角的 0 邊界）
        int[][] integral = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                integral[i][j] = image[i - 1][j - 1] 
                               + integral[i - 1][j] 
                               + integral[i][j - 1] 
                               - integral[i - 1][j - 1];
            }
        }
        return integral;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Assignment 3: Integral Image ---");
        
        // 投影片 Page 14 的 Input Image 範例
        int[][] inputImage = {
            {1, 2, 2, 4, 1},
            {3, 4, 1, 5, 2},
            {2, 3, 3, 2, 4},
            {4, 1, 5, 4, 6},
            {6, 3, 2, 1, 3}
        };

        System.out.println("Input Image:");
        printMatrix(inputImage);

        int[][] integral = computeIntegralImage(inputImage);
        
        System.out.println("\nIntegral Image (with padded 0s):");
        printMatrix(integral);

        System.out.println("\n[Time Complexity]");
        System.out.println("Building Integral Image: O(W * H), where W is width and H is height.");
        System.out.println("Querying any rectangular sum: O(1)");
    }
}