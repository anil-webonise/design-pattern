package org.ddp;

public class DecoratedPatternTest {
    public static void main(String[] args) {
        Car sportCar = new SportCar(new BaseCar());
        sportCar.assemble();
        System.out.println("--------------------------------------");
        Car luxuryCar = new SportCar(new LuxuryCar(new BaseCar()));
        luxuryCar.assemble();
    }
}

