package wallObjects;

import Items.Item;
import Items.Key;

public interface Openable extends Checkable {
    public void open();
    public boolean isOpen();
    public void setOpenKey(Key item);
}
