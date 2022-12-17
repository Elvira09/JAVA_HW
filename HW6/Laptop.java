package HWJava.HW6;


public class Laptop {
    private String manufacturer;
    private String model;
    private float screenDiagonal;
    private String operatingSystem;
    private String processor;
    private int randomAccessMemory;
    private int ssdCapacity;
    private float price;
    
    public Laptop(String manufacturer, String model, float screenDiagonal, String operatingSystem, String processor,
            int randomAccessMemory, int ssdCapacity, float price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.screenDiagonal = screenDiagonal;
        this.operatingSystem = operatingSystem;
        this.processor = processor;
        this.randomAccessMemory = randomAccessMemory;
        this.ssdCapacity = ssdCapacity;
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public float getScreenDiagonal() {
        return screenDiagonal;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRandomAccessMemory() {
        return randomAccessMemory;
    }

    public int getSsdCapacity() {
        return ssdCapacity;
    }

    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nНоутбук " + manufacturer + "  " + model + " ( " + screenDiagonal
                + "\", " + operatingSystem + " ,  " + processor + ", "
                + randomAccessMemory + " Гб , " + ssdCapacity + " Гб SSD)" + " Стоимость " + price + " руб.";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + Float.floatToIntBits(screenDiagonal);
        result = prime * result + ((operatingSystem == null) ? 0 : operatingSystem.hashCode());
        result = prime * result + ((processor == null) ? 0 : processor.hashCode());
        result = prime * result + randomAccessMemory;
        result = prime * result + ssdCapacity;
        result = prime * result + Float.floatToIntBits(price);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;
        if (manufacturer == null) {
            if (other.manufacturer != null)
                return false;
        } else if (!manufacturer.equals(other.manufacturer))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (Float.floatToIntBits(screenDiagonal) != Float.floatToIntBits(other.screenDiagonal))
            return false;
        if (operatingSystem == null) {
            if (other.operatingSystem != null)
                return false;
        } else if (!operatingSystem.equals(other.operatingSystem))
            return false;
        if (processor == null) {
            if (other.processor != null)
                return false;
        } else if (!processor.equals(other.processor))
            return false;
        if (randomAccessMemory != other.randomAccessMemory)
            return false;
        if (ssdCapacity != other.ssdCapacity)
            return false;
        if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
            return false;
        return true;
    }

   

    

}
