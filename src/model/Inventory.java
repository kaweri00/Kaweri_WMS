package model;

import java.util.Objects;

public class Inventory {

    Product product;
    int quantity;
    int assigned;

    public Inventory( Product product ){
        this(product, 0);
    }

    public Inventory( Product product, int initialQuantity){
        this.product = product;
        this.quantity = initialQuantity > 0 ? initialQuantity : 0 ;
        this.assigned = 0;
    }

    public void addQuantity(int incomingQuantity){
        if (incomingQuantity > 0){
            quantity += incomingQuantity;
        }
    }

    public void deductQuantity(int outgoingQuantity){
        if (outgoingQuantity > 0){
            quantity -= outgoingQuantity;
        }
    }

    public void assign(int toAssignQuantity){
        if (toAssignQuantity > 0){
            assigned += toAssignQuantity;
        }
    }

    public void unassign(int toUnassignQuantity){
        if (toUnassignQuantity > 0){
            assigned += toUnassignQuantity;
        }
    }

    public int getAvailableQuantity(){
        return quantity - assigned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(product, inventory.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

    @Override
    public String toString() {
        return String.format("%s\nCANTIDAD: %d\nCANTIDAD RESERVADA: %d\nCANTIDAD DISPONIBLE: %d",
                product, quantity, assigned, getAvailableQuantity());
    }
}
