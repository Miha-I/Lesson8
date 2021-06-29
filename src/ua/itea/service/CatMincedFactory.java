package ua.itea.service;

import ua.itea.annotation.Blohable;
import ua.itea.annotation.Color;
import ua.itea.model.Cat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class CatMincedFactory {

    private final Random random;

    private final Double mincedMeatPercent;

    private final List<Cat> catsForMinced;

    public CatMincedFactory(Double mincedMeatPercent) {
        this.mincedMeatPercent = mincedMeatPercent / 100;
        catsForMinced = new LinkedList<>();
        random = new Random(System.currentTimeMillis());
    }

    public CatMincedFactory addCat(Cat cat) {
        this.catsForMinced.add(cat);
        return this;
    }

    public double getMinced() {
        chooseCats();
        return createMinced();
    }

    private void chooseCats() {
        Iterator<Cat> iterator = catsForMinced.iterator();
        Cat cat;
        while (iterator.hasNext()) {
            cat = iterator.next();
            if (checkBlohable(cat) || checkColor(cat) || checkMethod(cat)) {
                iterator.remove();
            }
        }
    }

    private boolean checkBlohable(Cat cat) {
        return cat.getClass().getAnnotation(Blohable.class) != null;
    }

    private boolean checkColor(Cat cat) {
        try {
            Field field = cat.getClass().getDeclaredField("name");
            Color annotation = field.getAnnotation(Color.class);
            if (annotation != null && Arrays.asList(annotation.value()).contains("Black") && random.nextBoolean()) {
                return true;
            }
        } catch (NoSuchFieldException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean checkMethod(Cat cat) {
        Method[] methods = cat.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                return true;
            }
        }
        return false;
    }

    private double createMinced() {
        double mincedWeight = 0.0;
        for (Cat cat : catsForMinced) {
            try {
                Field field = cat.getClass().getDeclaredField("weight");
                field.setAccessible(true);
                Double weight = 0.0;
                if (field.getType() == Double.class || field.getType() == double.class) {
                    weight = (Double) field.get(cat);
                }
                mincedWeight += weight * mincedMeatPercent;
            } catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
        return mincedWeight;
    }
}
