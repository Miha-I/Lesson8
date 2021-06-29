package ua.itea.model;

import ua.itea.annotation.Color;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class HomelessCat extends Cat {

    @Color({"Gray", "Black"})
    private String name;

    @SuppressWarnings({"unused", "RedundantSuppression", "FieldMayBeFinal", "FieldCanBeLocal"})
    private double weight;

    public HomelessCat(double weight){
        this.weight = weight;
    }

    private void setWeight(float weight) {
        this.weight = weight;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
