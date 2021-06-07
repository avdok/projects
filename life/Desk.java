import java.util.Random;

public class Desk implements Constants {

    private boolean[][] field;
    private int gen;

    Desk() {

        field = new boolean[size][size];
        gen = 0;
    }

    public String getInfo() {

        return "size of desk is " + size + " gen " + gen;

    }

    public int getGen() {
        return gen;
    }

    public void setRandomField() {
 
         Random randomno = new Random();

         for (int i=0; i < field.length; i++) {
             for (int j=0; j < field[i].length; j++) {
                 field[i][j] = randomno.nextBoolean();
             }
         }
    }

    public void printField() {

         for (int i=0; i < field.length; i++) {
             for (int j=0; j < field[i].length; j++) {
                 System.out.print((field[i][j]) ? "* " : "  ");
             }
             System.out.println();
         }
    }

    private int getNeighbour(int i, int j) {
        //
        int res = 0;
        
        for (int d = -1; d < 2; d++) {
            for (int k = -1; k < 2; k++) {
                if ( (d == 0) & (k == 0) ) {
                    continue;
                }
                //System.out.println("for i " + i + " j " + j);
                //System.out.println("d = " + d + " k = " + k);
                if  (sellIsOkAndTrue(i + d,j + k)) {
                    res++;
                }
            }
        }
        
        return res;
        
    }

    private boolean sellIsOkAndTrue(int i, int j) {
    
        if ( (i >= 0 & i < field.length) && ( j >= 0 & j < field[i].length) ) {
            // индексы не выходят за границы поля. возвращаем значение клетки
            return field[i][j];
        } else {
            // индексы за границей, считаем что клетка не живая
            return false;
        }
    }

    public Desk getNewGeneration() {

        Desk newdesk = new Desk();
        int neighbours = 0;

        for (int i=0; i < field.length; i++) {
             for (int j=0; j < field[i].length; j++) {
                 neighbours = getNeighbour(i, j);
                 
                 if (this.field[i][j]) {
                     //если клетка живая
                     if (neighbours == 2 || neighbours == 3) {
                         //и соседей 2 или 3, то клетка продолжает жить 
                         newdesk.field[i][j] = true;
                     } else {
                         //иначе она умирает от одиночества или перенаселения
                         newdesk.field[i][j] = false;
                     }
                 } else {
                     //если клетка не живая
                     if (neighbours == 3) {
                         //и 3, то клетка становится живой 
                         newdesk.field[i][j] = true;
                     } else {
                         //иначе она остается не живой
                         newdesk.field[i][j] = false;
                     }
                     
                 }

             }
         }
         newdesk.gen = this.gen + 1;
         return newdesk;
    }
}
