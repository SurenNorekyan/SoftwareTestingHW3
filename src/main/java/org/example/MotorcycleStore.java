package org.example;

public class MotorcycleStore {
    private int totalMotorcycles;
    private int totalSales;

    public MotorcycleStore(int totalMotorcycles) {
        this.totalMotorcycles = totalMotorcycles;
        this.totalSales = 0;
    }

    public void sellMotorcycle() {
        if (totalMotorcycles > 0) {
            totalMotorcycles--;
            totalSales++;
        } else {
            throw new IllegalStateException("No motorcycles available for sale.");
        }
    }

    public void restockMotorcycles(int quantity) {
        if (quantity > 0) {
            totalMotorcycles += quantity;
        } else {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
    }

    public String checkStockStatus() {
        if (totalMotorcycles == 0) {
            return "Out of stock";
        } else if (totalMotorcycles < 10) {
            return "Low stock";
        } else {
            return "In stock";
        }
    }

    public int getTotalMotorcycles() {
        return totalMotorcycles;
    }

    public boolean isPopularModel(String model) {
        if (model.equals("Chopper")) {
            return totalSales >= 10;
        } else {
            return false;
        }
    }
}
