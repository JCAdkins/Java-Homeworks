package reversecopytest;

public class ReverseCopyTest {

    public static void main(String[] args) {
        
        List<Integer> list = new List<>(); 

      // insert integers in list
      list.insertAtFront(-1);
      list.insertAtFront(0);
      list.insertAtBack(1);
      list.insertAtBack(5);
      list.insertAtFront(3);
      // Original list order
      list.print();
      
      // Reverse the list and print
      list = List.reverseCopy(list);
      list.print();
      
      List<String> names = new List<>();
      names.insertAtFront("Bob");
      names.insertAtFront("Liz");
      names.insertAtBack("Marry");
      names.insertAtBack("Dave");
      names.print();
      
      names = List.reverseCopy(names);
      names.print();
    }
}


