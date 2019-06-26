public class HashTable {

    NodeList[] table;

    public HashTable(int length) {
        table = new NodeList[length];
    }

    /**
     * get the value by the key
     * @param key
     * @return
     */
    String get(String key) {
        String value = "no such key";
        if(table[hash(key)] != null) {
            value = table[hash(key)].getValue(key);
        }
        return value;
    }

    /**
     * put the object in a hash table
     * @param key
     * @param value
     */
    void put(String key, String value) {
        if(table[hash(key)] == null) {
            NodeList node = new NodeList(key, value);
            table[hash(key)] = node;
        }
        else {
            table[hash(key)].add(key, value);
        }
    }

    /**
     * removes the object from the hash table
     * @param key
     * @return
     */
    String remove(String key) {
        String value = "no such key";
        if(table[hash(key)] != null) {
            value = table[hash(key)].remove(key);
        }
        return value;
    }

    /**
     * tells if the hash table contains the object or not
     * @param key
     * @return
     */
    boolean containsKey(String key) {
        if(table[hash(key)] != null && table[hash(key)].length() != 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * get the size of the hash table
     * @return
     */
    int size() {
        return table.length;
    }

    /**
     * get the hash code
     * @param key
     * @return
     */
    int hash(String key) {
        return (Math.abs(key.hashCode())) % size();
    }

    /*
    simple test
     */
    public static void main(String[] args) {
        HashTable htable = new HashTable(60);
        htable.put("swan", "bird");
        htable.put("fox", "mammal");
        htable.put("fox", "mammal");
        htable.put("bee", "insect");
        System.out.println(htable.remove("k"));
        System.out.println(htable.remove("fox"));
        System.out.println(htable.remove("bee"));
        System.out.println(htable.containsKey("bee"));
        System.out.println(htable.get("bee"));
        System.out.println(htable.containsKey("fox"));
        System.out.println(htable.get("swan"));
    }
}
