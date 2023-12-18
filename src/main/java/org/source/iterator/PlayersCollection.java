package org.source.iterator;

import org.source.Player;
import org.source.iterator.base.Collection;
import org.source.iterator.base.Iterator;

public class PlayersCollection implements Collection {

    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    Player[] playersList;

    public PlayersCollection()
    {
        playersList = new Player[MAX_ITEMS];
    }

    @Override
    public Iterator createIterator() {
        return new PlayerIterator(playersList);
    }

    public void addItem(Player newPlayer)
    {
        Player player = new Player(newPlayer);
        if (numberOfItems >= MAX_ITEMS)
            System.err.println("Full");
        else
        {
            playersList[numberOfItems] = player;
            numberOfItems++;
        }
    }


}
