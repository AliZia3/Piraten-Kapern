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
    -   < The criteria that will decide that a feauture is done is if it functions according to the rulebook >

### Backlog

| MVP? | Id  | Feature                                        | Status  | Started  | Delivered |
| :--: | :-: | ---------------------------------------------- | :-----: | :------: | :-------: |
|  x   | F01 | Roll a dice                                    |    D    | 01/01/23 | 01/12/23  |
|  x   | F02 | Roll eight dices                               |    D    | 01/12/23 | 01/15/23
|  x   | F03 | end of game with three skulls                  | B (F02) |          |
|  x   | F04 | Score points: Count number of gold coins x 100 |    P    |          |
|  x   | F05 | Score points: Count number of diamonds x 100   |    P    |          |
|  x   | F06 | Player keeping random dice at their turn       |    P    |          |
|  x   | F07 | Play 42 games                                  |    P    |          |
|  x   | F08 | Print percentage of wins for each player       |    P    |          |
| ...  | ... | ...                                            |
