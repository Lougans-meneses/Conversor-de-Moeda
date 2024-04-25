package teste;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        var menu = new Menu();
        menu.initializeApi();
        menu.init();
    }
}