package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;


public class Main {

    public static class Popup  extends Applet implements ActionListener {
        String colorNames[] = {"Gray", "Red", "Blue", "White"};
        Color colors[] = {Color.gray, Color.red, Color.blue, Color.white};
        PopupMenu pm;

        public void init() {
            setBackground(Color.gray);
            pm = new PopupMenu("Фоновый цвет");
            MenuItem colorName;
            for (int i = 0; i < colorNames.length; i++) {
                colorName = new MenuItem(colorNames[i]);
                pm.add(colorName);
                colorName.addActionListener(this);
                pm.addSeparator();
            }
            add(pm);
            MouseListener ml = new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    pm.show(e.getComponent(), e.getX(), e.getY());
                }
            };
            addMouseListener(ml);
        }

        public void actionPerformed(ActionEvent e) {
            setBackground(getColor(e.getActionCommand()));
        }

        private Color getColor(String name) {
            for (int i = 0; i < colorNames.length; i++) {
                if (colorNames[i].equals(name))
                    return colors[i];
            }
            return Color.white;
        }
    }

    public static class DrawCanvas extends Canvas {
        private int lastX, lastY;
        private int ex, ey;
        private boolean clear = false;

        public DrawCanvas() {
            super();
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    lastX = e.getX();
                    lastY = e.getY();
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    ex = e.getX();
                    ey = e.getY();
                    repaint();
                }
            });

            addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == ' ') {
                        clear = true;
                        repaint();
                    }
                }
            });
        }

        public void update(Graphics g) {
            if (clear) {
                g.clearRect(0, 0, getWidth(), getHeight());
                clear = false;
            } else {
                g.drawLine(lastX, lastY, ex, ey);
                lastX = ex;
                lastY = ey;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("+ --------- Задание 1 --------- +");

        final Frame f = new Frame("Draw");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        f.setSize(400, 300);
        final Canvas c = new DrawCanvas();
        f.add(c);
        f.setVisible(true);

        final Frame fr = new Frame("Flaw");
        fr.setSize(400, 300);
        fr.setLayout(new FlowLayout(FlowLayout.LEFT));
        fr.add(new Label("Test"));
        fr.add(new Button("Long string"));
        fr.add(new TextArea(2, 20));
        fr.add(new Button("short"));
        fr.add(new TextArea(4, 20));
        fr.add(new Label("Long-long text"));
        fr.setVisible(true);

        System.out.println("\n+ --------- Задание 2 --------- +");

        JFrame frame = new JFrame ("Пример");
        int width = 800;
        int height = 300;
        Popup appl = new     Popup();
        appl.init();
        frame.getContentPane().add(appl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.setVisible(true);

    }
}