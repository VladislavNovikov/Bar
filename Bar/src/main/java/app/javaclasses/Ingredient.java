package app.javaclasses;

public class Ingredient {
    private String name;
    private int volume;
    private int drinkId;


    public Ingredient(String name, int volume, int drinkId) {
        this.name = name;
        this.volume = volume;
        this.drinkId = drinkId;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public int getDrinkId() {
        return drinkId;
    }

    @Override
    public String toString() {
        return name + " " + volume + "мл";
    }
}
