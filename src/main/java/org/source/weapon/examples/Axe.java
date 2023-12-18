package org.source.weapon.examples;

import org.source.weapon.base.Weapon;

public class Axe extends Weapon {
    public Axe(String weaponType, int damage) {
        super(weaponType, damage);
    }

    @Override
    public void damage() {
        System.out.println("Axe damage");
    }
}
