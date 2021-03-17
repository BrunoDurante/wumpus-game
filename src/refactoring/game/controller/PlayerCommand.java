package refactoring.game.controller;

public interface PlayerCommand {
    void walk(int linePosition, int columnPosition, int direction);

    void shoot();

    int turnRight(int direction);

    int turnLeft(int direction);
}
