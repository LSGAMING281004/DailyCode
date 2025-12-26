public class IndexDB
{
    int index;
    int value;
    int rear = 0;

    int array[] = new int[5];

    int length = array.length;

    // Insert Data
    public String insert(int value)
    {
        if(rear < length)
        {
            array[rear] = value;
            rear++;
        }
        else
        {
            return "Storage Full";
        }
        return "Successfully Inserted";
    }

    // Update Data
    public String update(int index, int value)
    {
        if(index < rear){
            array[index] = value;

        }else{
            return "Storage is Empty";
        }
        return "Successfully Updated";
    }

    // Delete Data
    public String delete(int index)
    {
        if(index < rear)
        {
            for(int i = index; i < rear-1; i++){
                array[i] = array[i+1];
            }
            rear--;
        }
        else{
            return "Storage not Support";    
        }
        return "Successfully Deleted";
    }

    // View Data
    public void view(int[] arr)
    {
        for(int num = 0; num < rear; num++)
        {
            System.out.print(array[num]+" ");
        }
    }
    public static void main(String args[])
    {
        IndexDB indexDB = new IndexDB();
        
        System.out.println(indexDB.insert(20));
        System.out.println(indexDB.insert(99));
        System.out.println(indexDB.insert(55));
        System.out.println(indexDB.insert(55));
        System.out.println(indexDB.insert(67));
        System.out.println(indexDB.insert(97));

        System.out.println(indexDB.delete(97));
        System.out.println(indexDB.delete(4));
        
        System.out.println(indexDB.update(1, 999));

        System.out.println(indexDB.insert(567));
        
        indexDB.view(indexDB.array);

        

    }
}

