1️⃣ User Management

    System should allow creation of users
    Each user has:
    
    Unique ID
    Name
    Email
    
    A user can be assigned multiple tasks
    
    Note (interview tip): Authentication/authorization is out of scope unless specified.

2️⃣ Task Creation

    User should be able to create a task
    
    Each task must have:
    
    Task ID
    Title
    Description
    Status (TODO, IN_PROGRESS, DONE)
    Priority (LOW, MEDIUM, HIGH)
    Due date
    
    A task can exist without being assigned initially

3️⃣ Task Assignment

    Task can be assigned to one user
    Reassignment should be allowed
    Only valid users can be assigned

4️⃣ Task Update

    User should be able to:
    Update task title or description
    Change task status
    Change priority
    Update due date
    Task updates should reflect immediately

5️⃣ Task Retrieval

    System should support fetching:
    Task by task ID
    All tasks assigned to a user
    All tasks under a project (if projects are supported)
    Tasks filtered by:
    Status
    Priority
    Due date

6️⃣ Task Deletion

    User should be able to delete a task
    Deleting a task removes it from:
    User’s assigned task list
    Project (if any)

7️⃣ Project Management (Optional / Phase-2)

    Create projects
    Assign tasks to projects
    Retrieve all tasks under a project
    In interviews, say:
    “Project support can be added without changing core task logic.”

8️⃣ Comments on Tasks (Optional)
    
    Users can add comments to tasks
    Comments include:
    Comment ID
    Text
    Created by
    Timestamp

9️⃣ Notifications (Design Only – Optional)

    Notify user when:
    Task is assigned
    Status changes
    Due date is near
    Actual delivery (email / push) not implemented in LLD

1️⃣0️⃣ Concurrency Handling

    Multiple users can update tasks concurrently
    System should prevent:
    Inconsistent state
    Lost updates