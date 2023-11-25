package net.ddns.wakhsavior.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {  

    public static void saveMessageToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.LOG_FILE, true))) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
