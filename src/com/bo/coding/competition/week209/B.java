package com.bo.coding.competition.week209;

import com.bo.coding.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- != 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            if (!judge(list, index)) {
                return false;
            }
            index++;
        }
        return true;
    }

    private boolean judge(List<Integer> list, int index) {
        if (index % 2 == 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % 2 == 0 || (i != 0 && list.get(i) <= list.get(i - 1))) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % 2 == 1 || (i != 0 && list.get(i) >= list.get(i - 1))) {
                    return false;
                }
            }
        }
        return true;
    }
}
