package nep.collection;

public class SingleListElement<T> extends ListElement<T> {

    private SingleListElement<T> next;

    public SingleListElement() {
        super();
    }

    public SingleListElement(T value) {
        super(value);
    }

    public void setNext(SingleListElement<T> next) {
        this.next = next;
    }

    public SingleListElement<T> getNext() {
        return next;
    }
}
