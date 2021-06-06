public class Life {

    public static void main(String args[]) {

        Desk desk = new Desk();
        Desk desk1;

        System.out.println("New life with " + desk.getInfo());
        desk.setRandomField();
        desk.printField();

        desk1 = desk.getNewGeneration();
        System.out.println("Gen " + desk1.getGen());
        desk1.printField();

    }
}
