public class NodeList {
    Node head;
    Node tail;
    int length = 0;

    public class Node {
        String key;
        String value;
        Node next;
        Node prev;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public NodeList(String key, String value) {
        Node node = new Node(key, value);
        head = node;
        tail = node;
        length++;
    }

    void add(String key, String value) {
        tail.next = new Node(key, value);
        tail.next.prev = tail;
        tail = tail.next;
        length++;
    }

    String remove(String str) {
        String value = "no such key";
        try {
            if (getNode(str) != null) {
                value = getValue(str);
                if(length()>1) {
                    if (getNode(str).prev != null && getNode(str).next != null) {
                        getNode(str).prev.next = getNode(str).next;
                    } else if (getNode(str).prev == null) {
                        getNode(str).next.prev = null;
                        head = getNode(str).next;
                    }
                    else if (getNode(str).next == null) {
                        getNode(str).prev.next = null;
                        tail = getNode(str).next;
                    }
                }
                else {
                    head = null;
                    tail = null;
                }
                length--;
            }
        } catch(Exception e) {System.out.println(e);}
        return value;
    }

    String getValue(String key) {
        if (getNode(key) != null) {
            return getNode(key).value;
        }
        return  "no such key";
    }

    Node getNode(String key) {
        Node node = null;
        if(length() > 0) {
            node = head;
            if (node.key == key) {
                return node;
            }
            while (node.next != null) {
                node = node.next;
                if (node.key == key) {
                    return node;
                }
            }
            node = null;
        }
        return node;
    }

    int length() {
        return length;
    }

    /*
    simple test
     */
    public static void main(String[] args) {
        NodeList node = new NodeList("fox", "mammal");
        node.add("monkey", "mammal");
        node.add("swan", "bird");
        System.out.println(node.remove("monkey"));
        System.out.println(node.getValue("fox"));
        System.out.println(node.getValue("monkey"));
        System.out.println(node.getValue("swan"));
        System.out.println(node.length());
    }
}