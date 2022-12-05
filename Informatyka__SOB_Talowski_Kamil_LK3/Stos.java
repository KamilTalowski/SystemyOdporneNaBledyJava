package testyJednostkowe;

import java.util.EmptyStackException;

public class Stos {
    private String a[];

    public void push(char c) {
        push(String.valueOf(c));
    }

    public void push(String s) {
        int length = a==null ? 0 : a.length;
        String newarray[] = new String[length+1];
        if(a!=null)
            System.arraycopy(a, 0, newarray, 0, length);
        newarray[length] = s;
        a = newarray;
    }
   
    public String pop() {
        if(a==null || a.length==0)
            throw new EmptyStackException();
        String toReturn = a[a.length-1];
        String newarray[] = new String[a.length-1];
        System.arraycopy(a, 0, newarray, 0, a.length-1);
        a = newarray;
        return toReturn;
    }
   
    public String top() {
        if(a==null || a.length==0)
            throw new EmptyStackException();
        return a[a.length-1];
    }
   
    public boolean isEmpty() {
        if(a==null || a.length==0)
            return true;
        else
            return false;
    }

    public void clear(){
        a = null;
    }
   
    public int length() {
        return a.length;
    }
}
