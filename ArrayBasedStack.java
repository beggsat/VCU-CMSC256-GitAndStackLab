public class ArrayBasedStack<T> implements StackInterface <T>
{
   
   T[] data; //references an array storing elements in the list
   private int topOfStack; //an int value representing the location of the stack top in the array
   private static final int INITIAL_CAPACITY = 5; //the default capacity of the stack set to 5
   private boolean initialized; //a boolean variable that is set to true if the stack is successfully created


   @SuppressWarnings("unchecked")
   public ArrayBasedStack(int size){
      if (size <= 0)
      {
         throw new IllegalArgumentException("size must be greater than 0");
      }
      else
      {
      
         topOfStack = -1;
         data = (T[])new Object[size];
      }
   }
   
   public ArrayBasedStack() 
   { 
      this(INITIAL_CAPACITY);
   }
   
   /** Adds a new entry to the top of this stack.
       @param newEntry  An object to be added to the stack. */
   public void push(T newEntry){
      
   }

  
   /** Removes and returns this stack's top entry.
       @return  The object at the top of the stack. 
       @throws  EmptyStackException if the stack is empty before the operation. */
   public T pop(){
      if (topOfStack == 0){
         return null;
      }
      return data[--topOfStack];
   }

  
   /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
   public T peek(){
      return null;
   }
 
  
   /** Detects whether this stack is empty.
       @return  True if the stack is empty. */
   public boolean isEmpty(){
      return false;
   }

  
   /** Removes all entries from this stack. */
   public void clear(){
   
   }
   
   private void expandArray()
   {
      data = Arrays.copyOf(data, topOfStack);
   }

}