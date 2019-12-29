package CodingInterview;

public class Q12_矩阵中的字符串路径 {
    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
     * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
     * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
     * 路径不能再次进入该格子。
     * <p>
     * 解法思路：采用回溯法
     */

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if (matrix == null || str == null || rows < 1 || cols < 1)  //合法性判断
            return false;
        int[][] flag = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (search(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    public boolean search(char[] matrix, int rows, int cols,
                          int i, int j, char[] str, int index, int[][] flag) {
        int m_i = i * cols + j;
        if (i < 0 || j < 0 || i >= rows || j >= cols || flag[i][j] == 1 || matrix[m_i] != str[index])
            return false;
        if (index >= str.length - 1)
            return true;
        flag[i][j] = 1;
        if (search(matrix, rows, cols, i + 1, j, str, index + 1, flag) ||
                search(matrix, rows, cols, i - 1, j, str, index + 1, flag) ||
                search(matrix, rows, cols, i, j + 1, str, index + 1, flag) ||
                search(matrix, rows, cols, i, j - 1, str, index + 1, flag))
            return true;
        flag[i][j] = 0;
        return false;
    }
}
