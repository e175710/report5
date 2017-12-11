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
    public void attack(LivingThing opponent) {
        boolean de = getIsdead();
        String na = getName();
        int at = getAttack();
        if (isDead() == false) {
            int damage = (int) (Math.random() * at);
            int bigDamage = (int) (Math.random() * 10);
            if (damage == 0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", na, opponent.getName());
            } else {
                if (bigDamage <= 3) {
                    System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", na, opponent.getName(), damage * 2);
                    opponent.wounded(damage*2);
                } else {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", na, opponent.getName(), damage);
                    opponent.wounded(damage);
                }
            }
        }
    }

}