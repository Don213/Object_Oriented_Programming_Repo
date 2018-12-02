public class Monopoly {





private class LinkedList
{
    private LinkedList head;
    private LinkedList next;
    private LinkedList current;
    private LinkedList last;

    private int listCount;
    private String name;


    public LinkedList()
    {
        //head = new LinkedList(null);
        next = new LinkedList(null);
        current = new LinkedList(null);
        last = new LinkedList(null);
        listCount = 0;
    }


    public LinkedList(LinkedList data)
    {
        LinkedList temp = new LinkedList(data);
        current = head;
        while(current.getNext() != null)
        {
            last = current;
            current = current.getNext();
        }
        current.setNext(temp);
        listCount++;
    }

    public LinkedList getNext()
    {
        return next;
    }
    public void setNext(LinkedList data)
    {
        next = data;
    }

    public void setHead(LinkedList data)
    {
        head = data;
    }
    public String getName()
    {
        return name;
    }

    public LinkedList findLink(String name)
    {
        while(!current.getName().equals(name))
        {
            current = current.getNext();
        }

        return current;
    }


}







}
