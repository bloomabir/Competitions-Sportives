package main.competitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompetitorTest {
    private Competitor c;

    @BeforeEach
    public void init() {
        c = new Competitor("abir");
    }

    @Test
    public void testGetName() {
        assertEquals(c.getName(), "abir");
    }

    @Test
    public void testSetName() {
        c.setName("théo");
        assertEquals(c.getName(), "théo");
    }
}
