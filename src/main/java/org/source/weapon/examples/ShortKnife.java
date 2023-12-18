package org.source.weapon.examples;

import org.source.weapon.base.Weapon;

public class ShortKnife extends Weapon {
    public ShortKnife(String weaponType, int damage) {
        super(weaponType, damage);
    }

    @Override
    public void damage() {
        System.out.println("Short knife damage");
    }
}
