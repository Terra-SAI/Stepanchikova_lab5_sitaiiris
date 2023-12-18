package org.source.weapon.base;

public abstract class Weapon
        implements Damage {

    private String weaponType;
    private int damage;

    public Weapon(String weaponType, int damage) {
        this.weaponType = weaponType;
        this.damage = damage;
    }

    public String getName() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}