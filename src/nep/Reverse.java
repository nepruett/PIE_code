package nep;

public class Reverse {
    public static String string(String str) {
        //checkNotNull(str);
        return String.valueOf(chars(str.toCharArray()));
    }
    
    public static char[] chars(char[] chars) {
        //checkNotNull(chars);
        // reverse in place algorithm
        for(int i = 0, j = chars.length - 1; i < chars.length / 2; I++, j-- ) {
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
        SingleListElement<T> prev = null;
        while(head != null) {
            temp = head.getNext();
            head.setNext(previous);
            previous = head;
            head = temp;
        }
        
        return previous;
    }
}
