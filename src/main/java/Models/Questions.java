package Models;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Questions implements Serializable {
    private int ID;
    private String content;
    public Questions() {
        super();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "Questions [ID=" + ID + ", content=" + content + "]";
    }
}
