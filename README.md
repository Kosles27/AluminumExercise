# AluminumExercise
This project demonstrates using the [Alumnium](https://github.com/alumnium-hq/alumnium) library for AI powered browser automation.
The actual automation is written in Python and executed from a JUnit test which also generates an ExtentReport.

## Running the test

1. Ensure Python dependencies are installed:
   ```bash
   pip install -r requirements.txt
   ```
2. Execute the JUnit test with Gradle:
   ```bash
   ./gradlew test
   ```
   The Extent report will be generated at `lib/build/reports/extent-report.html`.
