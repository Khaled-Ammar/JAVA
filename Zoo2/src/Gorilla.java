
public class Gorilla extends ZooKeeper{
    public Gorilla() {

    }
    public void eatBananas(){
        int energy = this.getEnergyLeve1();
        setEnergyLeve1(energy +10);
        System.out.println("The gorilla has gained 10 energy levels and now has: " + getEnergyLeve1());
    }
    public void throwSomething(){
        int energy = this.getEnergyLeve1();
        setEnergyLeve1(energy -5);
        System.out.println("The gorilla has lost 5 energy levels and now has: " + getEnergyLeve1());
    }
    public void climb(){
        int energy = this.getEnergyLeve1();
        setEnergyLeve1(energy -10);
        System.out.println("The gorilla has lost 10 energy levels and now has: " + getEnergyLeve1());
    }
}