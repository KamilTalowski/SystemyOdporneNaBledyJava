package main;

import java.util.Random;

public class NumberSet
{
    private static int MAX_SIZE = 100;
    private int[] nSet = new int[MAX_SIZE];
    private int size = 0;

    Random generator = new Random();

    public void add(int i) throws Exception {
        assert (nSet != null ): "Table doesnt exist";
        assert (size >= 0): "Size less than zero";
        if(size+1 <= MAX_SIZE){
            nSet[size] = i;
            size++;
        }
        else{
            throw new Exception("Table is full");
        }
        assert(size < MAX_SIZE): "Size greater than MAX_SIZE";
    }

    public void remove(int i) throws Exception {
        assert (size > 0): "Empty  table.";
        int oldSize = size;
        if(size > 0){
            if(contains(i)){
                for (int k = 0; k < size; k++){
                    if (nSet[k] == i){
                        int l = k;
                        while (l+1 < size){
                            nSet[l] = nSet[l+1];
                            l++;
                        }
                        size--;
                        k--;
                    }
                }

            }
            else{
                System.out.println("Couldnt find number " + i + " in the table to delete.");
            }
        }
        else{
            throw new Exception("Empty table. Nothing to delete from");
        }

        assert(nSet.length == MAX_SIZE): "Max size of the the table not the same after removal";
        assert(size < MAX_SIZE): "Size of the table bigger than MAX_SIZE";
        assert(size <= oldSize): "Size after deletion has higher value than before";
    }

    public int getRandomValue() throws Exception {
        int oldSize = size;
        if(size > 0){
            int randInt = generator.nextInt(size);
            assert (randInt >= 0 && randInt < size): "Random index out of range.";
            int randomValueFromTable = nSet[randInt];
            int i = randInt;
            while(i < size) {
                nSet[i] = nSet[i+1];
                i++;
            }
            size--;
            System.out.println("A random value taken from table " + randomValueFromTable + " at index " + randInt);
            assert(size < oldSize): "Size after deletion has higher or the same value than before";
            return randomValueFromTable;
        }
        else{
            throw new Exception("Table is empty");
        }
    }

    public int getSumOfElements() throws Exception {
        if(size > 0){
            int sum = 0;
            for(int x : nSet) {
                sum += x;
            }
            System.out.println("Sum of all numbers: " + sum);
            return sum;
        }
        else{
            throw new Exception("Table is empty");
        }

    }

    public void divideAllElementsBy(int i) throws Exception {
        assert (size > 0): "Empty table";
        assert (i != 0): "Division by 0.";
        System.out.println("Division by: " + i);
        for (int j = 0; j < size; j++){
            nSet[j] = nSet[j]/i;
        }
    }

    public boolean contains(int i){
        assert(size > 0):"Empty table.";
        int j = 0;
        while (j < size){
            if (nSet[j] == i){
                System.out.println("Number " + i + " found at " + (j));
                return true;
            }
            j++;
        }
        System.out.println("Number " + i + " not found in the table");
        return false;
    }

    public int getSize() {
        assert(size >= 0):"Size value less than 0";
        assert(size < MAX_SIZE) : "Size value out of upper bound.";
        return size;
    }

    public void print(){
        assert(size > 0):"Empty table.";
        System.out.println();
        System.out.println();
        for (int i = 0; i < size; i++){
            System.out.println(i + ": " + nSet[i]);
        }

    }
}
