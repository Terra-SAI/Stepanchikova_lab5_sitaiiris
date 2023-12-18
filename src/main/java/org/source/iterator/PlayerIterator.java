package org.source.iterator;

import org.source.Player;
import org.source.iterator.base.Iterator;

public class PlayerIterator implements Iterator {
    Player[] playersList;
    int pos = 0;

    public PlayerIterator(Player[] playersList)
    {
        this.playersList = playersList;
    }

    public Object next()
    {
        Player player =  playersList[pos];
        pos += 1;
        return player;
    }

    public boolean hasNext()
    {
        return pos < playersList.length &&
                playersList[pos] != null;
    }
}
