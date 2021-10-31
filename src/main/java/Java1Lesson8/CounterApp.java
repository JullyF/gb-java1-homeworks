package Java1Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;


public class CounterApp extends JFrame {
    private int value;
    private int step;
    private static final int DEFAULT_STEP = 1;
    private JFormattedTextField field;
    private Font font;
    private Font font2;
    private Font font3;

    public CounterApp(int initialValue) {
        setBounds(500, 500, 600, 220);
        setTitle("Счётчик");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        font = new Font("Bookman Old Style", Font.BOLD, 50);
        font2 = new Font("Bookman Old Style", Font.PLAIN, 20);
        font3 = new Font("Bookman Old Style", Font.PLAIN, 12);

        getContentPane().add(createPanel(), BorderLayout.NORTH);

        JLabel counterValueView = new JLabel();
        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValueView, BorderLayout.CENTER);

        value = initialValue;
        counterValueView.setText(String.valueOf(value));


        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        add(decrementButton, BorderLayout.WEST);

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        add(incrementButton, BorderLayout.EAST);

        JButton resetButton = new JButton("СБРОС");
        resetButton.setFont(font2);
        add(resetButton, BorderLayout.SOUTH);

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                step = Integer.parseInt(field.getText());
                field.setBackground(Color.orange);
            }
        });

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value -= step;
                counterValueView.setText(String.valueOf(value));
            }
        });

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value += step;
                counterValueView.setText(String.valueOf(value));
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value = 0;
                field.setValue(DEFAULT_STEP);
                field.setBackground(Color.white);
                counterValueView.setText(String.valueOf(value));
            }
        });

        setVisible(true);
    }


    public static void main(String[] args) {
        CounterApp counterApp = new CounterApp(0);
    }

    public JPanel createPanel() {
        JLabel message = new JLabel();
        // Почему не выравнивает текст по центру при изменении параметров окна?
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setText("<html><p>Введите числовое значение шага счётчика и нажмите Enter</p><br></html>");
        message.setFont(font3);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(message, BorderLayout.NORTH);
        panel.setPreferredSize(new Dimension(600, 80));


        NumberFormat number = NumberFormat.getIntegerInstance();
        field = new JFormattedTextField(number);
        field.setValue(DEFAULT_STEP);
        field.setFont(font2);
        field.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(field, BorderLayout.CENTER);
        return panel;
    }
}
