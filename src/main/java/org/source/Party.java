package org.source;

import org.source.iterator.PlayersCollection;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private String masterName;
    private PlayersCollection playersCollection;

    public Party()
    {
        this.masterName = "Master";
        this.playersCollection = new PlayersCollection();
    }

    public Party(String masterName, PlayersCollection playersCollection)
    {
        this.masterName = masterName;
        this.playersCollection = playersCollection;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public PlayersCollection getPlayerList() {
        return playersCollection;
    }

    public void setPlayerList(PlayersCollection playersCollection) {
        this.playersCollection = playersCollection;
    }
}
