public class Main {

    public static void main(String[] args) {

        Elevator elevator =  new Elevator(1, 10);

        Person person1 =  new Person( "Bengt" , elevator);
        Person person2 =  new Person( "Jesper", elevator);
        Person person3 =  new Person( "Anna", elevator);

        Thread elevatorThread = new Thread(elevator);

        System.out.println("Starting elevator at floor " + elevator.currentFloor);

        elevatorThread.start();

        Thread personThread1  = new Thread(person1);
        personThread1.start();

        Thread personThread2  = new Thread(person2);
        personThread2.start();

        Thread personThread3  = new Thread(person3);
        personThread3.start();


    }

}
