package thegame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main{
    private JFrame frame;

    public Main() {
        creatAndShow();
    }

    public void creatAndShow() {
        frame = new JFrame();
        frame.setTitle("The Game!!!");
        frame.setSize(1050,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("image/enemy/boss_enemy.jpg"));
        }
        catch (IOException e){
            System.out.println("NO found file");
        }
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Main();
    }
}