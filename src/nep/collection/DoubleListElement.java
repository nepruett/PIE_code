package nep.collection;

public class DoubleListElement<T> extends ListElement<T> {

    private DoubleListElement<T> next;
    private DoubleListElement<T> previous;

    public DoubleListElement() {
        super();
    }

    public DoubleListElement(T value) {
        super(value);
    }

    public void setNext(DoubleListElement<T> next) {
        this.next = next;
    }

    public DoubleListElement<T> getNext() {
        return next;
    }

    public void setPrevious(DoubleListElement<T> previous) {
        this.previous = previous;
    }

    public DoubleListElement<T> getPrevious() {
        return previous;
    }
}
