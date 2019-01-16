# Code Coverage

## Generating a Coverage Report
A code coverage report can be generated  using the `test<AppVariant>UnitTestCoverage` task (e.g `testDebugUnitTestCoverage`, `testDevelopDebugUnitTestCoverage`).<br/>
The generated report HTML can be found in each module's corresponding /build/reports/jacoco/ directory.

## Coverage Verification

Code coverage can be verified using the `test<AppVariant>UnitTestCoverageVerification` task.
The minimum code-coverage percentage is 60% by default.
This can be changed by changing the value of `MINIMUM_COVERAGE` in `coverage.gradle`