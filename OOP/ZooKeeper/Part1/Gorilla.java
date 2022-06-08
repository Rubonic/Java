public class Gorilla extends Mammal {
    public void throwItem(){
        this.setEnergy(this.getEnergy()-5);
        System.out.println("The gorilla threw an item. Watch out!");
    }

    public void eatBananas(){
        this.setEnergy(this.getEnergy()+10);
        System.out.println("The gorilla loves bananas");
    }

    public void climb(){
        this.setEnergy(this.getEnergy()-10);
        System.out.println("The gorilla climbed the three");
    }
}
