package lecon09.cards;

/**
 * BaseCard
 * @See BaseCardV4 dans le syllabus de POO
 * @author Nicolas Hendrikx
 */
public class BaseCard {
    private boolean visible = false;

    public BaseCard(boolean visible) {
        this.visible = visible;
    }

    public final void flip() {
        visible = !visible;
    }

    public final boolean isVisible() {
        return visible;
    }

    public String toString() {
        return String.format("BaseCard(visible: %b)", visible);
    }
}
