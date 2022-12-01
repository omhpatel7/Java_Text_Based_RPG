class Monster { // parent class
    private int hp; // health points for the enemies
    private int level; // level of enemies
    private int str; // damage of the enemies

    public Monster(int hp, int level, int str) {
        this.hp = hp;
        this.level = level;
        this.str = str;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getHp() {
        return this.hp;
    }

    public int getLevel() {
        return this.level;
    }

    public int getStr() {
        return this.str;
    }

    public int basicAttack() {
        return getStr();
    }

    public int Health(Hero hero) { // this method randomizes the strength, health and level of the monster

        switch (hero.getLevel()) { // based on the hero's level, the monster/zombie will have the following stats
        
            case 1:
                setHp(9);
                setStr(1);
                setLevel(1);
                break;
            case 2:
                setHp(15);
                setStr(2);
                setLevel(2);
                break;
            case 3:
                setHp(8);
                setStr(6);
                setLevel(3);
                break;
            case 4:
                setHp(30);
                setStr(1);
                setLevel(4);
                break;
            case 5:
                setHp(20);
                setStr(10);
                setLevel(5);
                break;

             case 6:
                setHp(200);
                setStr(2);
                setLevel(6);
                break;

             case 7:
                setHp(60);
                setStr(3);
                setLevel(7);
                break;

             case 8:
                setHp(400);
                setStr(2);
                setLevel(8);
                break;

            case 9:
                setHp(40);
                setStr(10);
                setLevel(9);
                break;

            case 10:
                setHp(100);
                setStr(4);
                setLevel(10);
                break;

            case 11:
                setHp(200);
                setStr(1);
                setLevel(11);
                break;

            case 12:
                setHp(15);
                setStr(100);
                setLevel(12);
                break;

            case 13:
                setHp(40);
                setStr(15);
                setLevel(13);
                break;
        }
        return getHp();
    }

    public boolean isDead() { // this method checks if the monster/zombie is dead
        if (getHp() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public int endFightExp() { // if the monster is killed, the player will get 20 EXP
        if (this.getHp() <= 0) {
            return (20);
        } else {
            return (0);
        }
    }
}