package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public  class Car {
    public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }

    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }

    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }

    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }

    public static void main(String[] args) {
/*        Car car = Car.create(Car::new);
//        Car car1 = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);

        cars.forEach(Car::collide);
        cars.forEach(Car::repair);

        Car cc=Car.create(Car::new);
        cars.forEach(cc::follow);*/

//        Car car1 = Car.collide(Car::new);

//        Optional
        Optional< String > fullName = Optional.ofNullable( null );
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
    }
}