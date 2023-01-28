# A1 - Piraten Karpen

-   Author: < Muhammed Ali Zia >
-   Email: < ziam8@mcmaster.ca >

## Build and Execution

-   To clean your working directory:
    -   `mvn clean`
-   To compile the project:
    -   `mvn compile`
-   To run the project in development mode (both random strategy players and without trace mode):
    -   `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
-   To run the project in trace mode and with strategies (combo & random):
    -   `mvn -q exec:java -Dexec.args="trace combo random"` (here, `-q` tells maven to be _quiet_)
-   To run the project without trace mode with strategies (random & combo):
    -   `mvn -q exec:java -Dexec.args="random combo"` (here, `-q` tells maven to be _quiet_)
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

| MVP? | Id  | Feature                                                                | Status | Started  | Delivered |
| :--: | :-: | ---------------------------------------------------------------------- | :----: | :------: | :-------: |
|  x   | F01 | Roll eight dices                                                       |   D    | 01/12/23 | 01/16/23  |
|  x   | F02 | Player keeping and rolling random dice at their turn (Random strategy) |   D    | 01/16/23 | 01/16/23  |
|  x   | F03 | Score points: number of gold + diamonds x 100                          |   D    | 01/12/23 | 01/16/23  |
|  x   | F04 | end of turn/no points with three or more skulls                        |   D    | 01/12/23 | 01/17/23  |
|  x   | F05 | Turn-based Functionality (Player 1 and player 2)                       |   D    | 01/16/23 | 01/17/23  |
|  x   | F06 | Track/display players' scores throughout the game                      |   D    | 01/17/23 | 01/18/23  |
|      | F07 | Play 42 games                                                          |   D    | 01/17/23 | 01/18/23  |
|      | F08 | Print percentage of wins for each player                               |   D    | 01/17/23 | 01/18/23  |
|      | F09 | Score Points via combos (3 of a kind, 4 of a kind etc...)              |   D    | 01/25/23 | 01/25/23  |
|      | F10 | maximizes combos while picking dices to reroll (Combo strategy)        |   D    | 01/25/23 | 01/26/23  |
|      | F11 | Let user decide between the strategies and trace mode                  |   D    | 01/25/23 | 01/26/23  |
|      | F12 | Implement Cards: Player draws cards                                    |   D    | 01/26/23 | 01/27/23  |
|      | F13 | Maximize combos of sabers when sea battle card drawn (sea battle strategy) |   D    | 01/26/23 | 01/27/23  |
| ...  | ... | ...                                                                    |
