package net.ddns.wakhsavior.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Создать простейшее окно управления сервером (по сути, любым), содержащее две кнопки
(JButton) – запустить сервер и остановить сервер. Кнопки должны просто логировать нажатие
(имитировать запуск и остановку сервера, соответственно) и выставлять внутри интерфейса
соответствующее булево isServerWorking.
 */

public class ServerWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 340;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_POS_X = 300;
    private static final int WINDOW_POS_Y = 100;

    private final JTextField loginField = new JTextField("");
    JLabel lblLogin = new JLabel("Login:");
    JLabel lblPassword = new JLabel("Password:");
    JLabel lblIP = new JLabel("IP:");
    JLabel lblPort = new JLabel("Port:");

    ServerWindow() {
        setTitle("CONNECT TO SERVER");
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel grid = new JPanel(new GridLayout(5, 2));
        grid.add(lblLogin);
        grid.add(loginField);
        grid.add(lblPassword);
        JTextField passwordField = new JPasswordField("");
        grid.add(passwordField);
        grid.add(lblIP);
        JTextField serverField = new JTextField("");
        grid.add(serverField);
        grid.add(lblPort);
        JTextField portField = new JTextField("");
        grid.add(portField);
        JButton buttonExit = new JButton("Exit");
        grid.add(buttonExit);
        ActionListener actionListener = new TestActionListener();
        buttonExit.addActionListener(actionListener);
        JButton buttonConnect = new JButton("Connect");
        grid.add(buttonConnect);

        setLayout(new GridLayout(1, 1));
        add(grid);
        buttonConnect.addActionListener(e -> {
            String login = loginField.getText().trim();
            new ChatClient(login);
        });

        setVisible(true);
    }

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}