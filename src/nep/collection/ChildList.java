package nep.collection;

import com.google.common.base.Joiner;
import com.google.common.base.Lists;

import java.util.List;

public class ChildList<T> {
    private DoubleChildListElement<T> head;
    private DoubleChildListElement<T> tail;
    
    public DoubleChildListElement<T> setHead(DoubleChildListElement<T> elem) {
        while(elem != null && elem.getPrevious() != null) {
            elem = elem.getPrevious();
        }
        head = elem;
        if( tail == null ) {
            setTail(elem);
        }
        return head;
    }
    
    public DoubleChildListElement<T> setHead(T value) {
        DoubleChildListElement<T> elem = new DoubleChildListElement<T>(value);
        return setHead(elem);
    }
    
    public DoubleChildListElement<T> getHead() {
        DoubleChildListElement<T> elem = head;
        while(elem != null && elem.getPrevious() != null) {
            elem = elem.getPrevious();
        }
        head = elem;
        return head;
    }
    
    public DoubleChildListElement<T> setTail(DoubleChildListElement<T> elem) {
        while(elem != null && elem.getNext() != null) {
            elem = elem.getNext();
        }
        tail = elem;
        if( head == null ) {
            setHead(elem);
        }
        return tail;
    }
    
    public DoubleChildListElement<T> setTail(T value) {
        DoubleChildListElement<T> elem = new DoubleChildListElement<T>(value);
        return setTail(elem);
    }
    
    public DoubleChildListElement<T> getTail() {
        DoubleChildListElement<T> elem = tail;
        while(elem != null && elem.getNext() != null) {
            elem = elem.getNext();
        }
        tail = elem;
        return tail;
    }
    
    private int buildLevels(List<StringBuilder> levels, DoubleChildListElement<T> elem, int level, int spaces) {
        if( elem == null ) return 0;
        
        StringBuilder currentSB;
        if( level >= levels.size()) {
            currentSB = new StringBuilder();
            levels.add(currentSB);
        } else {
            currentSB = levels.get(level);
        }
        spaces = spaces - currentSB.length();
        for( int i = 0; i < spaces; i++) {
            currentSB.append(' ');
        }
        while( elem != null )
            currentSB.append(elem.getValue());
            spaces = buildLevels(levels, elem.getChild(), level + 1, curentSB.length());
            spaces = spaces - currentSB.length();
            for(int i = 0; i < spaces; i++) {
                currentSB.append(' ');
            }
            if( elem.getNext() != null ) {
                currentSB.append(' ');
            }
            elem = elem.getNext();
        }
        return currentSB.length();
    }
    
    @Override
    public String toString() {
        List<StringBuilder> levels = Lists.newArrayList();
        buildLevels(levels, head, 0, 0);
        return Joiner.on("\n").join(levels);
    }
    
    public void flatten() {
        DoubleChildListElement<T> elem = head;
        while( elem != null && elem.getNext() != null ) {
            if( elem.getChild() != null ) {
                getTail().setNext(elem.getChild());
                elem.removeChild();
            }
            elem = elem.getNext();
        }
    }
}
