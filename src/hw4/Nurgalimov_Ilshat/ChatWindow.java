import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import javax.swing.*;

/**
 * Java 2. Lesson 4. My homework.
 *
 * @author Ilshat Nurgalimov.
 * @version dated 05.11.2017.
 * @task 4
 * @mark
 */

class ChatWindow extends JFrame implements ActionListener {

/*
 * 1. Создать окно для клиентской части чата: большое текстовое поле для отображения переписки в центре окна.
 * Однострочное текстовое поле для ввода сообщений и кнопка для отсылки сообщений на нижней панели. Сообщение должно
 * отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter. При «отсылке» сообщение перекидывается из
 * нижнего поля в центральное.
 * 2. * Задание повышенной сложности - все сообщения должны логгироваться (добавляться) в текстовый файл.
 */

    final String TITLE_OF_PROGRAM = "Chat window";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;
    final String BTN_ENTER = "Enter";
    final String BTN_NEW_CHAT = "New chat";
    private String logFileName;
    private JButton enter;
    private JButton clear;
    private File file;
    private Date date;
    private FileWriter writer;
    private FileReader reader;
    JTextArea dialogue; // area for dialog
    JTextField message; // field for entering messages

    public static void main(String[] args) {
        new ChatWindow();
    }

    ChatWindow() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);
        date = new Date();
        logFileName = convertedLogFileName(date.toString()) + ".txt";
        file = new File(logFileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // area for dialog
        dialogue = new JTextArea();
        dialogue.setEditable(false);
        JScrollPane scrollBar = new JScrollPane(dialogue);
        // panel for checkbox, message field and button
        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        message = new JTextField();
        message.addActionListener(this);
        enter = new JButton(BTN_ENTER);
        clear = new JButton(BTN_NEW_CHAT);
        enter.addActionListener(this);
        clear.addActionListener(this);
        // adding all elements to the window
        bp.add(message);
        bp.add(enter);
        bp.add(clear);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, bp);
        setVisible(true);
    }

    /**
     * Listener of events from message field and enter button
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == enter || event.getSource() == message) {
            if (message.getText().trim().length() > 0) {
                try (FileWriter writer = new FileWriter(logFileName, true)){
                    writer.write(message.getText() + "\n");
                } catch(Exception e) { }
                finally {
                    try(FileReader reader = new FileReader(logFileName)) {
                        StringBuffer temp = new StringBuffer("");
                        int c;
                        while((c = reader.read()) != -1) {
                            temp.append((char) c);
                        }
                        dialogue.setText(temp.toString());
                    } catch(Exception e) { }
                }
            }
            message.setText("");
            message.requestFocusInWindow();
        } else if(event.getSource() == clear) {
            new ChatWindow();
        }
    }
    public String convertedLogFileName(String name) {
        String temp1 = name.replace(" ", "");
        String temp2 = temp1.replace(":", "");
        return temp2;
    }
}