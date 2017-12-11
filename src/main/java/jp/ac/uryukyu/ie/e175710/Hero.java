package jp.ac.uryukyu.ie.e175710;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing {


    public Hero(String name, int maximumHP, int attack) {
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
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", na);
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
                if (bigDamage <= 4) {
                    System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", na, opponent.getName(), damage * 2);
                    opponent.wounded(damage*2);
                } else {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", na, opponent.getName(), damage);
                    opponent.wounded(damage);
                }
            }
        }
    }
}