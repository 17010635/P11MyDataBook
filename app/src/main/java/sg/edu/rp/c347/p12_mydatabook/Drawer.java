package sg.edu.rp.c347.p12_mydatabook;

public class Drawer {
    private String name;
    private int ivIcon;

    public Drawer(String name, int ivIcon) {
        this.name = name;
        this.ivIcon = ivIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIvIcon() {
        return ivIcon;
    }

    public void setIvIcon(int ivIcon) {
        this.ivIcon = ivIcon;
    }
}
