package org.parser;

import org.source.Player;
import org.source.iterator.base.Iterator;
import org.source.iterator.PlayersCollection;
import org.source.weapon.base.Weapon;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.source.weapon.factory.WeaponFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    private static final String XML_FILE = "src/main/resources/players.xml";

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(XML_FILE));

        Element rootNode = document.getDocumentElement();

        getMasterName(rootNode);

        Node playersNode = rootNode.getElementsByTagName("players").item(0);
        NodeList playerNodes = playersNode.getChildNodes();

        PlayersCollection players = getPlayers(playerNodes);
        Iterator iterator = players.createIterator();
        while (iterator.hasNext())
        {
            Player player = (Player)iterator.next();
            System.out.println(player.toString());
        }
    }

    private static void getMasterName(Node node)
    {
        String masterName = node.getAttributes().getNamedItem("game-master").getNodeValue();
        System.out.println("Game Master: " + masterName);
    }

    private static PlayersCollection getPlayers(NodeList playersList) {

        int length = playersList.getLength();
        PlayersCollection players = new PlayersCollection();

        for (int i = 0; i < length; i++) {
            Node node = playersList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Player player = getPlayer(element);
                players.addItem(player);
            }
        }
        return players;
    }

    private static Player getPlayer(Element element) {

        String name = getPlayerDetails(element, "name");
        String classDnd = getPlayerDetails(element, "class");
        String raceDnD = getPlayerDetails(element, "race");
        String background = getPlayerDetails(element, "background");
        int level = Integer.parseInt(getPlayerDetails(element, "level"));

        Node weaponsNode = element.getElementsByTagName("weapons").item(0);
        NodeList weaponNodes = weaponsNode.getChildNodes();
        List<Weapon> weapons = getWeapons(weaponNodes);

        return new Player(name, classDnd, raceDnD, background, level, weapons);
    }

    private static String getPlayerDetails(Element element, String property) {
        return element.getElementsByTagName(property).item(0).getTextContent();
    }

    private static List<Weapon> getWeapons(NodeList weaponsList) {

        int length = weaponsList.getLength();
        List<Weapon> weapons = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            Node node = weaponsList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Weapon weapon = getWeapon(element);
                weapons.add(weapon);
            }
        }
        return weapons;
    }

    private static Weapon getWeapon(Element element) {

        String weaponName = getPlayerDetails(element, "weapon-name");
        int damage = Integer.parseInt(getPlayerDetails(element, "damage"));

        WeaponFactory weaponFactory = new WeaponFactory();

        return weaponFactory.createWeapon(weaponName, damage);
    }

    private static String getWeaponDetails(Element element, String property) {
        return element.getElementsByTagName(property).item(0).getTextContent();
    }
}