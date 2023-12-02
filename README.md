# Scrum Simulator

## Overview

Please write overview here

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [ScrumSimulator](#scrum-simulator-1)

## Features

- Authentication with three user types: DEVELOPER, SCRUM_MASTER, and PRODUCT_OWNER.
- Simulation of Scrum processes for collaborative development.
- Frontend built with SwingUI for a user-friendly interface.
- Maven build system for project management.

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites

- Java Development Kit (JDK) [21]
- Maven [3.9.2]

## Installation

1. Clone the repository:

   ```bash
    git clone https://github.com/KirtanSoni/SER515_Group_Soni.git
   ```

2. Move to the Cloned Directory:

    ```bash
    cd scrum-simulator
    ```
3. Build Maven

    ```bash
    mvn clean install
    ```

## Usage

1. Run the test cases: (optional)

   Mac Run command:
   ```bash
   sh run.sh
   ```

```bash
   mvn test
   start target/surefire-reports/index.html  # For Windows
   open target/surefire-reports/index.html  # For macOS
```

2. Run the Application through SwingUI:

    ```bash
    java -jar target/scrum-simulator.jar
    ```

## Contributing

- Kirtan Soni (Team Leader)
- Shubham Shah
- Monil Prajapati
- Janmay Bhatt
- Neel Shah


## Scrum Simulator

- The authentication makes it secure by making restricted users onlyAllow Access.
- There is Simulation Game for scrum process
- It contains features for the Product backlog and SprintBacklog functionalities with helper functions.\
- There is BurntDown Chart which shows when and how much project tasks are been completed.
- There is Project Progress Bar displaying current progress percentage status.
- It contains feature for working with User Stories and managing it.
- The Database takes care of the permanent storage of Users, UserStories, backlogs, BurntDown chart and Project Progress.
- The BusinessValue and DeveloperValue are also taken into consideration in this Scrum Simulator.
