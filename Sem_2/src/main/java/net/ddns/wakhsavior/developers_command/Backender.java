package net.ddns.wakhsavior.developers_command;

public class Backender extends Developer implements BackendActions {
    @Override
    public void back() {
        System.out.println("Backender working");
    }
}