package LinkedList;

/**
 * @className LinkedList1
 * @Author lulu
 * @Date 2019-10-30 17:14
 * 加入虚拟头节点
 * 增删改查O(n)
 **/
public class LinkedList_b<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList_b() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }
    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表的index(0--based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习(链表中没有索引)
    public void add(int index, E e) {
        if(index<0 || index > size) {
            throw new IllegalArgumentException("Add Falid, Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在链表头添加新元素e
    public void addFirst(E e) {
        add(0, e);
    }
    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的index(0--based)位置的元素e
    // 在链表中不是一个常用的操作，练习(链表中没有索引)
    public E get(int index) {
        if(index<0 || index > size) {
            throw new IllegalArgumentException("Add Falid, Illegal index");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    // 获得链表的第一个位置的元素e
    public E getFirst() {
        return get(0);
    }
    // 获得链表的最后一个位置的元素e
    public E getLast() {
        return get(size-1);
    }

    // 修改链表的index(0--based)位置的元素为e
    // 在链表中不是一个常用的操作，练习(链表中没有索引)
    public void set(int index, E e) {
        if(index<0 || index > size) {
            throw new IllegalArgumentException("Add Falid, Illegal index");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 删除链表的index(0--based)位置的元素为e
    // 在链表中不是一个常用的操作，练习(链表中没有索引)
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add Falid, Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        // 手动释放
        retNode.next = null;
        size--;

        return retNode.e;
    }

    // 删除链表的第一个位置的元素e
    public E removeFirst() {
        return remove(0);
    }
    // 删除链表的最后一个位置的元素e
    public E removeLast() {
        return remove(size-1);
    }

    public E removeElement(E e) {
        if (e == null) {
            return e;
        } else {
            for (Node x = dummyHead; x != null; x = x.next) {
                if (e.equals(x.e)) {
                    Node retNode = x.next;
                    x.next = retNode.next;
                    size--;
                    return retNode.e;
                }
            }
            return null;
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

//        Node current = dummyHead.next;
//        while (current != null) {
//            res.append(current + "->");
//            current = current.next;
//        }
        for (Node current = dummyHead.next; current!=null; current=current.next) {
            res.append(current + "->");
        }
        res.append("NULL");

        return res.toString();
    }
}
