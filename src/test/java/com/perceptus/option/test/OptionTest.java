package com.perceptus.option.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.perceptus.option.Absent;
import com.perceptus.option.Option;
import com.perceptus.option.Present;

public class OptionTest {

    @Test public void testAbsent() {
        Option<Integer, Exception> target = Option.absent(new Exception("Test"));
        assertTrue(target instanceof Absent);
        assertFalse(target.isPresent());

    }

    @Test public void testPresent() {
        Option<Integer, Exception> target = Option.of(2);
        assertTrue(target instanceof Present);
        assertTrue(target.isPresent());
    }

    @Test public void testPresentGet() {
        Option<Integer, Exception> target = Option.of(2);
        assertTrue(target.isPresent());
        assertEquals(target.get(), new Integer(2));
    }

    @Test public void testPresentDefault() {
        Option<Integer, Exception> target = Option.of(2);
        assertTrue(target.isPresent());
        assertEquals(target.or(35), new Integer(2));
        assertEquals(target.orNull(), new Integer(2));
    }

    @Test public void testPresentGetException() {
        Option<Integer, Exception> target = Option.of(2);
        assertTrue(target.isPresent());
        assertFalse(target.hasException());
        try {
            Exception e = target.getException();
            fail("Should throw when there's no exception");
        } catch (IllegalStateException e) {
            assertNotNull(e);
        }
    }

    @Test public void testAbsentGet() {
        Option<Integer, Exception> target = Option.absent(new Exception("Test"));
        assertFalse(target.isPresent());
        try {
            Integer t = target.get();
            fail("Should throw when there's no value");
        } catch (IllegalStateException e) {
            assertNotNull(e);
        }
    }

    @Test public void testAbsentDefault() {
        Option<Integer, Exception> target = Option.absent(new Exception("Test"));
        assertFalse(target.isPresent());
        assertEquals(target.or(35), new Integer(35));
        assertNull(target.orNull());
    }

    @Test public void testAbsentGetException() {
        Option<Integer, Exception> target = Option.absent(new Exception("Test"));
        assertFalse(target.isPresent());
        assertTrue(target.hasException());
        assertNotNull(target.getException());
    }

}
