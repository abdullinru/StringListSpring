package com.example.stringlistspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.stringlistspring.Constanty.*;
import static org.junit.jupiter.api.Assertions.*;

class StringArrayListTest {
    StringArrayList out = new StringArrayList(6);
    StringArrayList empty = new StringArrayList(6);
    String[] mas = {ZERO,FIRST,SECOND, THIRD, FORTH, FIFTH};

    @BeforeEach
    public void init() {
        out.add(ZERO);
        out.add(FIRST);
        out.add(SECOND);
        out.add(THIRD);
        out.add(FORTH);
        out.add(FIFTH);
    }

    @Test
    public void shouldReturnFirstWhenAddFirst() {
        String result = "first";
        assertEquals(result, out.add(FIRST));
    }
    @Test
    public void shouldReturnThrowWhenAddNull() {
        assertThrows(ElementNullException.class, () -> out.add(null));
    }
    @Test
    public void shouldReturnSecondWhenAddSecond() {
        String result = "second";
        assertEquals(result, out.add(0,SECOND));
    }
    @Test
    public void shouldReturnThrowWhenAddWrongeIndex() {
        assertThrows(IndexOutOfStorage.class, () -> out.add(-4,ZERO));
    }
    @Test
    public void shouldReturnThrowWhenAddWrongeIndex2() {
        assertThrows(IndexOutOfStorage.class, () -> out.add(100,ZERO));
    }

    @Test
    public void shouldReturnSecondWhenSetSecond() {
        String result = "second";
        assertEquals(result, out.set(0,SECOND));
    }
    @Test
    public void shouldReturnThrowWhenSetNull() {
        assertThrows(ElementNullException.class, () -> out.set(3,null));
    }
    @Test
    public void shouldReturnThrowWhenSetWrongeIndex() {
        assertThrows(IndexOutOfStorage.class, () -> out.set(-4,ZERO));
    }
    @Test
    public void shouldReturnThrowWhenSetWrongeIndex2() {
        assertThrows(IndexOutOfStorage.class, () -> out.set(100,ZERO));
    }


    @Test
    public void shouldReturnSecondWhenRemoveSecond() {
        String result = "second";
        assertEquals(result, out.remove(SECOND));
    }
    @Test
    public void shouldReturnThrowWhenRemoveNotFound() {
        assertThrows(ElementMissingInStorage.class, () -> out.remove("56556"));
    }
    @Test
    public void shouldReturnThrowWhenRemoveNull() {
        assertThrows(ElementNullException.class, () -> out.remove(null));
    }
    @Test
    public void shouldReturnSecondWhenRemoveSecond2() {
        String result = "second";
        assertEquals(result, out.remove(2));
    }

    @Test
    public void shouldReturnThrowWhenRemoveWrongeIndex() {
        assertThrows(IndexOutOfStorage.class, () -> out.remove(-4));
    }
    @Test
    public void shouldReturnThrowWhenRemoveWrongeIndex2() {
        assertThrows(IndexOutOfStorage.class, () -> out.remove(100));
    }


    @Test
    public void shouldReturnTrueWhenContainsFirst() {
        assertTrue(out.contains(FIRST));
    }
    @Test
    public void shouldReturnFalseWhenContainsNotFound() {
        assertFalse(out.contains(null));
    }


    @Test
    public void shouldReturn1WhenIndexOfFirst() {
        int result = 1;
        assertEquals(result, out.indexOf(FIRST));
    }
    @Test
    public void shouldReturn_1WhenIndexOfNotFound() {
        int result = -1;
        assertEquals(result, out.indexOf(null));
    }

    @Test
    public void shouldReturn4WhenLastIndexOfFirst() {
        out.add(4, FIRST);
        int result = 4;
        assertEquals(result, out.lastIndexOf(FIRST));
    }
    @Test
    public void shouldReturn_1WhenLastIndexOfNotFound() {
        int result = -1;
        assertEquals(result, out.lastIndexOf(null));
    }

    @Test
    public void shouldReturnForthWhenGetForth() {
        String result = FORTH;
        assertEquals(result, out.get(4));
    }
    @Test
    public void shouldReturnThrowWhenGetWrongeIndex() {
        assertThrows(IndexOutOfStorage.class, () -> out.get(-4));
    }
    @Test
    public void shouldReturnThrowWhenGetWrongeIndex2() {
        assertThrows(IndexOutOfStorage.class, () -> out.get(100));
    }

    @Test
    public void shouldReturnTrueWhenEqualsMas() {
        StringArrayList result = new StringArrayList(mas);
        assertTrue(out.equals(result));
    }
    @Test
    public void shouldReturnFalseWhenEqualsMas() {
        StringArrayList result = new StringArrayList(mas);
        result.remove(3);
        assertFalse(out.equals(result));
    }

    @Test
    public void shouldReturn6WhenSize() {
        int result = SIZE;
        assertEquals(result, out.size());
    }

    @Test
    public void shouldReturnTrueWhenIsEmpty() {
        assertTrue(empty.isEmpty());
    }
    @Test
    public void shouldReturnFalseWhenIsEmpty() {
        assertFalse(out.isEmpty());
    }

    @Test
    public void shouldReturnSize0WhenClear() {
        out.clear();
        int result = 0;
        assertEquals(result, out.size());
    }


    @Test
    public void shouldReturnMasWhenToArray() {
        String[] result = mas;
        assertArrayEquals(result, out.toArray());
    }





}