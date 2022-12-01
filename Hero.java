class Hero {
    private int level;
    private int exp;
    private int str;
    private int hp;
    private String name;

    public Hero(int level, int exp, int str, int hp, String name) {
        this.level = level;
        this.exp = exp;
        this.str = str;
        this.hp = hp;
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    public int getExp() {
        return this.exp;
    }

    public int getStr() {
        return this.str;
    }

    public int getHp() {
        return this.hp;
    }

    public String getName() {
        return this.name;
    }

    public String Stats() { // At the start of the game, the stats of the hero will be shown to the player
        return ("Name: " + this.name + "\nHealth: " + this.hp + "\nExp: " + this.exp + "\nStrength: " + this.str
                + "\nLevel: " + this.level);
    }

    public String isDead() { // If the hero dies in the game, all of the stats which he gathered will be shown to the player
        return ("---- THE LORD HAS CAPTURED YOUR SOUL ----" + "\n-------- Stats --------" + "\nName: " + this.name + "\nHealth: "
                + getHp() + "\nExp: " + getExp() + "\nStrength: " + getStr() + "\nLevel: " + getLevel());
    }

    public boolean levelUp() { // If the hero reaches 50 EXP, then he will move onto the next level
        if (getExp() >= 50) {
            return true;
        } else {
            return false;
        }
    }

    public int basicAttack() { // Increases the damage of the hero based on his level
        switch (getLevel()) {
            case 1:
                setStr(4);
                break;

            case 2:
                setStr(6);
                break;

            case 3:
                setStr(7);
                break;

            case 4:
                setStr(9);
                break;

            case 5:
                setStr(10);
                break;

            case 6:
                setStr(12);
                break;

            case 7:
                setStr(13);
                break;

            case 8:
                setStr(16);
                break;

            case 9:
                setStr(18);
                break;
            
            case 10:
                setStr(20);
                break;
            
            case 11:
                setStr(21);
                break;
            
            case 12:
                setStr(23);
                break;
            
            case 13:
                setStr(25);
                break;
        }
        return getStr();
    }

    public int specialAttack() { // Increases the special attack damage based on the level
        return getStr() + 4;
    }

    public boolean isAlive() { // Checks if the hero is alive or dead
        if (getHp() <= 0) {
            return false;
        } else {
            return true;
        }
    }

}