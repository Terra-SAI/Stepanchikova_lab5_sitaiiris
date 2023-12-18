package org.source;

import org.source.weapon.base.Weapon;

import java.util.*;

public class Player {
    private String name;
    private String classDnD;
    private String raceDnD;
    private String background;
    private int level;
    private List<Weapon> weapon;

    public Player() {
        this.name = "Default";
        this.classDnD = "Druid";
        this.raceDnD = "Dragonborn";
        this.background = "Background";
        this.level = 0;
        this.weapon = new ArrayList<Weapon>();
    }

    public Player(String name,
                  String classDnD,
                  String raceDnD,
                  String background,
                  int level,
                  List<Weapon> weapon) {
        this.name = name;
        this.classDnD = classDnD;
        this.raceDnD = raceDnD;
        this.background = background;
        this.level = level;

        this.weapon = weapon;
    }

    public Player(Player player) {
        this.name = player.name;
        this.classDnD = player.classDnD;
        this.raceDnD = player.raceDnD;
        this.background = player.background;
        this.level = player.level;

        this.weapon = player.weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassDnD() {
        return classDnD;
    }

    public void setClassDnD(String classDnD) {
        this.classDnD = classDnD;
    }

    public String getRaceDnD() {
        return raceDnD;
    }

    public void setRaceDnD(String raceDnD) {
        this.raceDnD = raceDnD;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Weapon> getWeapon() {
        return weapon;
    }

    public void setWeapon(List<Weapon> weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Class: ").append(classDnD).append("\n");
        sb.append("Race: ").append(raceDnD).append("\n");
        sb.append("Background: ").append(background).append("\n");
        sb.append("Level: ").append(level).append("\n");

        sb.append("Weapons: \n");
        for (Weapon weapon : weapon) {
            sb.append("  Weapon Name: ").append(weapon.getName()).append("\n");
            sb.append("  Damage: ").append(weapon.getDamage()).append("\n");
        }
        return sb.toString();
    }
}