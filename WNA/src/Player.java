import Items.FlashLight;
import Items.Gold;
import Items.Item;
import Items.Key;
import wallObjects.Checkable;
import wallObjects.Door;
import wallObjects.WallObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
    private int X_Position = 0;
    private int Y_Position = 0;
    private Direction direction = Direction.east;

    public int getDirectionInt() {
        return directionInt;
    }

    private int directionInt = 1;
    private Gold gold = new Gold(500);
    private List<Item> playerItems = new ArrayList<Item>();

    public Player() {
        gold = new Gold();
    }

    public Gold getGold() {
        for (Item t :
                playerItems) {
        }
        return gold;
    }


    public void setGold(Gold gold) {
        this.gold = gold;

    }

    public int getX_Position() {
        return X_Position;
    }

    public void setX_Position(int x_Position) {
        X_Position = x_Position;
    }

    public int getY_Position() {
        return Y_Position;
    }

    public void setY_Position(int y_Position) {
        Y_Position = y_Position;
    }

    public void increasePlayerGold(int amount) {
        this.gold.setAmount(gold.getAmount() + amount);
    }

    public void decreasePlayerGold(int amount) {
        this.gold.setAmount(gold.getAmount() - amount);
    }

    public void addItem(Item item) {
        if (item instanceof Gold) {
            increasePlayerGold(((Gold) item).getAmount());
        } else
            this.playerItems.add(item);
    }

    public boolean DosePlayerHasItem(String item) {
        for (Item t :
                playerItems) {
            if (t.toString() == item.toString())
                return true;
        }
        return false;
    }

    public List<Item> getPlayerItems() {
        return playerItems;
    }

    public void setPlayerItems(List<Item> playerItems) {
        this.playerItems = playerItems;
    }

    public void useKey(String keyName, Wall wall) {
        for (Item item :
                playerItems) {
            if (item instanceof Key) {
                if (item.getName() == keyName) {
                    WallObject wallObject = wall.getWallObject();
                    if (wallObject instanceof Door) {
                        ((Door) wallObject).setOpenKey((Key) item);
                    }
                }
            }
        }
    }

    public void turnLeft() {
        if (direction == Direction.north) direction = Direction.west;
        else if (direction == Direction.west) direction = Direction.south;
        else if (direction == Direction.south) direction = Direction.east;
        else if (direction == Direction.east) direction = Direction.north;
        directionToInt();
    }

    public void turnRight() {
        if (direction == Direction.north) direction = Direction.east;
        else if (direction == Direction.east) direction = Direction.south;
        else if (direction == Direction.south) direction = Direction.west;
        else if (direction == Direction.west) direction = Direction.north;
        directionToInt();
    }

    public void forward(Door door) {
        if(door.isOpen()) {
            if (direction == Direction.north) X_Position--;
            else if (direction == Direction.west) Y_Position--;
            else if (direction == Direction.south) X_Position++;
            else if (direction == Direction.east) Y_Position++;
        }
        else System.out.println("can't go forward because door is closed");
    }

    public void backward(Door d) {
        if (direction == Direction.north) X_Position++;
        else if (direction == Direction.west) Y_Position++;
        else if (direction == Direction.south) X_Position--;
        else if (direction == Direction.east) Y_Position--;
    }

    public void playerStatus() {
        System.out.println("You Are Facing: " + direction);
        System.out.println("You Have " + gold.getAmount() + " gold");
        System.out.println("x " + X_Position + " y" + Y_Position);
    }

    public String look(Room room) {
        if (room.isDark()) return "Dark";
        else this.directionToInt();
        return room.getWalls()[directionInt].look();
    }

    public void directionToInt() {
        if (direction == Direction.north) directionInt = 0;
        else if (direction == Direction.east) directionInt = 1;
        else if (direction == Direction.south) directionInt = 2;
        else if (direction == Direction.west) directionInt = 3;
    }

    public String checkMirror(Room room) {
        if (room.isDark()) return "dark";
        else directionToInt();
        {
            if (room.getWalls()[directionInt].key) {
                room.getWalls()[directionInt].key = false;
                return room.getWalls()[directionInt].keyName_wall + " was acquired";
            } else return "no key here";
        }
    }

    public String checkPainting(Room room) {
        if (room.isDark()) return "dark";
        else directionToInt();
        if (room.getWalls()[directionInt].type == 5) {
            if (room.getWalls()[directionInt].key) {
                room.getWalls()[directionInt].key = false;
                return room.getWalls()[directionInt].keyName_wall + " was acquired";
            } else return "no key here";
        }
        return "no painting here ";
    }

    public String checkChest(Room room) {
        if (room.isDark()) return "dark";
        else directionToInt();
        if (room.getWalls()[directionInt].type == 1) {
            if (room.getWalls()[directionInt].key) {
                room.getWalls()[directionInt].key = false;
                return room.getWalls()[directionInt].keyName_wall + " was acquired";
            } else return "no key here";
        }
        return "no chest here ";
    }

    public String checkDoor(Room room) {
        if (room.isDark()) return "dark";
        else directionToInt();
        if (room.getWalls()[directionInt].type == 5) {
            if (room.getWalls()[directionInt].key) {
                room.getWalls()[directionInt].key = false;
                return room.getWalls()[directionInt].keyName_wall + " was acquired";
            } else return "no key here";
        }

        return "no door here ";
    }

    public void check(Room room) {
        if (room.getWalls()[directionInt].getWallObject() instanceof Checkable) {
            List list = ((Checkable) room.getWalls()[directionInt].getWallObject()).check();
            this.playerItems.addAll(list);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "X_Position=" + X_Position +
                ", Y_Position=" + Y_Position +
                ", direction=" + direction +
                ", directionInt=" + directionInt +
                ", gold=" + gold +
                ", playerItems=" + playerItems +
                '}';
    }

    public void PressSwitchLight(Room r) {
        if (r.isSwitchLightExists()) {
            r.setDark(false);
        } else
            System.out.println("No switchLight in Room.");
    }

    public void useFlashLight(Room r) {
        boolean flag = false;
        for (int i = 0; i < playerItems.size(); i++) {
            if (playerItems.get(i).getName() == FlashLight.name) {
                FlashLight f = (FlashLight) playerItems.get(i);
                f.setStatus(true);
                r.setDark(true);
                System.out.println("Flash Light On , Room is Lit.");
                flag = true;
            }
        }
        if (!flag)
            System.out.println("You don't have flash light.");
    }

    public void listAllItem() {
        for (Item i : playerItems) {
            System.out.println(i.toString());
        }
    }
}
