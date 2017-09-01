/**
 * Created by apple on 12/02/2017.
 */
public class MatrixNeighbors {
    int row = 0;
    int column = 0;
    int [][] matrix;

    public MatrixNeighbors(int row, int column) {
        this.row = row;
        this.column = column;
        matrix = new int[row][column];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public String neighbors(int row, int column)
    {
        String result = "";
        try {
            matrix[row][column] = 0;

            try {// #1
                matrix[row - 1][column] = 0;
                result += (row - 1) + "," + column + ";";
            } catch (Exception e) {}
            try { // #2
                matrix[row - 1][column + 1] = 0;
                result += (row - 1) + "," + (column + 1) + ";";
            } catch (Exception e) {}
            try {// #3
                matrix[row][column + 1] = 0;
                result += (row) + "," +  (column + 1) + ";";
            } catch (Exception e) {}
            try {// #4
                matrix[row + 1][column + 1] = 0;
                result += (row+1) + "," + (column+1) + ";";
            } catch (Exception e) {}
            try {// #5
                matrix[row + 1][column] = 0;
                result += (row + 1) + "," + (column) + ";";
            } catch (Exception e) {}
            try { // #6
                matrix[row + 1][column - 1] = 0;
                result += (row+1) + "," + (column-1) + ";";
            } catch (Exception e) {}
            try { // #7
                matrix[row][column - 1] = 0;
                result += (row) + "," + (column-1) + ";";
            } catch (Exception e) {}
            try { // #8
                matrix[row - 1][column - 1] = 0;
                result += (row-1) + "," + (column-1) + ";";
            } catch (Exception e) {}

        } catch (Exception e)
        {
            result += "Cell does not exist";
        }
        finally
        {
            return result;
        }
    }

    public static void main(String[] args) {
        MatrixNeighbors matrixNeighbors = new MatrixNeighbors(3,3);
        System.out.println(matrixNeighbors.neighbors(0, 0)); //prints "0,1;1,1;1,0;"
        System.out.println(matrixNeighbors.neighbors(2, 2)); //prints "1,2;2,1;1,1;"
        System.out.println(matrixNeighbors.neighbors(1, 1)); //prints "0,1;0,2;1,2;2,2;2,1;2,0;1,0;0,0;"
        System.out.println(matrixNeighbors.neighbors(3, 0)); //prints "cell does not exist"
    }
}
