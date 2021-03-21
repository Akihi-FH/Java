package org.fh.sortalgorithm;

import java.util.*;

public class LRUTest {

    public static void main(String[] args) {
        /*LRU lru = new LRU();
        lru.put("a", 1);
        lru.put("b", 2);
        lru.put("c", 3);
        lru.put("d", 4);
        lru.put("e", 5);
        System.out.println(lru);
        lru.get("a");
        System.out.println(lru);
        lru.put("f", 7);
        System.out.println(lru);

        lru.put("c", 8);
        System.out.println(lru);*/


        int a = 20;
        Map<String, Object> map = Collections.synchronizedMap(
                new LinkedHashMap<String, Object>(10, 0.75f, true) {
                    final int size = a;

                    @Override
                    protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
                        return size() > a;
                    }
                });
    }
}


class LRUCache {

    // 双向链表节点定义
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

    private int capacity;
    //保存链表的头节点和尾节点
    private Node first;
    private Node last;

    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = map.get(key);
        //为空返回-1
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    private void moveToHead(Node node) {
        if (node == first) {
            return;
        } else if (node == last) {
            last.prev.next = null;
            last = last.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.prev = first.prev;
        node.next = first;
        first.prev = node;
        first = node;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node == null) {
            node = new Node();
            node.key = key;
            node.val = value;

            if (map.size() == capacity) {
                removeLast();
            }

            addToHead(node);
            map.put(key, node);
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void addToHead(Node node) {
        if (map.isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
    }

    private void removeLast() {
        map.remove(last.key);
        Node prevNode = last.prev;
        if (prevNode != null) {
            prevNode.next = null;
            last = prevNode;
        }
    }

    @Override
    public String toString() {
        return map.keySet().toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(1);
        cache.put(4, 3);
        System.out.println(cache);
    }
}


class LRU {
    private final int MAX_SIZE = 5;
    private final float DEFAULT_LOAD_FACTORY = 0.75f;
    public LinkedHashMap<String, Object> map;

    public LRU() {
        this(16);
    }

    public LRU(int capacity) {
        // accessOrder 设置为true
        // 如果accessOrder为true的话，则会把访问过的元素放在链表后面，放置顺序是访问的顺序
        // 如果accessOrder为flase的话，则按插入顺序来遍历
        map = new LinkedHashMap<String, Object>(capacity, DEFAULT_LOAD_FACTORY, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return map.size() > MAX_SIZE;
            }
        };
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void del(String key) {
        map.remove(key);
    }

    public boolean contains(String key) {
        return map.containsKey(key);
    }

    @Override
    public String toString() {
        return "LRU{" +
                "map=" + map +
                '}';
    }
}