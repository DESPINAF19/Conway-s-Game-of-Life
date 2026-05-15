public class GameOfLife {
    private int rows; //ύψος πλέγματος
    private int cols; //μήκος πλέγματος
    private boolean[][] matrix; //πλέγμα με 2 δυνατές αληθοτιμές
    public GameOfLife(int r ,int c) {
        //κατασκευαστής πλέγματος
        rows=r;
        cols=c;
        matrix = new boolean[rows][cols];
}
    public boolean[][] FirstGeneration() {
        // δίνει στον πίνακα τυχαίες αληθοτιμές ως αρχικές συνθήκες
        for (int i=0 ; i<rows ; i++) {
            for (int j=0; j<cols; j++) {
            int random = (int) (Math.random() * 2);
            if(random==0){ 
                matrix[i][j]=false;
                }
            else{matrix[i][j]=true;}
        }
         }
   return matrix; 
} 
public int Neighbors(int row, int col) {
    //μετράει το πλήθος γειτόνων κάθε κυττάρου στο πλέγμα
      int count = 0;
      if(row>0 && row<rows-1 && col>0 && col<cols-1){
          if(matrix[row-1][col]==true) count++;
          if(matrix[row-1][col-1]==true) count++;
          if(matrix[row-1][col+1]==true) count++;
          if(matrix[row][col-1]==true) count++;
          if(matrix[row][col+1]==true) count++;
          if(matrix[row+1][col]==true) count++;
          if(matrix[row+1][col-1]==true) count++;
          if(matrix[row+1][col+1]==true) count++;
          }
     else if( row==0 && col>0 && col<cols-1) {
         if(matrix[row][col-1]==true) count++;
          if(matrix[row][col+1]==true) count++;
          if(matrix[row+1][col]==true) count++;
          if(matrix[row+1][col-1]==true) count++;
          if(matrix[row+1][col+1]==true) count++;
     }
     else if(row==rows-1 && col>0 && col<cols-1) {
         if(matrix[row-1][col]==true) count++;
          if(matrix[row-1][col-1]==true) count++;
          if(matrix[row-1][col+1]==true) count++;
          if(matrix[row][col-1]==true) count++;
          if(matrix[row][col+1]==true) count++;
     }
     else if( row>0 && row<rows-1 && col==0) {
         if(matrix[row-1][col]==true) count++;
          if(matrix[row-1][col+1]==true) count++;
          if(matrix[row][col+1]==true) count++;
          if(matrix[row+1][col]==true) count++;
          if(matrix[row+1][col+1]==true) count++;
     }
     else if(row>0 && row<rows-1 && col==cols-1) {
         if(matrix[row-1][col]==true) count++;
          if(matrix[row-1][col-1]==true) count++;
          if(matrix[row][col-1]==true) count++;
          if(matrix[row+1][col]==true) count++;
          if(matrix[row+1][col-1]==true) count++;
     }
     else if(row==0 && col==0) {
          if(matrix[row][col+1]==true) count++;
          if(matrix[row+1][col]==true) count++;
          if(matrix[row+1][col+1]==true) count++;
     }
     else if(row==0 && col==cols-1) {
          if(matrix[row][col-1]==true) count++;
          if(matrix[row+1][col]==true) count++;
          if(matrix[row+1][col-1]==true) count++;}
     else if(row==rows-1 && col==0) {
          if(matrix[row-1][col]==true) count++;
          if(matrix[row-1][col+1]==true) count++;
          if(matrix[row][col+1]==true) count++;
     }
     else if(row==rows-1 && col==cols-1){
          if(matrix[row-1][col]==true) count++;
          if(matrix[row-1][col-1]==true) count++;
          if(matrix[row][col-1]==true) count++;
     }
    return count;}

         //Εφαρμόζει τους κανόνες για μετάβαση στην επόμενη γενιά   
        public void NextGeneration() {
    boolean[][] newMatrix = new boolean[rows][cols];
    
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            int n = Neighbors(i, j);
            // Αν το κελί είναι ζωντανό
            if (matrix[i][j]) {
                if (n < 2 || n > 3) {
                    newMatrix[i][j] = false;  
                } else {
                    newMatrix[i][j] = true;   
                }
            } 
            // Αν το κελί είναι νεκρό
            else {
                if (n == 3) {
                    newMatrix[i][j] = true;   
                }
            }
        }
    }
    // Ενημέρωση του πίνακα matrix
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            matrix[i][j] = newMatrix[i][j];
        }
    }
}

    public boolean[][] getGrid() {
        return matrix;
}
public void reset() {
    //επιστρέφει τον πίνακα στην αρχική κατάσταση με νέες συνθήκες
  boolean[][] newmatrix = FirstGeneration();
  matrix= newmatrix;
}}


    

