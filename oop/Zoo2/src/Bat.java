
public class Bat extends ZooKeeper  {
			public Bat() {
				 setEnergyLeve1(300);
			}

	    public void eatHumans(){
	        int energy = getEnergyLeve1();
	        setEnergyLeve1(energy -25);
	        System.out.println("The Bat has gained 25 energy levels and now has: " + getEnergyLeve1());
	    }


		public void fly(){
	        int energy = this.getEnergyLeve1();
	        setEnergyLeve1(energy -50);
	        System.out.println("The Bat has lost 50 energy levels and now has: " + getEnergyLeve1());
	    }
	    public void attackTown(){
	        int energy = this.getEnergyLeve1();
	        setEnergyLeve1(energy -100);
	        System.out.println("The Bat has lost 100 energy levels and now has: " + getEnergyLeve1());
	    }
	}
	
