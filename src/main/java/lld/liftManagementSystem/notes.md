         ---> Functional Requirements
1. 
2. The system should support N elevators operating in a building.
3. The building should have M floors (configurable).
4. Each elevator can move up or down one floor at a time.
5. Each elevator should maintain its current floor, direction, and status.
6. An elevator door should open only when the elevator is in IDLE state at a floor.
7. Each elevator should have:
     Internal button panel (destination floor selection)
      External button panel on each floor (UP / DOWN)
8. The system should have a common display showing:
9. Elevator position
         Direction
         Status
10. The system should assign the most suitable elevator for each external request.

              ---> Non-Functional Requirements

1. The system should be scalable for multiple elevators and floors.
2. The design should be extensible for different scheduling algorithms.
3. The system should be thread-safe (real-time elevator simulation).
4. The system should be fault-tolerant (elevator breakdown support – optional).


---------------------------------------------------------------------------------------------------------


--->Lift

       1. long liftNo;
       2. InternalLiftButton internalLiftButton;
       3. int currentFloor;
       4. Display display
       5. LiftStatus liftStatus
       6. TreeSet<Integer> upStops;
       7. TreeSet<Integer> downStops;

---> FLoor

     1. int floorNo;
     2. ExternalLiftButton externalLiftButton;




---> enum LiftStatus 

        {
            IDLE,
            MOVING,
            DOOR_OPEN,
            OUT_OF_SERVICE
        }

---> enum Direction 

         {
            UP, DOWN, IDLE
         }

---- >interface Button {
      }

-----> class InternalButton implements Button

        1. int floorNo

----> class ExternalButton implements Button

       1. Direction direction;


---> class InternalLiftButton

       1. List<InternalButton>buton

---> class externalFloorButton

       1. List<ExternalButton> button


----> class Display

      1.int floorNo;
      2.Direction direction








--------------------


