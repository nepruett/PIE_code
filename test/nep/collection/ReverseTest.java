package nep.collection;

import nep.Reverse;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReverseTest {

    @Test
    public void testReverseString() {
        assertThat(Reverse.string(""), is(""));
        assertThat(Reverse.string("abc"), is("cba"));
        assertThat(Reverse.string("Cow"), is("woC"));
    }

    @Test(expected = NullPointerException.class)
    public void testReverseStringNull() {
        Reverse.string(null);
    }

    @Test
    public void testReverseChars() {
        char[] original = new char[] {};
        String originalRefString = original.toString();
        char[] reverse = Reverse.chars(original);
        assertThat(String.valueOf(reverse), is(""));
        assertThat(reverse.toString(), is(originalRefString));
        original = new char[] {'a', 'b', 'c'};
        originalRefString = original.toString();
        reverse = Reverse.chars(original);
        assertThat(String.valueOf(reverse), is("cba"));
        assertThat(reverse.toString(), is(originalRefString));
        original = new char[] {'D', 'o', 'g'};
        originalRefString = original.toString();
        reverse = Reverse.chars(original);
        assertThat(String.valueOf(reverse), is("goD"));
        assertThat(reverse.toString(), is(originalRefString));
    }

    @Test(expected = NullPointerException.class)
    public void testReverseCharsNull() {
        Reverse.chars(null);
    }

    @Test
    public void testReverseSingleLinkList() {
        assertThat(SingleListOperations.print(Reverse.singleList(SingleListOperations.buildList())), is(""));
        assertThat(SingleListOperations.print(Reverse.singleList(SingleListOperations.buildList("A"))), is("A"));
        assertThat(SingleListOperations.print(Reverse.singleList(SingleListOperations.buildList("A", "B"))), is("B->A"));
        assertThat(SingleListOperations.print(Reverse.singleList(SingleListOperations.buildList("A", "B", "C"))), is("C->B->A"));
    }

}
