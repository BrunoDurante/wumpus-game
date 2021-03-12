package refactoring.game.controller;

import refactoring.game.entities.Cave;

public class Game {

    public Cave cave;

    public static void main(String[] args){
        Manager manager = new Manager();
        manager.startGame();
        manager.createElements();


    }

}
