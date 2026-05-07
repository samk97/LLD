# Java LLD Practice

This repository is set up for practicing Low-Level Design (LLD) in Java.

## Setup
- **Java 17** (already installed)
- **Maven** (being installed)

## Project Structure
- `src/main/java`: Implementation code
- `src/test/java`: Unit tests (JUnit 5)
- `pom.xml`: Maven configuration (includes Lombok for cleaner code)

## How to run
To compile and run the project:
```bash
mvn clean compile exec:java -Dexec.mainClass="com.lld.parkinglot.ParkingLot"
```

## Useful Tools
- **Lombok**: Use `@Getter`, `@Setter`, `@NoArgsConstructor`, etc., to reduce boilerplate.
- **JUnit 5**: Standard testing framework for Java.

## Tips for LLD
1. **Gather Requirements**: Clarify functional and non-functional requirements.
2. **Identify Actors & Use Cases**: Who uses the system and what do they do?
3. **Class Diagram**: Define classes, attributes, and relationships (Composition > Inheritance).
4. **Design Patterns**: Apply patterns like Singleton, Factory, Strategy, Observer, etc., where appropriate.
5. **Implementation**: Code clearly with SOLID principles in mind.
