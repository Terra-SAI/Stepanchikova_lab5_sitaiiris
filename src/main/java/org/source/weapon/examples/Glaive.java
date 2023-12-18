package org.source.weapon.examples;

import org.source.weapon.base.Weapon;

public class Glaive extends Weapon {
    public Glaive(String weaponType, int damage) {
        super(weaponType, damage);
    }

    @Override
    public void damage() {
        System.out.println("Glaive damage");
    }
}
