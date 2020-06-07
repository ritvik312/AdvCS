import java.io.*;
import java.util.*;
public class Actor {
    private Actor next;
    private String name;

    public Actor() {
        next = null;
    }

    public Actor(String name) {
        this.name = name;
        next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Actor getNext() {
        return next;
    }

    public void setNext(Actor next) {
        this.next = next;
    }

    public String toString() {
        return "Actor " + name;
    }
}
