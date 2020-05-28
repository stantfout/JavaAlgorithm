package com.usth.leetcode.leetcode101_200;

import java.util.HashMap;

import java.util.Map;

public class LeetCode_146 {

    class Node {
        int key;
        int value;
        Node prev, next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class NodeList {
        int size;
        Node head;
        Node tail;

        public NodeList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.next = null;
            node.prev = null;
            size--;
        }

        public Node removeLast() {
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    class LRUCache {

        Map<Integer, Node> map;
        NodeList list;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            list = new NodeList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                list.remove(node);
                node.value = value;
                list.addFirst(node);
            } else {
                if (list.size >= capacity) {
                    map.remove(list.removeLast().key);
                }
                Node node = new Node(key, value);
                list.addFirst(node);
                map.put(key, node);
            }
        }
    }
}
