package entities.factories;

import entities.airplanes.LightAirplane;
import entities.airplanes.MediumAirplane;
import entities.airplanes.interfaces.FlyingMachine;
import entities.factories.interfaces.AirplaneFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AirplaneWorkshop implements AirplaneFactory {

    @Override
    public FlyingMachine createAirplane(String type) {

//        FlyingMachine flyingMachine = null;
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
//            flyingMachine = (FlyingMachine) constructor.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        return flyingMachine;

        switch (type) {
            case "LightAirplane":
                return new LightAirplane();
            case "MediumAirplane":
                return new MediumAirplane();

                default: return null;
        }
    }
}
