public class Zombie extends Monster { // child class of the monster class
    private int hpboost; // regenaration ability for zombie

    public Zombie(int hp, int level, int str, int hpboost) {
        super(hp, level, str);
        this.hpboost = hpboost;
    }

    public void setHpboost() {
        this.hpboost = hpboost;
    }

    public int getHpboost() {
        return this.hpboost;
    }

    public int heal() { // this method regenarates the health of the zombie by 1 hp each turn
        int healing = 1;

        if (healing == 1) {
            return ((getHp() - getHp()) + 1); // gets the health of the zombie and adds 1 hp to it
        } else {
            return 0;
        }
    }

    public int endFightExp() { // if the player kills this zombie, then he will receive 15 EXP
        if (this.getHp() <= 0) {
            return (15);
        } else {
            return (0);
        }
    }
}