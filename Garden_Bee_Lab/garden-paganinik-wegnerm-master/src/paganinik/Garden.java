package paganinik;

import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;

public class Garden {
    private ArrayList<FlowerBee> flowerBees;
    private ArrayList<DestroyerBee> destroyerBees;
    private ArrayList<MedicFlower> medicFlowers;
    private ArrayList<ThiefFlower> thiefFlowers;
    private static Garden garden;

    //**************** Singleton Pattern ****************\\

    private Garden()
    {
        this.flowerBees = new ArrayList<>();
        this.destroyerBees = new ArrayList<>();
        this.medicFlowers = new ArrayList<>();
        this.thiefFlowers = new ArrayList<>();

    }

    //**************** Singleton Pattern ****************\\

    public static Garden getInstance()
    {
        if(garden == null)
        {
            garden = new Garden();
        }
        return garden;
    }

    //**************** Setters and Getters for Bees ****************\\

    public void setNumFlowerBees(int numBees)
    {
        if (flowerBees.size() != 0){
            flowerBees.clear();
        }

        for(int i = 0; i < numBees; i++)
        {
            flowerBees.add(new FlowerBee());
        }

    }

    public void setNumDestroyerBees(int numBees)
    {
        if (destroyerBees.size() != 0){
            destroyerBees.clear();
        }

        for (int i = 0; i < numBees; i++)
        {
            destroyerBees.add(new DestroyerBee());
        }

    }



    //**************** Setters and Getters for Flowers ****************\\

    public void setNumMedicFlowers(int numFlowers)
    {
        if (medicFlowers.size() != 0)
        {
            medicFlowers.clear();
        }

        for(int i = 0; i < numFlowers; i++)
        {
            medicFlowers.add(new MedicFlower());
        }

    }

    public void setNumThiefFlowers(int numFlowers)
    {
        if (thiefFlowers.size() != 0)
        {
            thiefFlowers.clear();
        }

        for(int i =0; i < numFlowers; i++)
        {
            thiefFlowers.add(new ThiefFlower());
        }

    }


    public ArrayList<FlowerBee> getFlowerBees() {
        return flowerBees;
    }

    public ArrayList<MedicFlower> getMedicFlowers() {
        return medicFlowers;
    }

    public ArrayList<DestroyerBee> getDestroyerBees() {
        return destroyerBees;
    }

    public ArrayList<ThiefFlower> getThiefFlowers() {
        return thiefFlowers;
    }
}
