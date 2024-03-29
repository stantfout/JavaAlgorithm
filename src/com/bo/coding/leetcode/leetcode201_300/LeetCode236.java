package com.bo.coding.leetcode.leetcode201_300;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.TreeNode;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.DATA_STRUCTURE}, status = StatusEnum.FINAL_END)
public class LeetCode236 {

    private TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    //寻找root的左右节点或者root本身是否包含p,q
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        //剪枝一下
        if (res != null) {
            return false;
        }
        //如果root为null，直接返回false
        if (root == null) {
            return false;
        }
        //左子树是否包含p,q中的一个
        boolean f1 = dfs(root.left, p, q);
        //右子树是否包含p,q中的一个
        boolean f2 = dfs(root.right,p, q);
        //如果root为p或者q,只需要root的左右子树中有一个包含p或q即可
        boolean f3 = (root == p || root == q) && (f1 || f2);
        /**
         *最终判断为true的标准为
         *  1. root为p或q,它的左右子树中的一个为另一个节点。
         *  2. root的左右子树分别包含p,q。
         */
        boolean flag = f3 || (f1 && f2);
        //第一个为true的root节点即为结果，通过一个全局变量存储。
        if (flag) {
            res = root;
        }
        //如果root节点等于p或q，或者它的左右子树包含过p或q，就返回true，否则返回false
        return root == p || root == q || f1 || f2;
    }

}
