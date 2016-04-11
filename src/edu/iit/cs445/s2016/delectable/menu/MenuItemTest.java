package edu.iit.cs445.s2016.delectable.menu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MenuItemTest {

    MenuItem m;

    @Before
    public void setUp() throws Exception {
        m = new MenuItem();
    }

    @Test
    public void test_new_default_MenuItem_notNull() {
        assertFalse(m.isNil());
    }
    
    @Test
    public void test_new_default_categories_isEmpty() {
        assertTrue(m.categories().size()==0);
    }



}
