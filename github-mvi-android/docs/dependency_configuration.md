# Dependency Configurations

## Gradle Dependency Configuration

Each module contains its own `build.gradle` to declare the correct build & flavor configurations, and android project configuration.
All dependency versioning is managed through a single gradle file `dependencies.gradle` to prevent multiple versions of the same dependency from being used and to keep
version consistency across all project modules.

When adding a new dependency, it should first be declared under `dependencies.gradle`, followed by declaring them within each module where it needs to be compiled.