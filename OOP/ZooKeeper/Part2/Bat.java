public class Bat extends Mammal {
	public Bat() {
		this.energyLevel = 300;
	}
	
	
	public Bat fly() {
		System.out.println("Click! A bat just lost 50 energy!");
		this.energyLevel -= 50;
		return this;
	}
	
	
	public Bat eatHumans() {
		System.out.println("A bat has eaten a human and has gained 50 energy");
		this.energyLevel += 25;
		return this;
	}
	
	
	public Bat attackTown() {
		System.out.println("A bat has attacked a nearby town and has lost 50 energy");
		this.energyLevel -= 100;
		return this;
	}
}
