package net.ddns.wakhsavior.server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server implements ServerListener {
    boolean isServerWorking;
    private Listener listener;

    public Server(Listener listener) {
        this.listener = listener;
        this.isServerWorking = false;
    }

    public void start() {
        String msg = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss")) + " " + "\n";
        if (!isServerWorking) {
            isServerWorking = true;
            listener.messageRes("Server status: " + isServerWorking);    
            Utils.saveMessageToFile(" " + msg + "Server status: " + isServerWorking);
        } else {
            listener.messageRes("Server is already running");
            Utils.saveMessageToFile(" " + msg + "Server is already running");
        }
    }

    public void stop() {
        String msg = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss")) + " " + "\n";
        if (isServerWorking) {
            isServerWorking = false;
            listener.messageRes("Server status: " + isServerWorking);
            Utils.saveMessageToFile(" " + msg + "Server status: " + isServerWorking);
        } else {
            listener.messageRes("Server is not running");
            Utils.saveMessageToFile(" " + msg + "Server is not running");
        }
    }

    @Override
    public void serverListener(boolean status) {

        if (status) {
            stop();
        } else {
            start();
        }
    }
}