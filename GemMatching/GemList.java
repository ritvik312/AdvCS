public class GemList 
{
    private int count;
    private Node head, tail;
    public GemList() {
        head = tail = null;
    }

    public GemList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public int size() {
        return count;
    }

    public void draw(double y) {
        Node temp = head;
        double x = 0;
        int i = 0;
        while (temp != null && i < count) {
            temp.get().draw(1.0 / 16 * (i + 0.5), y);
            i++;
            temp = temp.getNextPtr();
        }
    }

    public void insertBefore(Gem gem, int index) {
        Node n = new Node(gem);
        Node temp = head;
        if (count == 0 || (count == 0 && index == 0))
            head = tail = n;
        else if (index >= count) {
            tail.setNextPtr(n);
            tail = n;
        }
        else {
            int i = 0;
            while (temp != null && i < index) {
                if (i+1 == index) {
                    Node temp2 = temp.getNextPtr();
                    temp.setNextPtr(n);
                    n.setNextPtr(temp2);
                    break;
                }
                else if (i != index) {
                    temp = temp.getNextPtr();
                    i++;
                }
            }
        }
        count++;
    }

    public String toString() {
        String output = "";
        Node temp = head;
        int i = 0;
        if (count == 0)
            return "<none>";
        while (temp != null){
            if (i == count-1)
                output += temp.get().getType();
            else {
                output += temp.get().getType() + " -> ";
                i++;
            }
            temp = temp.getNextPtr();
        }
        return output;
    }

    public int score() {
        int score = 0;
        Node temp = head;
        if (count == 0)
            return 0;
        while (temp != null) {
            int tempScore = 0;
            int i = 1;
            tempScore += temp.get().getPoints();
            while (temp.getNextPtr() != null && temp.getNextPtr().get().getType() == temp.get().getType()) {
                i++;
                tempScore += temp.getNextPtr().get().getPoints();
                temp = temp.getNextPtr();
            }
            score += (i*tempScore);
            temp = temp.getNextPtr();
        }
        return score;
    }

    public static void main(String [] args)
    {
        GemList list = new GemList();
        System.out.println(list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.9);     

        list.insertBefore(new Gem(GemType.BLUE, 10), 0);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.8);

        list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.7);

        list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.6);

        list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.5);

        list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.4);

        list.insertBefore(new Gem(GemType.GREEN, 50), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.3);     
    }   
    private class Node {
        private Gem gem;
        private Node next;
        public Node() {
            gem = null; next = null;
        }

        public Node (Gem gem) {
            this.gem = gem; next = null;
        }

        public Gem get () { return gem; }

        public void set (Gem gem) { this.gem = gem; }

        public Node getNextPtr () { return next; }

        public void setNextPtr (Node next) { this.next = next; }

        public String toString () { return "Gem: " + gem; }
    }
}
