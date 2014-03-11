package nep.collection;

public class SingleListOperations {

    @SafeVarargs
    public static <T> SingleListElement<T> buildList(T... values) {
        SingleListElement<T> head = null;
        SingleListElement<T> elem = null;
        for(T value : values) {
            SingleListElement<T> newElem = new SingleListElement<>(value);
            if(head == null) {
                head = newElem;
                elem = head;
            } else {
                elem.setNext(newElem);
                elem = newElem;
            }
        }
        return head;
    }

    public static <T> SingleListElement<T> insertAtFront(SingleListElement<T> head, T value) {
        SingleListElement<T> newHead = new SingleListElement<>(value);
        newHead.setNext(head);
        return newHead;
    }

    public static <T> SingleListElement<T> find(SingleListElement<T> head, T value) {
        SingleListElement<T> elem = head;
        while(elem != null && !value.equals(elem.getValue())) {
            elem = elem.getNext();
        }
        return elem;
    }
}
