import java.util.Random;

public class Person implements Runnable {

    private int startFloorNumber = 0;
    private int endFloorNumber = 0;
    private boolean insideElevator = false;
    private boolean selectedStart = false;
    private boolean selectedEnd = false;
    private String name;
    public Elevator elevator;

    public Person(String name, Elevator elev ) {
        super();
        this.name = name;
        this.elevator = elev;
    }

    public  int getRandomNumber(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            if (!selectedStart) {
                if (!isInsideElevator()  && !elevator.getDoorOpen()) {
                    System.out.println(name + " waiting outside");
                    setRandomNumberStartfloor();
                    elevator.addToPbList(this.startFloorNumber);
                    selectedStart=true;

                }
            }
            if (!isInsideElevator()  && !elevator.getDoorOpen()) {
                System.out.println(name + " waiting outside");
            }

            if (this.getStartFloorNumber() == elevator.getCurrentFloor() && elevator.getDoorOpen()) {
                if (!selectedEnd) {
                    this.setInsideElevator(true);
                    setRandomNumberEndfloor();
                    elevator.addToPbList(this.endFloorNumber);
                    selectedEnd=true;
                    System.out.println("Door open "  + name + " steps in" );
                }
            }

            if (isInsideElevator()  && !elevator.getDoorOpen()) {
                System.out.println(name + " waiting for destination");
            }

            if (this.getEndFloorNumber() == elevator.getCurrentFloor() && elevator.getDoorOpen()) {

                this.setInsideElevator(false);
                System.out.println("Door open " + name + " steps out");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                setRandomNumberStartfloor();
                elevator.addToPbList(this.startFloorNumber);
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

    public int getEndFloorNumber() {
        return endFloorNumber;
    }

    public void setEndFloorNumber(int endFloorNumber) {
        this.endFloorNumber = endFloorNumber;
    }

    public  int getStartFloorNumber() {
        return startFloorNumber;
    }

    public void setStartFloorNumber(int startFloorNumber) {
        this.startFloorNumber = startFloorNumber;
    }

    public void  setRandomNumberStartfloor() {
        this.setStartFloorNumber(getRandomNumber(1,7));
    }

    public void  setRandomNumberEndfloor() {
        this.setEndFloorNumber(getRandomNumber(1,7));
    }

}
