package net.parwand.springmvc.entity;

public record Drink(String type, double menge) {

    @Override
    public String type() {
        return type;
    }

    @Override
    public double menge() {
        return menge;
    }

}
