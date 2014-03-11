package nep.collection;

public abstract class ListElement<T> {
    private T value;

    public ListElement() {}

    public ListElement(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
