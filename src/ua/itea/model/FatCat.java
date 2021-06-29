package ua.itea.model;

import ua.itea.annotation.Color;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class FatCat extends Cat {

    @Color("Black")
    private String name;

    @SuppressWarnings({"unused", "RedundantSuppression", "FieldMayBeFinal", "FieldCanBeLocal"})
    private double weight;

    public FatCat(double weight){
        this.weight = weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
