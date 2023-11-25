package net.ddns.wakhsavior.server;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/*
Создать простейшее окно управления сервером (по сути, любым), содержащее две кнопки
(JButton) – запустить сервер и остановить сервер. Кнопки должны просто логировать нажатие
(имитировать запуск и остановку сервера, соответственно) и выставлять внутри интерфейса
соответствующее булево isServerWorking.
 */

public class ServerWindow extends JFrame implements Listener {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POS_X = 300;
    private static final int WINDOW_POS_Y = 100;

    private final JTextField loginField = new JTextField("");
    JLabel lblLogin = new JLabel("Login:");
    JLabel lblPassword = new JLabel("Password:");
    JLabel lblIP = new JLabel("IP:");
    JLabel lblPort = new JLabel("Port:");
    JButton buttonStart = new JButton("Start Server");
    JButton buttonStop = new JButton("Stop Server");
    JButton buttonExit = new JButton("Exit");
    ServerListener server = new Server(this);
    ArrayList <String> log = new ArrayList<>();

    ServerWindow() {
        setTitle("CONNECT TO SERVER");
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel grid = new JPanel(new GridLayout(6, 2));
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
        JButton buttonConnect = new JButton("Connect and start chat");
        grid.add(buttonConnect);
        buttonStart.addActionListener(actionListener);
        JButton buttonStart = new JButton("Only connect to server");
        grid.add(buttonStart);
        buttonStop.addActionListener(actionListener);
        JButton buttonStop = new JButton("Stop connect to server");
        grid.add(buttonStop);


        setLayout(new GridLayout(1, 1));
        add(grid);

        buttonConnect.addActionListener(e -> {
            String login = loginField.getText().trim();
            new ChatClient(login);
        });

        setVisible(true);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.serverListener(false); 
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.serverListener(true);
            }
        });
  
    }

    @Override
    public void messageRes(String text) {
        System.out.println(text);
    }

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}