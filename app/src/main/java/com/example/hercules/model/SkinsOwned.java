package com.example.hercules.model;

public enum SkinsOwned {
    DEFAULT, RED,PURPLE,TURTLE,WIZARD,EMERALD,FIRE,GOD;

    public SkinsOwned next() {
        SkinsOwned next = values()[(this.ordinal() + 1)% values().length];
        return next;
    }

    public SkinsOwned prev() {
        SkinsOwned prev = values()[Math.abs((this.ordinal() - 1)%values().length)];
        return prev;
    }
}
