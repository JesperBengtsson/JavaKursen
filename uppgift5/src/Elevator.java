import java.util.HashSet;
import java.util.Set;

public class Elevator implements Runnable {
    private int topFloor;
    private int bottomFloor;
    private boolean door = false;
    private boolean goingUp = true;
    public int currentFloor = 1;
    public Set<Integer> pushButtonList = new HashSet<>();

    public Elevator(Integer bottomFloor, int topFloor) {
        super();
        this.topFloor = topFloor;
        this.bottomFloor = bottomFloor;
    }

    public void moveUp() {
        if (currentFloor <= topFloor) {
            currentFloor++;
        }
    }

    public void moveDown() {
        if (currentFloor >= bottomFloor) {
            currentFloor--;
        }
    }

    public void move() throws InterruptedException {
        synchronized(pushButtonList) {
            for (Integer desiredFloors : pushButtonList) {
                if (currentFloor == desiredFloors) {
                    this.setDoorOpen(true);
                    System.out.println("Elevator stopped at floor " + currentFloor);

                    Thread.sleep(4000);
                    this.setDoorOpen(false);
                    removeFromPbList((currentFloor));
                    break;
                }
            }
            if (goingUp) {
                goingUp = false;
                for (Integer desiredFloors : pushButtonList) {
                    if (currentFloor < desiredFloors) {
                        goingUp = true;
                    }

                }
            }
            if  (!goingUp)  {
                goingUp = true;
                for (int desiredFloors : pushButtonList) {
                    if (currentFloor > desiredFloors) {
                        goingUp = false;
                    }

                }
            }
        }
        if (goingUp) {
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
                System.out.println("Elevator is at floor " + this.currentFloor);
                try {
                    move();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

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

    public synchronized int getTopFloor() {
        return topFloor;
    }

    public synchronized void setTopFloor(int topFloor) {
        this.topFloor = topFloor;
    }

    public synchronized int getBottomFloor() {
        return bottomFloor;
    }

    public synchronized void setBottomFloor(int bottomFloor) {
        this.bottomFloor = bottomFloor;
    }
}