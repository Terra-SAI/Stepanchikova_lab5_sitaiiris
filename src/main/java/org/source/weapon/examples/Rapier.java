package org.source.weapon.examples;

import org.source.weapon.base.Weapon;

public class Rapier extends Weapon {
    public Rapier(String weaponType, int damage) {
        super(weaponType, damage);
    }

    @Override
    public void damage() {
        System.out.println("Rapier damage");
    }
}
