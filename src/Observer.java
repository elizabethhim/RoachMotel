/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this interface represents an Observer,
            which is notified upon updates to the waitlist
 */

public interface Observer {
    public void update();
    public void setSubject(Subject sub);
}
