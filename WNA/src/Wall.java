import Items.Item;
import wallObjects.WallObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Wall implements Serializable {
    boolean door=false,chest=false,mirror=false,painting=false,seller=false,key=false,empty=false;
    static int wallsCount=0;
    int type;
    int id;
    String keyName_wall="";
    private WallObject wallObject;
    int chestID=0;

    public WallObject getWallObject() {
        return wallObject;
    }

    public void setWallObject(WallObject wallObj) {
        this.wallObject = wallObj;
    }

    public Wall() {
        this.id = wallsCount++;
        this.type=0;
    }

    public String look(){
        if (wallObject!=null)
            return wallObject.getObjectName();
        else return "Wall";
    }

}
