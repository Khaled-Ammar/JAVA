import java.util.ArrayList;
public class List {
    public static void Exceptions(){
        
            ArrayList<Object> myList = new ArrayList<Object>();
            myList.add("13");
            myList.add("hello world");
            myList.add(48);
            myList.add("Goodbye World");
            try {
            for(int i = 0; i < myList.size(); i++) {
            Integer castedValue = (Integer) myList.get(i);
        }
        }
        catch(Exception e) {
            System.out.println("Something wrong.");
        }
    }


}