package main.competitor;


/**
 * Represents a Competitor
 *
 * @author Théo Crespo and Abir Bezzazi
 * @version 1.0
 */
public class Competitor {

    private String name;

    /**
     * The constructor of the class.
     *
     * @param name name of the competitor
     */
    public Competitor(String name) {
        this.name = name;
    }

    /**
     * Gets the competitor’s first name.
     *
     * @return A string representing the competitor’s first name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the competitor’s first name.
     *
     * @param name A String containing the competitor’s first name.
     */
    public void setName(String name) {
        this.name = name;
    }
}
