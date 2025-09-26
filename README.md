# Human Readable Duration Format

Convert seconds into a human-readable duration string (Java).

## Description
This project is a Java solution for the [Codewars kata "Human Readable Duration Format"](https://www.codewars.com/kata/52742f58faf5485cae000b9a).  
It formats a duration in seconds into a natural, human-readable string using years, days, hours, minutes and seconds.

The implementation includes:
- A clean and extensible `HumanReadableDurationFormat` class
- Unit tests written with JUnit 5
- A simple `main` method with sample outputs

## Examples
```
0 seconds                        -> "now"
2 second                         -> "2 seconds"
60 + 2 seconds                   -> "1 minute and 2 seconds"
2 * 60 * 60 + 60 + 1 seconds     -> "2 hours, 1 minute and 1 second"
365 * 24 * 60 * 60 seconds       -> "1 year"
365 * 24 * 60 * 60 + 60 seconds  -> "1 year and 1 minute"
```

## How to Run

### Prerequisites
- Java 21 or later
- Maven 3.9+

### Build and run tests
```bash
mvn clean test
```

### Run the sample `main` method
```bash
mvn clean compile exec:java -Dexec.mainClass="hu.webstar.Main"
```

## Project Structure
```
src/
 ├── main/java/hu/webstar/
 │    ├── HumanReadableDurationFormat.java
 │    └── Main.java
 └── test/java/hu/webstar/
      └── HumanReadableDurationFormatTest.java
```

## License
This project is licensed under the MIT License – see the [LICENSE](LICENSE) file for details.
