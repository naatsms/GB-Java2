/*
* @author Nikolay Gabaraev
* @version dated Nov 03, 2017
* @task 4
* @mark
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class J2Homework4 {
    public static void main(String[] args) {
        new MyWindow();
    }
}

class MyWindow extends JFrame {

    public MyWindow () {

        setTitle("Simple Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,400,400);

        JTextArea dialogue;
        JTextField message;

        dialogue = new JTextArea();
        dialogue.setEditable(false);

        message = new JTextField();
        JScrollPane scrollBar = new JScrollPane(dialogue);
        JPanel mainpanel = new JPanel();
        JButton enter = new JButton("Enter");

        mainpanel.setLayout( new BoxLayout(mainpanel , BoxLayout.X_AXIS));
        mainpanel.add(message);
        mainpanel.add(enter);

        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, mainpanel);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogue.append("Man: " + message.getText()+ "\n");
                message.setText("");
                message.requestFocusInWindow();

            }
        });

        message.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogue.append("Man: " + message.getText()+ "\n");
                message.setText("");
                message.requestFocusInWindow();
            }
        });
        setVisible(true);
    }
}