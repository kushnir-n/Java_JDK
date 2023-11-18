package net.ddns.wakhsavior.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля,
IP-адреса сервера, порта подключения к серверу, область ввода сообщений, JTextArea
область просмотра сообщений чата и JButton подключения к серверу и отправки сообщения в чат.
Желательно сразу сгруппировать компоненты, относящиеся к серверу сгруппировать на JPanel
сверху экрана, а компоненты, относящиеся к отправке сообщения – на JPanel снизу

Отправлять сообщения из текстового поля сообщения в лог по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;
Продублировать импровизированный лог (историю) чата в файле;
При запуске клиента чата заполнять поле истории из файла, если он существует. 
Обратите внимание, что чаще всего история сообщений хранится на сервере и заполнение истории чата лучше делать при соединении с сервером, а не при открытии окна клиента.
 */

public class ChatClient extends JFrame {
    private static final int HEIGHT = 340;
    private static final int WIDTH = 350;
    private static final int WINDOW_POS_X = 650;
    private static final int WINDOW_POS_Y = 100;

    private static final String LOG_FILE = "chat_log.txt";
    private final JTextArea textOutput = new JTextArea("");
    private final JTextField textInput = new JTextField();

    ChatClient(String login) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("CHAT CLIENT");
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WIDTH, HEIGHT);

        textOutput.setEditable(false);
        textOutput.setBackground(Color.GRAY);

        loadChatHistory();

        JPanel grid = new JPanel(new GridLayout(4, 1));
        grid.add(textOutput);
        JLabel label = new JLabel("                                    Please, input message ");
        grid.add(label);
        grid.add(textInput);
        JButton buttonConnect = new JButton("Send");
        grid.add(buttonConnect);

        buttonConnect.addActionListener(e -> sendMessage(login));

        textInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage(login);
                }
            }
        });

        add(grid);
        setVisible(true);
    }

    private void sendMessage(String login) {
        String message = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss")) + " " + login
                + " : " + textInput.getText() + "\n";
        textOutput.append(message);
        saveMessageToFile(message);
        textInput.setText("");
    }

    private void saveMessageToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadChatHistory() {
        File file = new File(LOG_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    textOutput.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}