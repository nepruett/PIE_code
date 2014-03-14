package nep.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SingleListTest {

    @Test
    public void testBuildEmpty() {
        SingleListElement<Integer> head = SingleListOperations.buildList();
        assertNull(head);
    }

    @Test
    public void testBuildOne() {
        SingleListElement<String> head = SingleListOperations.buildList("A");
        assertNotNull(head);
        assertEquals(head.getValue(), "A");
        assertNull(head.getNext());
    }

    @Test
    public void testBuildMany() {
        SingleListElement<String> head = SingleListOperations.buildList("A", "B", "C", "D", "E");
        assertNotNull(head);
        assertEquals(head.getValue(), "A");
        assertEquals(head.getNext().getValue(), "B");
        assertEquals(head.getNext().getNext().getValue(), "C");
        assertEquals(head.getNext().getNext().getNext().getValue(), "D");
        assertEquals(head.getNext().getNext().getNext().getNext().getValue(), "E");
        assertNull(head.getNext().getNext().getNext().getNext().getNext());
    }

    @Test
    public void testBuildManyWithNulls() {
        SingleListElement<String> head = SingleListOperations.buildList("A", "B", null, "D", null);
        assertNotNull(head);
        assertEquals(head.getValue(), "A");
        assertEquals(head.getNext().getValue(), "B");
        assertNull(head.getNext().getNext().getValue());
        assertEquals(head.getNext().getNext().getNext().getValue(), "D");
        assertNull(head.getNext().getNext().getNext().getNext().getValue());
        assertNull(head.getNext().getNext().getNext().getNext().getNext());
    }

    @Test
    public void testInsertInFrontEmpty() {
        SingleListElement<Integer> head = null;
        head = SingleListOperations.insertAtFront(head, 3);
        assertEquals(head.getValue(), Integer.valueOf(3));
        assertNull(head.getNext());
    }

    @Test
    public void testInsertInFrontOne() {
        SingleListElement<Integer> head = SingleListOperations.buildList(1);
        head = SingleListOperations.insertAtFront(head, 3);
        assertEquals(head.getValue(), Integer.valueOf(3));
        assertEquals(head.getNext().getValue(), Integer.valueOf(1));
        assertNull(head.getNext().getNext());
    }

    @Test
    public void testInsertInFrontMany() {
        SingleListElement<String> head = SingleListOperations.buildList("B", "C", "D");
        head = SingleListOperations.insertAtFront(head, "A");
        assertNotNull(head);
        assertEquals(head.getValue(), "A");
        assertEquals(head.getNext().getValue(), "B");
        assertEquals(head.getNext().getNext().getValue(), "C");
        assertEquals(head.getNext().getNext().getNext().getValue(), "D");
        assertNull(head.getNext().getNext().getNext().getNext());
    }

    @Test
    public void testFindEmpty() {
        SingleListElement<String> head = null;
        assertNull(SingleListOperations.find(head, "NONEXISTANT"));
    }

    @Test
    public void testFindOne() {
        SingleListElement<String> head = SingleListOperations.buildList("A");
        assertNull(SingleListOperations.find(head, "NONEXISTANT"));
        SingleListElement<String> found = SingleListOperations.find(head, "A");
        assertEquals(head, found);
    }

    @Test
    public void testFindMany() {
        SingleListElement<String> head = SingleListOperations.buildList("A", "B", "C");
        assertNull(SingleListOperations.find(head, "NONEXISTANT"));
        SingleListElement<String> a = SingleListOperations.find(head, "A");
        assertEquals(head, a);
        SingleListElement<String> b = SingleListOperations.find(head, "B");
        assertEquals(head.getNext(), b);
        SingleListElement<String> c = SingleListOperations.find(head, "C");
        assertEquals(head.getNext().getNext(), c);
    }

    @Test
    public void testPrint() {
        assertThat(SingleListOperations.print(SingleListOperations.buildList()), is(""));
        assertThat(SingleListOperations.print(SingleListOperations.buildList("A")), is("A"));
        assertThat(SingleListOperations.print(SingleListOperations.buildList("A", "B", "C")), is("A->B->C"));
    }

}
