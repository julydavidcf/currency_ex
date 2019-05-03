package main;

import java.util.Observable;
import java.util.Observer;

public class MessagePrint implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Newest rate printed!");
    }
}
