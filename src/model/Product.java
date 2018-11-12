package model;

import java.util.Objects;

public class Product {



    public enum ProductState { ACTIVE, INACTIVE}

    private String sku;
    private String description;
    private ProductState productState;

    public Product(String sku, String description){
        productState = ProductState.INACTIVE;
        this.sku = sku;
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void activate(){
        productState = ProductState.ACTIVE;
    }

    public void deactivate(){
        productState = ProductState.INACTIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getSku(), product.getSku()) &&
                Objects.equals(getDescription(), product.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSku(), getDescription());
    }

    @Override
    public String toString(){
        return String.format("SKU: %s\nDESCRIPCION: %s\nESTADO: %s", sku, description, productState);
    }
}
