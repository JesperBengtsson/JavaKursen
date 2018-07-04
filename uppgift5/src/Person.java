import java.util.Random;

public class Person implements Runnable {

    private int startingFloor;
    private int desiredFloor;
    private boolean insideElevator = false;
    private boolean selectedStart = false;
    private boolean selectedEnd = false;
    private String name;
    public Elevator elevator;

    public Person(String name, Elevator elev) {
        super();
        this.name = name;
        this.elevator = elev;
        this.startingFloor = getRandomNumber(elevator.getBottomFloor(), elevator.getTopFloor());
    }

    public int getRandomNumber(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            if (!selectedStart) {
                if (!isInsideElevator()  && !elevator.getDoorOpen()) {
                    //System.out.println(name + " waiting outside");

                    elevator.addToPbList(startingFloor);
                    selectedStart = true;
                }
            }

            if (startingFloor == elevator.getCurrentFloor() && elevator.getDoorOpen()) {
                if (!selectedEnd) {
                    setInsideElevator(true);
                    setRandomNumberEndfloor();
                    elevator.addToPbList(desiredFloor);
                    selectedEnd = true;
                    System.out.println("---------------------------");
                    System.out.println("Door open "  + name + " steps in" );
                    System.out.println(name + " wants to go to floor " + desiredFloor);
                    System.out.println("---------------------------");
                }
            }

            if (isInsideElevator()  && !elevator.getDoorOpen() && elevator.currentFloor != desiredFloor) {
                //System.out.println(name + " waiting for destination");
            }

            if (desiredFloor == elevator.getCurrentFloor() && elevator.getDoorOpen()) {

                setInsideElevator(false);
                System.out.println("---------------------------");
                System.out.println("Door open " + name + " steps out");
                System.out.println("---------------------------");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                setStartingFloor(desiredFloor);
                elevator.addToPbList(startingFloor);
                selectedEnd = false;
            }
        }
    }

    //Getters and setters

    public boolean isInsideElevator() {
        return insideElevator;
    }

    public void setInsideElevator(boolean insideElevator) {
        this.insideElevator = insideElevator;
    }

    public int getDesiredFloor() {
        return desiredFloor;
    }

    public void setDesiredFloor(int desiredFloor) {
        this.desiredFloor = desiredFloor;
    }

    public  int getStartingFloor() {
        return startingFloor;
    }

    public void setStartingFloor(int startingFloor) {
        this.startingFloor = startingFloor;
    }

    public void  setRandomNumberStartfloor() {
        this.setStartingFloor(getRandomNumber(elevator.getBottomFloor(), elevator.getTopFloor()));
    }

    public void  setRandomNumberEndfloor() {
        this.setDesiredFloor(getRandomNumber(elevator.getBottomFloor(), elevator.getTopFloor()));
    }

}
