# My Agent

A simple time-based greeting agent built with Java and Maven.

## Project Structure

```
my_agent/
├── src/main/java/com/example/agent/
│   ├── HelloTimeAgent.java      # Main agent code
│   └── AgentCliRunner.java      # Command-line interface
├── pom.xml                      # Maven project configuration
├── env-template                 # Environment variables template
└── README.md                    # This file
```

## Features

- **HelloTimeAgent**: Provides time-based greetings and demonstrations
- **AgentCliRunner**: Command-line interface for interacting with the agent
- **Maven Configuration**: Ready-to-use build configuration with testing support

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Building the Project

```bash
mvn clean compile
```

### Running the Application

#### Basic usage (shows greeting and demo):
```bash
mvn exec:java
```

#### With personalized greeting:
```bash
mvn exec:java -Dexec.args="YourName"
```

#### Running directly with Java:
```bash
# Compile first
mvn clean compile

# Run the main class
java -cp target/classes com.example.agent.AgentCliRunner

# Or with a name
java -cp target/classes com.example.agent.AgentCliRunner Alice
```

### Building a Fat JAR

```bash
mvn clean package
java -jar target/my-agent-1.0.0.jar
```

### Running Tests

```bash
mvn test
```

## Environment Configuration

1. Copy `env-template` to `.env`:
   ```bash
   cp env-template .env
   ```

2. Edit `.env` to add your API keys and configuration:
   ```bash
   # API Keys
   OPENAI_API_KEY=your_actual_key_here
   GOOGLE_API_KEY=your_actual_key_here
   ```

## Maven Commands

- `mvn clean compile` - Compile the project
- `mvn clean package` - Build JAR file
- `mvn clean test` - Run tests
- `mvn exec:java` - Run the application
- `mvn clean install` - Install to local repository

## Development

The project is structured as a standard Maven project:

- Source code: `src/main/java/`
- Test code: `src/test/java/` (create this directory for tests)
- Resources: `src/main/resources/`
- Configuration: `pom.xml`

## Next Steps

1. Rename `env-template` to `.env` and configure your environment variables
2. Remove the old `src/Main.java` file
3. Remove the `my_agent.iml` file (IntelliJ will regenerate it)
4. Start developing your agent functionality in `HelloTimeAgent.java`