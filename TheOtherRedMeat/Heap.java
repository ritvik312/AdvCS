import java.util.*;
public class Heap
{
    Goat[] arr;
    int size;
    int nextInd;

    public Heap(int capacity)
    {
        arr = new Goat[capacity];
        size = 0;
        nextInd = 0;
    }

    public int fullCycle()    //lcm of all cycle lengths
    {
        if(size == 0)
            return 0;

        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < size; i++)
            nums.add(arr[i].cycle.length);

        int lcm = 1;
        while(nums.size() > 0)
        {
            Collections.sort(nums);
            int smallest = nums.get(0);
            nums.remove(0);
            if(smallest == 1)
                continue;

            lcm *= smallest;
            for(int i = 0; i < nums.size(); i++)
            {
                if(nums.get(i) % smallest == 0)
                    nums.set(i, nums.get(i)/smallest);
            }
        }
        return lcm;

    }

    public boolean killGoat()
    {
        if(size == 0 || arr[0].output() == arr[1].output() || arr[0].output() == arr[2].output())
            return false;

        size--;
        swap(0, nextInd-1);
        nextInd--;

        return true;
    }

    public void nextDay()
    {
        //store goats in temp arr
        Goat[] tempArr = Arrays.copyOfRange(arr, 0, nextInd);           //deep copy???
                                    //only take up to nextInd

        //reset heap
        arr = new Goat[arr.length];
        size = 0;
        nextInd = 0;

        //nextDay() each goat
        //add each goat w add()
        for(Goat goat : tempArr)
        {
            goat.nextDay();
            add(goat);
        }
    }

    public void add(Goat obj)
    {
        size++;

        int currentInd = nextInd;
        nextInd++;
        arr[currentInd] = obj;

        while(arr[currentInd].compareTo(arr[(currentInd-1)/2]) < 0)
        {
            swap(currentInd, (currentInd-1)/2);
            currentInd = (currentInd-1)/2;
        }
    }

    private void swap(int i1, int i2)
    {
        Goat temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }


}
