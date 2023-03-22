package com.bo.coding.leetcode.leetcode201_300;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.TreeNode;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.DATA_STRUCTURE})
public class LeetCode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > p.val && temp.val > q.val) {
                temp = temp.left;
            } else if (temp.val < p.val && temp.val < q.val) {
                temp = temp.right;
            } else {
                break;
            }
        }
        return temp;
    }
}
