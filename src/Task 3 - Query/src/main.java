public class main {
    public static void main(String[] args) {
        // HERE BE START
        connector DBase = connector.connection();
        Gui.start(DBase);
    }
}
