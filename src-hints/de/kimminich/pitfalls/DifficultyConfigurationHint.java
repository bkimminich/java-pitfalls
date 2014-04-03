package de.kimminich.pitfalls;

import org.junit.Test;

public class DifficultyConfigurationHint {

    DifficultyConfiguration config;

    @Test
    public void easy() {
        config = new DifficultyConfiguration(DifficultyConfiguration.Difficulty.EASY);
        System.out.println(config);
    }

    @Test
    public void normal() {
        config = new DifficultyConfiguration(DifficultyConfiguration.Difficulty.NORMAL);
        System.out.println(config);
    }

    @Test
    public void hard() {
        config = new DifficultyConfiguration(DifficultyConfiguration.Difficulty.HARD);
        System.out.println(config);
    }

    @Test
    public void extreme() {
        config = new DifficultyConfiguration(DifficultyConfiguration.Difficulty.EXTREME);
        System.out.println(config);
    }
}
