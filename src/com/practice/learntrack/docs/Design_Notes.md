### Why you used ArrayList instead of array
- a regular array has a fixed size whereas an ArrayList can dynamically resize itself.
- ArrayList provides built-in methods for adding, removing, and accessing elements.

### Where you used static members and why
- Static members are used in `IdGenerator` to maintain the IDs across all instances of the class.
- Static members are also used in `Main` to provide a way to call methods without creating an instance of the class.

### Where you used inheritance and what you gained from it
- Inheritance is used in `Student` and `Trainer` classes that extend `Person`.
- This allows for code reuse by inheriting common fields and methods from the parent class.
- It also enables polymorphism, allowing different types of people (students and trainers) to be treated as instances of the parent class.