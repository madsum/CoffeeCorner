package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputManagerTest {

    @Test
    void testIsNumeric(){
        assertFalse(UserInputManager.isNumeric("a"));
        assertTrue(UserInputManager.isNumeric("1"));
    }

}
