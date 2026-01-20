User Management

        Create a user
        Update user details
        Delete / deactivate a user
        View complete user profile
        Each user should be uniquely identifiable

Task Management

        Create a task with the following attributes:
        
                    taskId
                    taskName
                    description
                    createdBy
                    createdAt
                    lastModifiedAt
                    lastModifiedBy
                    assignedTo
                    dueDate
                    priority (LOW, MEDIUM, HIGH)
                    status (TODO, IN_PROGRESS, DONE, BLOCKED)
        
        Modify task fields:
        
                        Task name
                        Description
                        Assigned user
                        Due date
                        Priority
                        Status
        
        Delete a task

Task Lifecycle & Audit

        Track all state transitions of a task
        Maintain history of:
        
                    Previous state
                    New state
                    Timestamp
        
        User who made the change
        
        Invalid state transitions should be restricted
        (e.g., DONE → IN_PROGRESS)

4. Filtering, Searching, and Sorting

        Filter and search tasks based on:
                    Task name
                    Assigned user
                    Status
                    Priority
                    Due date                                                                                    
        
        Sort tasks based on:
                    
                    Creation date
                    Due date
                    Priority

5. Authorization (Optional / Advanced)

        Only authorized users should be allowed to:
                    
                    Modify a task
                    Delete a task
        
        Task updates may be restricted to:
                    
                    Task creator
                    Assigned user
                    Admin role