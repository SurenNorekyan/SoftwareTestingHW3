package org.example;

import org.example.MotorcycleStore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotorcycleStoreTest {
    @Test
    public void testSellMotorcycle() {
        MotorcycleStore store = new MotorcycleStore(5);
        store.sellMotorcycle();
        assertEquals(4, store.getTotalMotorcycles());
    }

    @Test
    public void testSellMotorcycleWhenOutOfStock() {
        MotorcycleStore store = new MotorcycleStore(0);
        assertThrows(IllegalStateException.class, store::sellMotorcycle);
    }

    @Test
    public void testRestockMotorcycles() {
        MotorcycleStore store = new MotorcycleStore(3);
        store.restockMotorcycles(2);
        assertEquals(5, store.getTotalMotorcycles());
    }

    @Test
    public void testRestockMotorcyclesWithInvalidQuantity() {
        MotorcycleStore store = new MotorcycleStore(3);
        assertThrows(IllegalArgumentException.class, () -> {
            store.restockMotorcycles(-2);
        });
    }

    @Test
    public void testCheckStockStatus() {
        MotorcycleStore store1 = new MotorcycleStore(0);
        assertEquals("Out of stock", store1.checkStockStatus());

        MotorcycleStore store2 = new MotorcycleStore(11);
        assertEquals("In stock", store2.checkStockStatus());

        MotorcycleStore store3 = new MotorcycleStore(8);
        assertEquals("Low stock", store3.checkStockStatus());
    }

    @Test
    public void testIsPopularModelSalesExceeds() {
        MotorcycleStore store = new MotorcycleStore(50);
        //Sell motorcycle 10 times, so it becomes a popular one
        for (int i=0;i<=10;i++) {
            store.sellMotorcycle();
        }
        assertTrue(store.isPopularModel("Chopper"));
    }

    @Test
    public void testIsPopularModelSalesBelow() {
        MotorcycleStore store = new MotorcycleStore(100);
        assertFalse(store.isPopularModel("Chopper"));
    }

    @Test
    public void testIsPopularModelWhenModelIsNotSport() {
        MotorcycleStore store = new MotorcycleStore(100);
        assertFalse(store.isPopularModel("Cruiser"));
    }
}
