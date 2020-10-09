package com.usth.leetcode.leetcode201_300;

import java.util.LinkedList;
import java.util.Queue;

import com.usth.annotation.Undone;
import com.usth.base.TreeNode;

@Undone
public class LeetCode297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sb.append(",");
                if (poll.left != null) {
                    queue.add(poll.left);
                    sb.append(poll.left.val);
                } else {
                    sb.append("n");
                }
                sb.append(",");
                if (poll.right != null) {
                    queue.add(poll.right);
                    sb.append(poll.right.val);
                } else {
                    sb.append("n");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] split = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(split[i++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (i < split.length) {
            TreeNode temp = queue.poll();
            if (split[i].equals("n")) {
                temp.left = null;
            } else {
                temp.left = new TreeNode(Integer.parseInt(split[i]));
                queue.add(temp.left);
            }
            i++;
            if (split[i].equals("n")) {
                temp.right = null;
            } else {
                temp.right = new TreeNode(Integer.parseInt(split[i]));
                queue.add(temp.left);
            }
        }
        return root;
    }
}
