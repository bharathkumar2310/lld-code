Requiremnts:

--Admin

1. Should be able to add theatres , screens in each theatre
2. Should be able to create movies
3. Should be able to create shows for each movie and assign it to each screens



--User

1. Should be able to register and login
2. Should be able to view all the movies
3. Should be able to see all the shows for that particular movie
4. Should be able to see all the seats and status of the seat for a particular show
5. If available he should be able to book the seat

-----


While booking when 2 users tries to book at single seat there should not be any race conditions
that is there should not be double booking for a set

If a locked seat's booking is failed the seat for that show should be reverted back as available

“These are the core requirements. I’ll now identify the main entities and design the class structure.




---------------------------------------------------------------------------------------------------------------------


---> Theatre

1. long theatreId 
2. String theatreName
3. List<Screen> screens


---> Screen

1. long screenId
2. String screenName;
3. Theatre theatre;
4. List<Seat> seats;


---> Movie

1. long movieId;
2. String movieName;
3. long movieDuration;


---> Seat 

1. String SeatNumber;
2. SeatType seatType;

---> enum SeatType{
      NORMAL, PREMIUM
    }

---> Show

1. long ShowId;
2. Movie movie;
3. Screen screen;
5. List<ShowSeat> showSeats




---> ShowSeat

1. Show show
2. Seat seat
3. SeatStatus seatStatus
4. LocalDateTime lockedTime;

------
boolean book()
boolean lock()
boolean unLock()
boolean isLockExpired()
void unlockIfExpired()


---> enum SeatStatus {
     AVAILABLE, LOCKED, BOOKEd
    }



---> Booking
1. Long bookingId
2. User user
3. Show show
4. List<ShowSeat> showSeats
5. int amount
6. BookingStatus bookingStatus



---> enum BookingStatus {
        INITIATED, CONFIRMED, CANCELLED
}

---> enum PaymentType {
      CREDIT, DEBIT
}

---> interface pricingStratergy 
        --int calculateAmount()

 1. class NormalPricingStratergy
 2. class PremiumPricingStratergy

class PricingStrategyFactory
      --PricingStratergy selectPricingStatergy(SeatType seatType)

---> interface PaymentStategy
      --boolean pay(Booking booking);

1. class creditCardPaymentSTrategy
2. class debitCardPaymentStrategy

---- >class PaymentStartegyFactory
     ---PaymentStrategy getPaymentService(PaymentType paymentType);


---> User

1. long userId
2. String userName
3. String email

---> App Class(Acts as a common repo)

1. List<User> users;
2. List<Theatre> theatre;
3. Map<Movie, List<Show>> showsForMovie; 


---> Theatre Service
1. App Class
2. addTheatre(String theatreName)

---->  Screen Service
0. App Class
1. addScreen(String theatreName , String screenName)
2. addNormalSeatsToScreen(int noOfSeats, String theatreName, String screenName )
3. addPremiumSeatsToScreen(int noOfSeats, String theatreName, String screenName)


----> Movie Service
0. App Class
1. addMovie(String movieName, long hours)
2. showMovies()

----> Show Service
0. App Class
1. createShow(String theatreName, String movieName, int noOfShows, String screenName, LocalDateTime firstShowStartTime)
2. List<Show>getAllShowsForAMovie(Movie movie)


----> User Service

0. App Class
1. createUser(String userName, String email)


---->Booking Service

0. App Class
1. bookShow(Show show, List<ShowSeat> seats)
2. payBooking(Booking booking, PaymentType paymentType)


----> PaymentService

1.pay(Booking booking, PaymentType paymentType)



----> SeatLockCleanupService

1. void start()
2. void cleanupExpiredLocks()



------------------------------------------------------------------------------------------


--------------------------------------------------------------------------------------
“Explain end-to-end booking flow.”

✅ Answer (Points)

User selects show and seats

System tries to lock all selected seats

If any seat is unavailable → rollback

Price is calculated using seat-based pricing strategy

Booking is created in INITIATED state

Payment is triggered

On payment success → seats are BOOKED, booking CONFIRMED

On failure → seats unlocked, booking CANCELLED

2️⃣ Concurrency Handling
❓ Question

“How do you prevent double booking?”

✅ Answer

Seat status is maintained at ShowSeat level

Locking is done per seat using synchronized methods

Seat transitions: AVAILABLE → LOCKED → BOOKED

Only one thread can lock a seat at a time

Partial locks are rolled back

❓ Follow-up

“Where exactly do you lock?”

✅ Answer

Locking happens inside ShowSeat.lockSeat()

BookingService orchestrates multiple seat locks atomically

3️⃣ Seat Lock Expiry
❓ Question

“What if user locks seat and leaves?”

✅ Answer

Each locked seat stores lockedTime

A background cleanup job releases expired locks

Timeout is configurable (e.g., 5 minutes)

Expired locks are reverted to AVAILABLE

4️⃣ Failure Handling
❓ Question

“What if payment fails?”

✅ Answer

Booking is marked CANCELLED

All locked seats are released

System remains consistent

5️⃣ Pricing Logic
❓ Question

“How is pricing calculated?”

✅ Answer

Pricing depends on seat type

Strategy pattern is used for pricing

Each seat uses its pricing strategy

Total amount is aggregated per booking

6️⃣ Payment Design
❓ Question

“How do you support multiple payment modes?”

✅ Answer

Payment is abstracted using Strategy pattern

Factory selects payment strategy based on payment type

BookingService is decoupled from payment implementation

7️⃣ Why ShowSeat Instead of SeatStatus in Seat
❓ Question

“Why not store status inside Seat?”

✅ Answer

Seat is static per screen

Availability is show-specific

Same seat can be available in one show and booked in another

Hence status is maintained in ShowSeat

🔥 This is a killer answer

8️⃣ Data Consistency
❓ Question

“How do you ensure atomicity?”

✅ Answer

All seats are locked before booking creation

Any failure triggers rollback

State transitions are synchronized

Booking state is updated only after final outcome

9️⃣ Scalability
❓ Question

“Will this scale?”

✅ Answer

Design supports horizontal scaling conceptually

In-memory locking works for single JVM

For distributed systems, DB row-level or Redis locks are required

Architecture can be extended without changing core logic

1️⃣0️⃣ Distributed System Follow-up (Very Common)
❓ Question

“Does synchronized work in multiple servers?”

✅ Answer

No, synchronized is JVM-scoped

In distributed setup, we use:

Database pessimistic locking OR

Redis-based distributed locks

1️⃣1️⃣ Deadlock Handling
❓ Question

“Any deadlock risk?”

✅ Answer

Seats are locked in a fixed order

Rollback releases all locks on failure

No circular dependencies exist

1️⃣2️⃣ Why Factory + Strategy
❓ Question

“Why use design patterns?”

✅ Answer

Strategy allows behavior change without modifying core logic

Factory centralizes object creation

Improves extensibility and testability

1️⃣3️⃣ Validation
❓ Question

“What validations will you add?”

✅ Answer

User authentication before booking

Seat belongs to selected show

Booking not allowed after show start time

Payment retry limits

1️⃣4️⃣ Admin Constraints
❓ Question

“What admin validations exist?”

✅ Answer

No overlapping shows on same screen

Screen must belong to theatre

Movie duration considered for show scheduling

1️⃣5️⃣ Clean Code / Responsibility
❓ Question

“Why so many services?”

✅ Answer

Each service has single responsibility

Improves maintainability

Easier to test and extend