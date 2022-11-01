
public class Gorilla extends ZooKeeper{
    public Gorilla() {

    }
    public void eatBananas(){
        int energy = this.getEnergyLevel();
        setEnergyLevel(energy +10);
        System.out.println("The gorilla has gained 10 energy levels and now has: " + getEnergyLevel());
    }
    public void throwSomething(){
        int energy = this.getEnergyLevel();
        setEnergyLevel(energy -5);
        System.out.println("The gorilla has lost 5 energy levels and now has: " + getEnergyLevel());
    }
    public void climb(){
        int energy = this.getEnergyLevel();
        setEnergyLevel(energy -10);
        System.out.println("The gorilla has lost 10 energy levels and now has: " + getEnergyLevel());
    }
}