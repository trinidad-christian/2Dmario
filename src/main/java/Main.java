import jade.Window;

public class Main {
    public static void main(String[] args) {
        //Windows is a class which was imported and .get is ran from the Window class which-
        //-returns the one-and-only instance of Windows which is called the "Singleton Pattern"
        Window window = Window.get();
        window.run();
    }
}
