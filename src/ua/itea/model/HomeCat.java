package ua.itea.model;

import ua.itea.annotation.Blohable;
import ua.itea.annotation.Color;

@Blohable
@SuppressWarnings({"unused", "RedundantSuppression"})
public class HomeCat extends Cat {

    @Color("Green")
    private String name;

    @SuppressWarnings({"unused", "RedundantSuppression", "FieldMayBeFinal", "FieldCanBeLocal"})
    private double weight;

    public HomeCat(String name, double weight){
        this.name = name;
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
