class Matrix_Mult {
    static int[][] a;
    static int[][] b;

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6}};
        int[][] b = {{7,8},{9,10},{11,12}};
        printMtrx(a);
        printMtrx(b);
        printMtrx(Mmult(a,b));
    }

    public static int[][] Mmult(int[][] a, int[][] b) {
        int aRows, aCols, bRows, bCols;
        aRows = a.length;
        aCols = a[0].length;
        bRows = b.length;
        bCols = b[0].length;
        if (aCols != bRows) return null;
        int[][] result = new int[aRows][bCols];

        for (int x = 0; x < aRows; x++){
            for (int y = 0; y < bCols; y++){
                int val = 0;
                for(int r = 0; r < aCols; r++){
                    val += a[x][r] * b[r][y];
                }
                result[x][y] = val;
            }
        }
        return result;
    } 

    public static void printMtrx(int[][] mtrx){
        String s = "";
        for (int i = 0; i < mtrx.length; i++){
            for (int j = 0; j < mtrx[0].length; j++){
                s += mtrx[i][j] + " ";
            }
            s += "\n"; 
        }
        System.out.println(s); 
    }
}