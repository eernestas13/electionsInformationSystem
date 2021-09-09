//Generic object Hashtable
//To Add: Delete;
public class HashTable<E> {
    HashNode<E>[] hashTable;

    public HashTable(int size) {
        hashTable = ((HashNode<E>[]) new HashNode[size]);
    }
    public int hashObject(E key){
        return Math.abs(key.hashCode()) % hashTable.length;
    }

 //add using index of array
    public void add(E value, int key) {
        HashNode x = new HashNode(value);
        x.nextNode = hashTable[key];
        hashTable[key] = x;
    }

    public class HashNode<E>{
        E value;
        HashNode nextNode;
        public HashNode(E value){
            this.value = value;
        }
    }

}
