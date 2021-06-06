public class Desk implements Constants {

    private boolean[][] field;

    Desk() {

        field = new boolean[size][size];

    }

    public String getInfo() {

        return "size of desk is " + size;

    }

    public void setRandomField() {
 
        for (int i=0; i < field.length; i++) {
            for (int j=0; j < field[i].length; j++) {
                field[i][j] = true;
            }
        }
    }

    public void printField() {

        for (int i=0; i < field.length; i++) {
            for (int j=0; j < field[i].length; j++) {
                System.out.print((field[i][j]) ? "1" : "0");
            }
            System.out.println();
        }


    }
}
