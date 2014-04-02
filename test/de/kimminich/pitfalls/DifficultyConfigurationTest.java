package de.kimminich.pitfalls;

import org.junit.Test;

public class DifficultyConfigurationTest {

    DifficultyConfiguration config;

    @Test
    public void testEasy() {
        config = new DifficultyConfiguration(DifficultyConfiguration.Difficulty.EASY);
        System.out.println(config);
    }

    @Test
    public void testNormal() {
        config = new DifficultyConfiguration(DifficultyConfiguration.Difficulty.NORMAL);
        System.out.println(config);
    }

    @Test
    public void testHard() {
        config = new DifficultyConfiguration(DifficultyConfiguration.Difficulty.HARD);
        System.out.println(config);
    }

    @Test
    public void testExtreme() {
        config = new DifficultyConfiguration(DifficultyConfiguration.Difficulty.EXTREME);
        System.out.println(config);
    }
}
