/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class represents a Roach Colony
 */

public class RoachColony {

    /**name of the Roach Colony*/
    private String name;

    /**number of roaches in the Roach Colony*/
    private int population;

    /**growth rate of the Roach Colony*/
    private double growthRate;

    /**Explicit Constructor for the Roach Colony
     * @param name
     * @param population
     * @param growthRate
     */
    public RoachColony(String name, int population, double growthRate) {
        this.name = name;
        this.population = population;
        this.growthRate = growthRate;
    }

    /**return name of Roach Colony
     * @return name of Roach Colony
     */
    public String getName() {
        return name;
    }

    /**set name of Roach Colony
     * @param name new name of Roach Colony
     */
    public void setName(String name) {
        this.name = name;
    }

    /**return population of Roach Colony
     * @return population of Roach Colony
     */
    public int getPopulation() {
        return population;
    }

    /**set population of Roach Colony
     * @param population new population of Roach Colony
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**return growth rate of Roach Colony
     * @return growth rate of Roach Colony
     */
    public double getGrowthRate() {
        return growthRate;
    }

    /**set growth rate of Roach Colony
     * @param growthRate new growth rate of Roach Colony
     */
    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    /**Roach Colony throws a party
     * increases population by growth rate
     */
    public void throwParty() {
        this.population = (int) (population * growthRate);
    }

    /**Overriding toString function
     * @return description of colony
     */
    @Override
    public String toString() {
        return "Colony " + this.name + "\nPopulation: " + this.population + "\nGrowth Rate: " + this.growthRate;
    }
}
