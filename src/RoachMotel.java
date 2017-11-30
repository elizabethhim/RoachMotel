/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class represents a Roach Motel
            and uses the Singleton Design Pattern to limit motel creation
 */

//TODO: add methods, if necessary

public class RoachMotel {
    /**an instance of Roach Motel*/
    private static RoachMotel motel;

    /**room capacity of Roach Motel*/
    private int capacity;

    /**vacancy condition of Roach Motel*/
    private boolean vacancy;

    /**private constructor of a motel to prevent new motel creation
     * initial capacity set at five rooms
     * initial vacancy set at true*/
    private RoachMotel() {
        capacity = 5;
        vacancy = true;
    }

    /**creates new instances of a Roach Motel
     * @return an instance of a Roach Motel
     */
    public static synchronized RoachMotel getMotel() {
        if (motel == null) {
            motel = new RoachMotel();
        }
        return motel;
    }

    /**return capacity of Roach Motel
     * @return capacity of Roach Motel
     */
    public int getCapacity() {
        return capacity;
    }

    /**set capacity of Roach Motel
     * @param capacity new capacity of Roach Motel
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**return vacancy condition of Roach Motel
     * @return vacancy condition of Roach Motel
     */
    public boolean getVacancy() {
        return vacancy;
    }

    /**set vacancy condition of Roach Motel
     * @param vacancy new vacandy condition of Roach Motel
     */
    public void setVacancy(boolean vacancy) {
        this.vacancy = vacancy;
    }
}
