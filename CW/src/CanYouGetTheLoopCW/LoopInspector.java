package CanYouGetTheLoopCW;

import java.util.HashMap;

public class LoopInspector {
    public int loopSize(Node node) {
        // Use the `getNext()` method to get the following node.
        HashMap<Node, Integer> nodeMap = new HashMap<Node, Integer>();
        int count = 0;
        nodeMap.put(node, count);
        count++;
        Node next = node.getNext();
        while (next != null) {
            if (nodeMap.containsKey(next)) {
                count -= nodeMap.get(next);
                break;
            }
            nodeMap.put(next, count);
            next = next.getNext();
            count++;
        }
        return count;
    }
}
