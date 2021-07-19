package org.example;

class MenuItem  {

    private String name;
    private float price;
    private int quantity;
    private String size;

    public MenuItem(Builder builder){
        this.name = builder.name;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.size = builder.size;
    }

  public static class Builder {

        private String name;
        private float price;
        private int quantity;
        private String size;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(float price) {
            this.price = price;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public MenuItem build(){
            return new MenuItem(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
