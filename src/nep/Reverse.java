package nep;

import nep.collection.SingleListElement;

public class Reverse {
    public static String string(String str) {
        return String.valueOf(chars(str.toCharArray()));
    }
    
    public static char[] chars(char[] chars) {
        // reverse in place algorithm
        for(int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j-- ) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }
        return chars;
    }
    
    // Any way to make even more generic than SingleListElement<T>?
    // Tried <T, E extends SingleListElement<T>> but got incompatible types error...
    public static <T> SingleListElement<T> singleList(SingleListElement<T> head) {
        SingleListElement<T> temp = null;
        SingleListElement<T> previous = null;
        while(head != null) {
            temp = head.getNext();
            head.setNext(previous);
            previous = head;
            head = temp;
        }
        return previous;
    }
}
