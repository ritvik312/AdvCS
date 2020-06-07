import java.io.*;
import java.util.*;
public class NodeTester {
    private Actor currentActor;
    public static void main(String[] args) {
        NodeTester nodeTester = new NodeTester();
        nodeTester.run();
    }
    public void run() {
        Actor ritvik = new Actor("Ritvik");
        Actor jack = new Actor("Jack");
        Actor abhinav = new Actor("Abhinav");
        Actor ankoor = new Actor("Ankoor");
        Actor achyutha = new Actor("Achyutha");

        currentActor = achyutha;
        achyutha.setNext(ankoor);
        ankoor.setNext(abhinav);
        abhinav.setNext(jack);
        jack.setNext(ritvik);

        while (currentActor != null) {
            System.out.println(currentActor.toString());
            currentActor = currentActor.getNext();
        }
    }
}
