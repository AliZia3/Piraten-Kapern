# A1 - Piraten Karpen

-   Author: < Muhammed Ali Zia >
-   Email: < ziam8@mcmaster.ca >

## Build and Execution

-   To clean your working directory:
    -   `mvn clean`
-   To compile the project:
    -   `mvn compile`
-   To run the project in development mode:
    -   `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
-   To package the project as a turn-key artefact:
    -   `mvn package`
-   To run the packaged delivery:
    -   `java -jar target/piraten-karpen-jar-with-dependencies.jar`

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

-   Status:
    -   Pending (P), Started (S), Blocked (B), Done (D)
-   Definition of Done (DoD):
    -   < The criteria that will decide that a feauture is done is if it functions according to the rulebook and works smoothly with all the other features>

### Backlog

| MVP? | Id  | Feature                                              | Status | Started  | Delivered |
| :--: | :-: | ---------------------------------------------------- | :----: | :------: | :-------: |
|  x   | F01 | Roll a dice                                          |   D    | 01/01/23 | 01/12/23  |
|  x   | F02 | Roll eight dices                                     |   D    | 01/12/23 | 01/16/23  |
|  x   | F03 | Player keeping and rolling random dice at their turn |   D    | 01/16/23 | 01/16/23  |
|  x   | F04 | Score points: number of gold + diamonds x 100        |   D    | 01/12/23 | 01/16/23  |
|  x   | F05 | end of turn/no points with three or more skulls      |   D    | 01/12/23 | 01/17/23  |
|  x   | F06 | Turn-based Functionality                             |   D    | 01/16/23 | 01/17/23  |
|  x   | F07 | Track players' scores                                |   D    | 01/17/23 | 01/17/23  |
|      | F08 | Play 42 games                                        |   D    | 01/17/23 | 01/18/23  |
|      | F09 | Print percentage of wins for each player             |   D    | 01/17/23 | 01/18/23  |
| ...  | ... | ...                                                  |
