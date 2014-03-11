package nep.collection;

public class DoubleChildListElement<T> extends ListElement<T> {
    private DoubleChildListElement<T> next;
    private DoubleChildListElement<T> previous;
    private DoubleChildListElement<T> child;
    
    public DoubleChildListElement() {
        super();
    }
    
    public DoubleChildListElement(T value) {
        super(value);
    }
    
    public DoubleChildListElement<T> getChild() {
        return this.child;
    }
    
    public DoubleChildListElement<T> setChild(DoubleChildListElement<T> child) {
        this.child = child;
        return child;
    }
    
    public DoubleChildListElement<T> setChild(T value) {
        DoubleChildListElement<T> elem = new DoubleChildListElement<T>(value);
        return setChild(elem);
    }
    
    public void removeChild() {
        this.child = null;
    }
    
    public DoubleChildListElement<T> getNext() {
        return this.next;
    }
    
    public DoubleChildListElement<T> setNext(DoubleChildListElement<T> next) {
        this.next = next;
        return next;
    }
    
    public DoubleChildListElement<T> setNext(T value) {
        DoubleChildListElement<T> elem = new DoubleChildListElement<T>(value);
        return setNext(elem);
    }
    
    public void removeNext() {
        this.next = null;
    }
    
    public DoubleChildListElement<T> getPrevious() {
        return this.previous;
    }
    
    public DoubleChildListElement<T> setPrevious(DoubleChildListElement<T> previous) {
        this.previous = previous;
        return previous;
    }
    
    public DoubleChildListElement<T> setPrevious(T value) {
        DoubleChildListElement<T> elem = new DoubleChildListElement<T>(value);
        return setPrevious(elem);
    }
    
    public void removePrevious() {
        this.previous = null;
    }
}
