package org.source.weapon.factory;

import org.source.weapon.base.Weapon;
import org.source.weapon.examples.Axe;
import org.source.weapon.examples.Glaive;
import org.source.weapon.examples.Rapier;
import org.source.weapon.examples.ShortKnife;

public class WeaponFactory {
    public Weapon createWeapon(String weaponType, int damage)
    {
        if (weaponType == null)
            return null;
        return switch (weaponType) {
            case "AXE" -> new Axe(weaponType, damage);
            case "GLAIVE" -> new Glaive(weaponType, damage);
            case "RAPIER" -> new Rapier(weaponType, damage);
            case "SHORT_KNIFE" -> new ShortKnife(weaponType, damage);
            default -> throw new IllegalArgumentException("Unknown weapon " + weaponType);
        };
    }
}
