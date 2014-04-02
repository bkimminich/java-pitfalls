package de.kimminich.pitfalls;

import javax.swing.*;
import java.awt.*;

public class DifficultyConfiguration {

    private int monsterLevel;
    private int goldBonus;
    private ImageIcon icon;

    public DifficultyConfiguration(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                monsterLevel = 1;
                goldBonus = 0;
                icon = new ImageIcon("/easy.jpg");
                break;
            case NORMAL:
                monsterLevel = 2;
                goldBonus = 0;
                icon = new ImageIcon("/normal.jpg");
                break;
            case HARD:
                monsterLevel = 3;
                goldBonus = 75;
                icon = new ImageIcon("/hard.jpg");
                break;
        }
    }

    public Image getImage() {
        return icon.getImage();
    }

    @Override
    public String toString() {
        return "DifficultyConfiguration{" +
                "monsterLevel=" + monsterLevel +
                ", goldBonus=" + goldBonus +
                ", icon=" + icon +
                '}';
    }

    public static enum Difficulty {
        EASY, NORMAL, HARD, EXTREME
    }

}
