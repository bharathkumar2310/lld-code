package lld.liftManagementSystem;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Lift {
    private int liftNo;
    private LiftPanel liftPanel;
    private int currentFloor;
    private Direction direction;
    private LiftStatus liftStatus;

    private Set<Integer> upStops;
    private Set<Integer> downStops;

    public Lift(int liftNo, LiftPanel liftPanel) {
        this.liftNo = liftNo;
        this.liftPanel = liftPanel;
        this.currentFloor = 1;
        this.direction = Direction.IDLE;
        this.liftStatus = LiftStatus.IDLE;
        this.upStops = new TreeSet<>();
        this.downStops = new TreeSet<>(Comparator.reverseOrder());
    }

    public int getLiftNo() {
        return liftNo;
    }

    public void setLiftNo(int liftNo) {
        this.liftNo = liftNo;
    }

    public LiftPanel getLiftPanel() {
        return liftPanel;
    }

    public void setLiftPanel(LiftPanel liftPanel) {
        this.liftPanel = liftPanel;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public LiftStatus getLiftStatus() {
        return liftStatus;
    }

    public void setLiftStatus(LiftStatus liftStatus) {
        this.liftStatus = liftStatus;
    }

    public Set<Integer> getUpStops() {
        return upStops;
    }

    public void setUpStops(Set<Integer> upStops) {
        this.upStops = upStops;
    }

    public Set<Integer> getDownStops() {
        return downStops;
    }

    public void setDownStops(Set<Integer> downStops) {
        this.downStops = downStops;
    }

    public synchronized void addStop(int floorNo) {

        if (direction == Direction.UP) {
            if (floorNo >= currentFloor) {
                upStops.add(floorNo);
            } else {
                downStops.add(floorNo); // serve after reversal
            }
        }
        else if (direction == Direction.DOWN) {
            if (floorNo <= currentFloor) {
                downStops.add(floorNo);
            } else {
                upStops.add(floorNo);
            }
        }
        else { // IDLE
            if (floorNo >= currentFloor) {
                upStops.add(floorNo);
            } else {
                downStops.add(floorNo);
            }
        }
    }


    public void addupStops(int floorNo) {
        this.upStops.add(floorNo);
    }

    public void addDownStops(int floorNo) {
        this.downStops.add(floorNo);
    }

    private int doorOpenSeconds = 0;

    public synchronized void moveLift() {

        // 1️⃣ Door open handling
        if (liftStatus == LiftStatus.DOOR_OPEN) {
            doorOpenSeconds++;

            if (doorOpenSeconds >= 60) { // 1 minute simulated
                doorOpenSeconds = 0;
                liftStatus = LiftStatus.MOVING;
            }
            return; // very important
        }

        // 2️⃣ Decide direction if idle
        if (direction == Direction.IDLE) {
            if (!upStops.isEmpty()) {
                direction = Direction.UP;
                liftStatus = LiftStatus.MOVING;
            } else if (!downStops.isEmpty()) {
                direction = Direction.DOWN;
                liftStatus = LiftStatus.MOVING;
            } else {
                return;
            }
        }

        // 3️⃣ Move one floor
        if (direction == Direction.UP) {
            currentFloor++;
            if (upStops.remove(currentFloor)) {
                liftStatus = LiftStatus.DOOR_OPEN;
            }
        } else {
            currentFloor--;
            if (downStops.remove(currentFloor)) {
                liftStatus = LiftStatus.DOOR_OPEN;
            }
        }

        // 4️⃣ Stop if no more requests
        if (upStops.isEmpty() && downStops.isEmpty()) {
            direction = Direction.IDLE;
            liftStatus = LiftStatus.IDLE;
        }
    }

}
