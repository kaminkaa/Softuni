package entities.factories;

import entities.factories.interfaces.ItemFactory;
import entities.items.*;
import entities.items.interfaces.Item;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ItemWorkshop implements ItemFactory {
    @Override
    public Item createItem(String type) {

//        Item item = null;
//
//        Class<?> clazz = null;
//        try {
//            clazz = Class.forName(type);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
//        Constructor<?> constructor = constructors[0];
//        constructor.setAccessible(true);
//        try {
//            item = (Item) constructor.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return item;

        switch (type) {
            case "CellPhone":
                return new CellPhone();
            case "Colombian":
                return new Colombian();
            case "Jewelery":
                return new Jewelery();
            case "Laptop":
                return new Laptop();
            case "Toothbrush":
                return new Toothbrush();
            case "TravelKit":
                return new TravelKit();

                default: return null;
        }
    }
}
