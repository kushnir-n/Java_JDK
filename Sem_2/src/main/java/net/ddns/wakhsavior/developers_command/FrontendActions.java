package net.ddns.wakhsavior.developers_command;

public interface FrontendActions {
    void front();

    default void cofee() {
        System.out.println("Drink");
    };

    default void developGUI() {
        System.out.println("Writing");;
    }
}