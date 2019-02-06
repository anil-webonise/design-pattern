package org.ddp;

public class LuxuryCar extends CarDecorator{

    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding feature of luxuary car");
    }
}
