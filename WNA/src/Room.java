import java.io.Serializable;

public class Room implements Serializable {

    private boolean dark=false, switchLightExists =false;
    private Wall[] walls=new Wall[4];

    public void SwitchLight(){
        switchLightExists=!switchLightExists;
    }

    public Room() {
        for (int i=0; i<4; i++){
        walls[i]=new Wall();
        }
    }
    public void addWall(Wall wall,int index){
        walls[index]=wall;
    }

    public boolean isDark() {
        return dark;
    }

    public void setDark(boolean dark) {
        this.dark = dark;
    }

    public boolean isSwitchLightExists() {
        return switchLightExists;
    }

    public void setSwitchLightExists(boolean switchLightExists) {
        this.switchLightExists = switchLightExists;
    }

    public Wall[] getWalls() {
        return walls;
    }

    public Wall getWall(int index) {
        return walls[index];
    }

    public void setWalls(Wall[] walls) {
        this.walls = walls;
    }
    public void setWall(Wall w,int directionInt){
            walls[directionInt]=w;
    }
    //    public String look(Player player1){
//        if (dark) return "Dark";
//        else if(player1.direction==Direction.north) return northWall.look();
//        else if(player1.direction==Direction.east) return eastWall.look();
//        else if(player1.direction==Direction.west) return westWall.look();
//        else  return southWall.look();
//    }

//    public String checkMirror(String objectName,Player player1) {
//        if(dark) return "dark";
//        else if(player1.direction==Direction.north && northWall.isMirror())
//            {
//                if(northWall.isKey()) {
//                    northWall.setKey(false);
//                    return northWall.getKeyName()+" was acquired";
//                } else return "no key here";
//            }
//        else if(player1.direction==Direction.south  && southWall.isMirror())
//            {
//                if(southWall.isKey()) {
//                    southWall.setKey(false);
//                    return southWall.getKeyName()+" was acquired";
//                } else return "no key here";
//            }
//        else if(player1.direction==Direction.east && eastWall.isMirror())
//            {
//                if(eastWall.isKey()) {
//                    eastWall.setKey(false);
//                    return eastWall.getKeyName()+" was acquired";
//                } else return "no key here";
//            }
//        else if(player1.direction==Direction.west && westWall.isMirror())
//            {
//                if(westWall.isKey()) {
//                    westWall.setKey(false);
//                    return westWall.getKeyName()+" was acquired";
//                } else return "no key here";
//            }else System.out.println("no mirror here");
//        return "";
//    }

//    public String checkPainting(String objectName,Player player1){
//        if(dark) return "dark";
//        else if(player1.direction==Direction.north && northWall.isPainting())
//        {
//            if(northWall.isKey()) {
//                northWall.setKey(false);
//                return northWall.getKeyName()+" was acquired";
//            } else return "no key here";
//        }
//        else if(player1.direction==Direction.south  && southWall.isPainting())
//        {
//            if(southWall.isKey()) {
//                southWall.setKey(false);
//                return southWall.getKeyName()+" was acquired";
//            } else return "no key here";
//        }
//        else if(player1.direction==Direction.east && eastWall.isPainting())
//        {
//            if(eastWall.isKey()) {
//                eastWall.setKey(false);
//                return eastWall.getKeyName()+" was acquired";
//            } else return "no key here";
//        }
//        else if(player1.direction==Direction.west && westWall.isPainting())
//        {
//            if(westWall.isKey()) {
//                westWall.setKey(false);
//                return westWall.getKeyName()+" was acquired";
//            } else return "no key here";
//        }
//        return "";
//    }

//    public String checkChest(String objectName,Player player1){
//        if(dark) return "dark";
//        else if(player1.direction==Direction.north && northWall.isChest())
//        {
//            if(northWall.isKey()) {
//                northWall.setKey(false);
//                return northWall.getKeyName()+" was acquired";
//            } else return "no key here";
//        }
//        else if(player1.direction==Direction.south  && southWall.isPainting())
//        {
//            if(southWall.isKey()) {
//                southWall.setKey(false);
//                return southWall.getKeyName()+" was acquired";
//            } else return "no key here";
//        }
//        else if(player1.direction==Direction.east && eastWall.isPainting())
//        {
//            if(eastWall.isKey()) {
//                eastWall.setKey(false);
//                return eastWall.getKeyName()+" was acquired";
//            } else return "no key here";
//        }
//        else if(player1.direction==Direction.west && westWall.isPainting())
//        {
//            if(westWall.isKey()) {
//                westWall.setKey(false);
//                return westWall.getKeyName()+" was acquired";
//            } else return "no key here";
//        }
//        return "";
//    }//

//    public String checkDoor(String objectName,Player player1){
//        if(dark) return "dark";
//        else if(player1.direction==Direction.north && northWall.isPainting())
//        {
//            if(northWall.isKey()) {
//                northWall.setKey(false);
//                return northWall.getKeyName()+" was acquired";
//            } else return "no key here";
//        }
//        else if(player1.direction==Direction.south  && southWall.isPainting())
//        {
//            if(southWall.isKey()) {
//                southWall.setKey(false);
//                return southWall.getKeyName()+" was acquired";
//            } else return "no key here";
//        }
//        else if(player1.direction==Direction.east && eastWall.isPainting())
//        {
//            if(eastWall.isKey()) {
//                eastWall.setKey(false);
//                return eastWall.getKeyName()+" was acquired";
//            } else return "no key here";
//        }
//        else if(player1.direction==Direction.west && westWall.isPainting())
//        {
//            if(westWall.isKey()) {
//                westWall.setKey(false);
//                return westWall.getKeyName()+" was acquired";
//            } else return "no key here";
//        }
//        return "";
//    }//
}
