/*
Simple RPG Game
Name: Om Patel

Function: This is a simple rpg game where the player will have to face endless waves of monsters. Other instructions are given at the start of the game.
*/

import java.util.Scanner;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Monster monster = new Monster(14, 2, 3); // import monster class
        Zombie zombie = new Zombie(25, 1, 1, 15); // import zombie class

        // Asks the player for the name of their character
        System.out.println("Name Your Character: ");
        String name = scanner.nextLine();
        Hero hero = new Hero(1, 0, 4, 25, name); // import hero class
        System.out.println("\n" + hero.Stats()); // prints the stats of the character at the start

        instructions(); // calls in the method "instructions"
        int start = scanner.nextInt();

        if (start == start) { // if player types any number, the game will start
            for (int i = 0; i < 10000; i++) {
                if (i % 4 == 0 && i != 0) { // every fourth monster, the hero will regain 3 hp
                    hero.setHp(hero.getHp() + 3);
                    System.out.println("**** You have replenished 3 health points!! ****");
                }
                battle(hero, rand, monster, zombie, scanner); // calls in the battle method
            }
        }
    }

    public static void battle(Hero hero, Random rand, Monster monster, Zombie zombie, Scanner scanner) {

        monster.setHp(monster.Health(hero)); // sets the monster's difficulty according to the level of the hero
        int choice = 0;
        int count = 0;
        int secondsToSleep = 1;

        try { // after every fight, the player will have approximatley 2 seconds of dealy time
            Thread.sleep(secondsToSleep * 2000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        String[] enemies = { "Monster", "Zombie" };
        String enemy = enemies[rand.nextInt(enemies.length)]; // picks between the two enemy types

        if (enemy.equals("Monster")) { // if the roll is "monster", then this if statement will be executed

            System.out.println("\n---------- A Monster Approaches ----------");
            System.out.println("\nMonster HP: " + monster.getHp() + "\nMonster Dmg: " + monster.getStr());
            System.out.println("\nYour HP: " + hero.getHp());
            System.out.println("What would you like to do?");
            System.out.println("\nPress 1. Attack - " + hero.basicAttack());
            System.out.println("Press 2. Special Attack - " + hero.specialAttack() + "\n");

            while (monster.getHp() > 0) { // this loop will continue to exectue until the monster is killed
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: // if player types "1", then normal attack will be executed
                        monster.setHp(monster.getHp() - hero.basicAttack());
                        System.out.println("\nYou attacked the monster for " + hero.getStr() + " damage.");
                        break;

                    case 2: // if player types "2". then special attack will be exectued
                        if (count == 0) {
                            monster.setHp(monster.getHp() - hero.specialAttack());
                            System.out.println("\nYou attacked the monster for " + hero.specialAttack() + " damage.");
                            count++;
                            break;
                        } else {
                            System.out.println("*** CANNOT USE ***");
                            break;
                        }
                    default: // if "1" or "2" are not picked, then it will tell the player to insert 1 or 2
                        System.out.println("Please Insert 1 or 2!");
                        break;
                }

                if (monster.isDead() == true) { // if monster is dead, the hero will get EXP
                    System.out.println("\nThe Monster Has Died!");
                    hero.setExp(hero.getExp() + monster.endFightExp());
                    System.out.println("\nYou have gained: " + monster.endFightExp() + " EXP");
                    expGain(hero, monster, zombie);
                    break;
                } else if (monster.isDead() == false && choice == 1 || choice == 2) { // if monster is not dead, then the monster will attack the hero
                    System.out.println("\nThe Monster attacked you for " + monster.getStr() + " damage.");
                    hero.setHp(hero.getHp() - monster.basicAttack());
                    System.out.println("\nYour HP: " + hero.getHp());
                }

                if (hero.isAlive() == false) { // if hero is dead, then is stats will be shown before the program ends
                    System.out.println(hero.isDead());
                    System.exit(0);
                } else { // if the hero is alive, then the loop will continue
                    System.out.println("\nMonster HP: " + monster.getHp());
                    System.out.println(
                            "\n---------- Pick an Action ----------\n1. Attack - " + hero.basicAttack() + "\n");
                    System.out.println("2. Special Attack - " + hero.specialAttack() + "\n");
                }
            }

        } else if (enemy.equals("Zombie")) { // if the roll is "zombie" then this if - statement will be executed

            zombie.setHp(zombie.Health(hero)); // sets the strength of the zombie according to the level of the hero
            System.out.println("\n---------- A Zombie Approaches ----------");
            System.out.println("\nZombie HP: " + zombie.getHp() + "\nZombie Dmg: " + zombie.getStr());
            System.out.println("\nYour HP: " + hero.getHp());
            System.out.println("What would you like to do?");
            System.out.println("\n\nPress 1. Attack - " + hero.basicAttack());
            System.out.println("Press 2. Special Attack - " + hero.specialAttack() + "\n");

            while (zombie.getHp() > 0) {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: // if player types "1", normal attack
                        zombie.setHp(zombie.getHp() - hero.basicAttack());
                        System.out.println("\nYou attacked the zombie for " + hero.getStr() + " damage.");
                        break;

                    case 2: // if player types "2". special attack
                        if (count == 0) {
                            zombie.setHp(zombie.getHp() - hero.specialAttack());
                            System.out.println("\nYou attacked the zombie for " + hero.specialAttack() + " damage.");
                            count++;
                            break;
                        } else {
                            System.out.println("*** CANNOT USE ***");
                            count = 2;
                            break;
                        }

                    default: // if any other number is typed, the program will prompt user to insert 1 or 2
                        System.out.println("Please Insert 1 or 2!");
                }

                if (zombie.isDead() == true) { // if zombie is dead, hero will gain EXP
                    System.out.println("\nThe Zombie Has Died!");
                    hero.setExp(hero.getExp() + zombie.endFightExp());
                    System.out.println("\nYou have gained: " + zombie.endFightExp() + " EXP");
                    expGain(hero, monster, zombie);
                    break;
                } else if (zombie.isDead() == false && choice == 1 || choice == 2) { // if zombie is not dead, then the zombie will attack the hero
                    System.out.println("\nThe zombie attacked you for " + zombie.getStr() + " damage.");
                    hero.setHp(hero.getHp() - zombie.basicAttack());
                    System.out.println("\nYour HP: " + hero.getHp());

                    if (hero.isAlive() == false) { // if hero is dead, the program will show his stats before ending the program
                        System.out.println(hero.isDead());
                        System.exit(0);
                    } else { // if the hero is alive, then the loop will continue
                        System.out.println("\nThe Zombie Healed For: " + zombie.heal());
                        zombie.setHp(zombie.getHp() + zombie.heal());
                        System.out.println("Zombie HP: " + zombie.getHp());
                        System.out.println("\n---------- Pick an Action ----------\n\n1. Attack - " + hero.basicAttack());
                        System.out.println("2. Special Attack - " + hero.specialAttack() + "\n");
                    }
                }
            }
        }
    }

    public static void expGain(Hero hero, Monster monster, Zombie zombie) { // this method is used to give hero EXP and checks if the hero leveled up or not

        if (hero.levelUp() == true) {
            hero.setLevel(hero.getLevel() + 1);
            hero.setExp(hero.getExp() - 50);
            System.out.println("\nCongratulations, you are now Level: " + hero.getLevel());
            System.out.println("Basic Attack = " + hero.basicAttack() + "\nSpecial Attack = " + hero.specialAttack());
            System.out.println("\nYou have a total of: " + hero.getExp() + "/50 EXP");
        } else {
            System.out.println("You have a total of: " + hero.getExp() + "/50 EXP");
        }
    }

    public static void instructions() { // method to print out the instructions of the game
        System.out.println("---------- INSTRUCTIONS ----------");
        System.out.println(
                "This will be a bloody and endless battle until your soul is captured by the LORD OF THE ABYSS. Try to stay away from the monsters, they will try to suck your soul. If you ever come across a zombie, the battle might get hard as they have a regenaration ability per turn.\n \nIMPORTANT: MAXIMUM OF 1 SPECIAL ATTACK USAGE PER MONSTER BATTLE. If you try to use the special attack more then once, the enemy will do damage do you for that turn but you will not be able to do damage that turn \nPress any number to begin your tragic life:");
    }
}