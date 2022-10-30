import java.util.*;
class Orders {
    private String name;
    private boolean ready;
    private ArrayList<Items> items = new ArrayList<Items>();

public Orders() {

}
public Orders(String name, boolean ready, ArrayList<Items> items) {
    this.name = name;
    this.ready = ready;
    this.items = items;
}
public void addItem(Items newItem) {
    items.add(newItem);
}
public void display() {
    System.out.println("Customer's name: " + this.name);
    double total = 0;
    for(Items i : items) {
        total +=i.getPrice();
        System.out.println(i.getName() + " - " + " $ " + i.getPrice());
    }
    System.out.println("Your total is: " + " $" + total);
}
public void getStatusMessage() {
    if (isReady() == true) {
        System.out.println("Your order is ready! " + getName());
    } else {
        System.out.println("Your order is still in progress");
    }
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public boolean isReady() {
    return ready;
}
public void setReady(boolean ready) {
    this.ready = ready;
}
public ArrayList<Items> getItems() {
    return items;
}
public void setItems(ArrayList<Items> items) {
    this.items = items;
}
}
