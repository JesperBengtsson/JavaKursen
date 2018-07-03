import java.util.HashSet;
import java.util.Set;

public class Elevator implements Runnable {
    private static int topfloor = 8;
    private static int bottonfloor = 1;
    private Boolean door = false;
    private static boolean goingup = true;
    public int currentFloor = 1;
    public Set<Integer> pushButtonList = new HashSet<>();

    public Elevator() {
        super();
    }

    public void moveUp() {
        if (currentFloor < topfloor) {
            currentFloor++;
        }
    }

    public void moveDown() {
        if (currentFloor > bottonfloor) {
            currentFloor--;
        }
    }

    public void move() throws InterruptedException {
        synchronized(pushButtonList) {
            for (Integer value : pushButtonList) {
                if (currentFloor == value.intValue()) {
                    this.setDoorOpen(true);
                    System.out.println("Elevator stopped at floor " + currentFloor);

                    Thread.sleep(5000);
                    this.setDoorOpen(false);
                    removeFromPbList((currentFloor));
                    break;
                }
            }
            if (goingup) {
                for (Integer value : pushButtonList) {
                    goingup =false;
                    if (currentFloor < value.intValue()) {
                        goingup = true;
                    }
                }
            }
            if  (!goingup)  {
                for (Integer value : pushButtonList) {
                    goingup = true;
                    if (currentFloor > value.intValue()) {
                        goingup = false;
                    }
                }
            }
        }
        if (goingup) {
            moveUp();
        } else {
            moveDown();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!pushButtonList.isEmpty()) {

                try {
                    move();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Elevator is at floor " + this.currentFloor);
        }
    }

    //Getters and setters
    public synchronized void setPushButtonListS(Set<Integer> pushButtonList) {
        this.pushButtonList = pushButtonList;
    }

    public Set<Integer> getPushButtonList() {
        return pushButtonList;
    }

    public synchronized void addToPbList(int value) {
        this.pushButtonList.add(value);
    }

    public synchronized void removeFromPbList(int value) {
        this.pushButtonList.remove(value);
    }

    public synchronized int getCurrentFloor() {
        return currentFloor;
    }

    public synchronized  Boolean getDoorOpen() {
        return door;
    }

    public synchronized  void setDoorOpen(Boolean door) {
        this.door = door;
    }
}