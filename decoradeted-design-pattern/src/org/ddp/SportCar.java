package org.ddp;

public class SportCar extends CarDecorator {
    public SportCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding feature  with sport car");
    }
}
