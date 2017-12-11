package jp.ac.uryukyu.ie.e175710;

public class Enemy extends LivingThing {

    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }


    @Override
    public void wounded(int damage) {
        int hp = getHitPoint();
        String na = getName();
        boolean de = getIsdead();

        hp -= damage;
        setHitPoint(hp);
        if (hp < 0) {
            de = true;
            setIsdead(de);
            System.out.printf("モンスター%sは倒れた。\n", na);
        }
    }

}