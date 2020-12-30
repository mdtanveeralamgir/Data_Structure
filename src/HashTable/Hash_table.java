package HashTable;

public class Hash_table {
    private String[] hashArray;
    private int arraySize;
    private int size = 0;

    public Hash_table(int arraySize){
        if(this.isPrime(arraySize)){
            this.arraySize = arraySize;
        } else{
            this.arraySize = this.getPrime(arraySize);
        }
        hashArray = new String[this.arraySize];
    }

    private boolean isPrime(int arraySize){
        for(int i = 2; i*i <= arraySize; i++){
            if(arraySize % i == 0)
                return false;
        }
        return true;
    }

    private int getPrime(int arraySize){
        while(!this.isPrime(++arraySize));
        return arraySize;
    }

    //Function one to get the index of array to insert
    private int hashFuncOne(String word){
        int hashVal = word.hashCode();
        hashVal = hashVal % this.arraySize;
        if(hashVal < 0){
            hashVal += this.arraySize;
        }
        return hashVal;
    }

    //Returns step size
    private int hashFunctwo(int hashVal){
        return 3 - hashVal % 3;
    }

    //Inserting string
    public void insert(String word){
        int hashVal = this.hashFuncOne(word);
        while(this.hashArray[hashVal] != null){
            int stepSize = this.hashFunctwo(hashVal);
            hashVal += stepSize;
            hashVal %= this.arraySize;
        }

        this.hashArray[hashVal] = word;
        this.size++;
    }

    public void printArray(){
        int x = 0;
        for(String word : this.hashArray){
            System.out.println(x++ + " " + word);
        }
    }

    public int getindexOfWord(String word){
        for(int i = 0; i < this.arraySize; i++){
            if(word.equals(this.hashArray[i])){
                return i;
            }
        }

        return -1;
    }
    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
