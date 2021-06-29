package ua.itea;

import ua.itea.model.FatCat;
import ua.itea.model.HomeCat;
import ua.itea.model.HomelessCat;
import ua.itea.service.CatMincedFactory;

public class Application {

    public static void main(String[] args) {
        CatMincedFactory catMincedFactory = new CatMincedFactory(60d);
        double minced = catMincedFactory
                .addCat(new FatCat(5.6))
                .addCat(new FatCat(4.7))
                .addCat(new HomelessCat(2.4))
                .addCat(new HomelessCat(1.8))
                .addCat(new HomeCat("Tom", 3.8))
                .addCat(new HomeCat("Bead", 3.1))
                .getMinced();
        System.out.println("cats minced meat - " + minced);
    }
}
