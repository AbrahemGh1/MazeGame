import Items.FlashLight;
import Items.Gold;
import Items.Key;
import wallObjects.Chest;
import wallObjects.Door;
import wallObjects.Mirror;
import wallObjects.Painting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Direction{north,east,south,west}
public class test implements Serializable {

    static List<String> keysNames = new ArrayList<String>();
    public static void main(String[] args) {

//        Room[][] map1=new Room[1][1];
//        map1[0][0]=new Room();
//        Wall w= new Wall();
//        w.setWallObject(new wallObjects.Door());
//        map1[0][0].setWall(w,0);
//        System.out.println(map1[0][0].getWalls()[0].getWallObject().getObjectName());
//        Room r = new Room();
//        Wall w = new Wall();
//        w.setWallObject(new wallObjects.Door());
//        r.setWall(w,0);
//        System.out.println(r.getWalls()[0].getWallObject().getObjectName());
////////
//        Seller seller= new Seller();
//        seller.setSellerGold(new Gold(600));
//
//        Key keyItem= new Key();
//        keyItem.setId(1);
//        keyItem.setName("FirstDoorKey");
//        keyItem.setPrice(new Gold(200));
//
//
//        Key key2Item= new Key();
//        key2Item.setId(2);
//        key2Item.setName("SecondDoorKey");
//        key2Item.setPrice(new Gold(350));
//        seller.listSellerItems();
//
//
//
//        FlashLight flashLightItem= new FlashLight();
//        flashLightItem.setPrice(new Gold(750));
//
//
//
//        seller.addToSellerList(keyItem);
//        seller.addToSellerList(flashLightItem);
//        seller.addToSellerList(key2Item);
//
//        System.out.println();
//        seller.listSellerItems();
//
//        Key mk= new Key();
//        mk.setId(0);
//        mk.setName("key1");
//        mk.setPrice(new Gold(100));
//
//        Key mk2= new Key();
//        mk2.setId(0);
//        mk2.setName("key2");
//        mk2.setPrice(new Gold(200));
//
//        Key mk3= new Key();
//        mk3.setId(0);
//        mk3.setName("key3");
//        mk3.setPrice(new Gold(300));
//
//        seller.addToPriceList(mk.toString());
//        seller.addToPriceList(mk2.toString());
//        seller.addToPriceList(mk3.toString());

//        Player player= new Player();
//        player.gold= new Gold(800);
//        player.addItem(mk);
//        player.addItem(mk2);
//        player.addItem(mk3);
//        seller.startTrade(player);

        Room[][] map1 = new Room[4][4];
        mapInit(map1);

        Player player=new Player();
        player.addItem(new FlashLight());
        player.addItem(new Gold(1000));
        //order(map1,player);
        System.out.println("command 1");
        player.turnRight();
        System.out.println(player.look(map1[player.getX_Position()][player.getY_Position()]));
        player.check(map1[player.getX_Position()][player.getY_Position()]);
        player.forward();
        player.playerStatus();



//        Room room=new Room();
//        Player p= new Player();
//
////        Wall w2=new Wall();
////        Mirror m= new Mirror();
////        m.addItems(new FlashLight());
////        w2.setWallObject(m);
////        room.setWall(w2,1);
////        System.out.println( p.look(room));
////        p.check(room);
////
////        p.turnRight();
////        Wall w3=new Wall();
////        Painting painting = new Painting();
////        p.addItem(new Key());
////        w3.setWallObject(painting);
////        room.setWall(w3,2);
////        System.out.println( p.look(room));
////        p.turnRight();
//
//
//        Wall w4=new Wall();
//        Chest chest= new Chest();
//        chest.addItems(new Gold(200));
//        w4.setWallObject(chest);
//        room.setWall(w4,3);
//        System.out.println( p.look(room));
//        p.turnRight();
//
//        Wall w1=new Wall();
//        w1.setWallObject(new Door());
//        room.setWall(w1,0);
//
//
//
//        System.out.println( p.look(room));








    }
    public static void mapInit(Room[][] map1){
        for (int i = 0; i < map1.length ;i++){
            for (int j = 0; j < map1[0].length ;j++){
                map1[i][j]=new Room();
            }
        }
        for (int i = 0; i < map1.length ;i++){
            for (int j = 0; j < map1[0].length ;j++){
                Wall wall1=new Wall();
                Wall wall2=new Wall();
                Wall wall3=new Wall();
                Wall wall0=new Wall();
                map1[i][j].setWall(wall1,1);
                map1[i][j].setWall(wall2,2);
                map1[i][j].setWall(wall3,3);
                map1[i][j].setWall(wall0,0);
            }
        }

        Mirror mirror= new Mirror();
        Key key= new Key();
        key.setName("FirstRoom");
        mirror.addItems(key);
        map1[0][0].getWall(1).setWallObject(mirror);

        map1[0][0].getWall(2).setWallObject(new Door());
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
        playerInputListnr();



    }

    public static void order(Room[][] map1,Player player){
        Scanner scanner=new Scanner(System.in);
        String command=scanner.next();

    }


    public static void playerInputListnr(){
        System.out.println("Game Start!");
        Scanner s= new Scanner(System.in);
                boolean exit =false;
        Scanner scanner=new Scanner(System.in);
        while (!exit){
            System.out.println("1-left  2-right  3-forward  4-backward  5-playerstatus  6-look" +
                    "   7-Check 8-Open\n9-trade  10-Use flashlight   11-Use <name> Key   12-SwitchLights" +
                    "   13-quit  14-Restart");





        }

    }


}
