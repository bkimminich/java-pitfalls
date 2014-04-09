package de.kimminich.pitfalls;

import javax.swing.*;
import java.awt.*;

public class DifficultyConfigurationFixed {

    private int monsterLevel;
    private int goldBonus;
    private ImageIcon icon;

    public DifficultyConfigurationFixed(Difficulty difficulty) {
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
            default: // Throwing an exception in the default case will make developers aware of missing case handling
                throw new IllegalArgumentException("Unexpected enum value: " + difficulty);
        }
    }

    public Image getImage() {
        return icon.getImage();
    }

    @Override
    public String toString() {
        return "DifficultyConfigurationFixed{" +
                "monsterLevel=" + monsterLevel +
                ", goldBonus=" + goldBonus +
                ", icon=" + icon +
                '}';
    }

    public static enum Difficulty {
        EASY, NORMAL, HARD, EXTREME // 4th enum value EXTREME has been added at a later point in time during development
    }

}
