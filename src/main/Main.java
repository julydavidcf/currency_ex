package main;

import java.io.IOException;

public class Main {
Data d = new Data();
MessagePrint message = new MessagePrint();

    public Main(){
        try {
            d.addObserver(message);
            d.print();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Main nyr = new Main();
    }
}
