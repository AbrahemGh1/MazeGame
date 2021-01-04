import Items.FlashLight;
import Items.Gold;
import Items.Key;
import wallObjects.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Direction {north, east, south, west}

public class test implements Serializable {

    static List<String> keysNames = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println("asdas");


        Room[][] map1 = new Room[4][4];
        mapInit(map1);

        Player player = new Player();
        player.addItem(new FlashLight());
        player.addItem(new Gold(1000));
        System.out.println("command 1");
        player.turnRight();
        System.out.println(player.look(map1[player.getX_Position()][player.getY_Position()]));
        player.check(map1[player.getX_Position()][player.getY_Position()]);
        player.forward();
        player.playerStatus();
        playerInputListnr(player,map1);
    }

    public static void mapInit(Room[][] map1) {
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[0].length; j++) {
                map1[i][j] = new Room();
            }
        }
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[0].length; j++) {
                Wall wall1 = new Wall();
                Wall wall2 = new Wall();
                Wall wall3 = new Wall();
                Wall wall0 = new Wall();
                map1[i][j].setWall(wall1, 1);
                map1[i][j].setWall(wall2, 2);
                map1[i][j].setWall(wall3, 3);
                map1[i][j].setWall(wall0, 0);
            }
        }

        Mirror mirror = new Mirror();
        Key key = new Key();
        key.setName("FirstRoom");
        mirror.addItems(key);
        map1[0][0].getWall(1).setWallObject(mirror);
        Door door1=new Door();
        door1.setOpen(false);
        door1.setNameNeededKey("FirstRoom");

        map1[0][0].getWall(2).setWallObject(door1);
        map1[1][0].getWall(0).setWallObject(new Door());
        map1[1][0].getWall(1).setWallObject(new Door());
        map1[1][0].getWall(2).setWallObject(new Mirror());
        map1[1][1].getWall(0).setWallObject(new Painting());
        map1[1][1].getWall(1).setWallObject(new Door());
        map1[1][1].getWall(2).setWallObject(new Chest());
        map1[1][1].getWall(3).setWallObject(new Door());
        map1[1][2].getWall(2).setWallObject(new Door());
        map1[1][2].getWall(3).setWallObject(new Door());
        Door door = new Door();
        door.setOpen(false);
        door.setNameNeededKey("FirstRoom");
        map1[2][1].getWall(1).setWallObject(door);
        map1[2][1].getWall(2).setWallObject(new Door());
        map1[2][1].getWall(3).setWallObject(new Painting());
        map1[2][2].getWall(0).setWallObject(new Door());
        map1[2][2].getWall(1).setWallObject(new Painting());
        map1[2][2].getWall(3).setWallObject(new Door());
        map1[3][1].getWall(0).setWallObject(new Door());
        map1[3][1].getWall(1).setWallObject(new Door());
        map1[3][2].getWall(0).setWallObject(new Seller());
        map1[3][2].getWall(1).setWallObject(new Door());
        map1[3][2].getWall(2).setWallObject(new Painting());
        map1[3][2].getWall(3).setWallObject(new Door());
        map1[3][3].getWall(3).setWallObject(new Door());


        map1[2][2].setDark(true);
        map1[3][2].setDark(true);
        map1[2][2].setSwitchLightExists(true);



    }



    public static void playerInputListnr(Player p, Room[][] map1) {
        System.out.println("Game Start!");
        Scanner s = new Scanner(System.in);
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            System.out.println("1-left  2-right  3-forward  4-backward  5-playerstatus  6-look" +
                    "   7-Check 8-Open\n    9-trade  10-Use flashlight   11-Use <name> Key   12-SwitchLights" +
                    "   13-quit  14-Restart");
            String playerInput = scanner.nextLine();
            switch (playerInput) {
                case "left":
                    break;

                case "right":
                    p.turnRight();
                    break;
                case "forward":
                    p.forward();
                    break;
                case "backward":
                    p.backward();
                    break;
                case "playerstatus":
                    p.playerStatus();
                    break;
                case "look":
                    p.look(map1[p.getX_Position()][p.getY_Position()]);
                    break;
                case "Check":
                    p.check(map1[p.getX_Position()][p.getY_Position()]);
                    break;
                case "Open":
                    Room r=map1[p.getX_Position()][p.getY_Position()];
                    WallObject wallObject=r.getWall(p.getDirectionInt()).getWallObject();
                    if(wallObject instanceof Door)
                        ((Door) wallObject).open();
                    break;
                case "Use flashlight":
                    p.useFlashLight(map1[p.getX_Position()][p.getY_Position()]);
                    break;
                case "Use name Key":
                    map1[p.getX_Position()][p.getY_Position()].getWall(p.getDirectionInt());
                    p.useKey("FirstRoom", map1[p.getX_Position()][p.getY_Position()].getWall(p.getDirectionInt()));

                    break;
                case "SwitchLights":
                    map1[p.getX_Position()][p.getY_Position()].SwitchLight();
                    break;
                case "quit":
                    exit=false;
                    System.exit(0);
                    break;
                case "Restart":
                    break;
                case "trade":
                    Room r2=map1[p.getX_Position()][p.getY_Position()];
                    WallObject wallObject2=r2.getWall(p.getDirectionInt()).getWallObject();
                    if(wallObject2 instanceof Seller)
                        ((Seller) wallObject2).startTrade(p);
                    break;
            }
        }
    }
}
