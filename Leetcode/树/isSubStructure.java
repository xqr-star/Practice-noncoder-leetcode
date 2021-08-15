//剑指 Offer 26. 树的子结构
public class isSubStructure {


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A== null && B == null) return true; //两个树都是空树
        if(A == null || B == null ) return false; //空树不是任意一个树的子结构

        //先判断当前的根节点的树和B是不是子树关系

        if(recur(A,B)){
            return true; //如果当前的就是那么但会true 如果不是 那么继续去左右结点找子树的关系
        }else {
            return isSubStructure(A.left,B) || isSubStructure(A.right,B);
        }


    }

    //recur 重现的意思 再发生
    private boolean recur(TreeNode a, TreeNode b) {
        //两个树同时走到了末尾 b== null && a == null || b树走到了末尾 b==null
        //传进来的时候 可以确保b不是空树 所有b为null 一定是因为递归的关系走完了 所以可以返回null
        if(b == null ) return true;

        //表明没有树了 那么自然也就不可能是子树的关系 返回fasle
        if(a == null) return false;

        if(a.val == b.val){
            return recur(a.left,b.left) && recur(a.right,b.right);
        }else {
            //如果当前的根结点的值都不相等，那么直接返回false
            return false;
        }
    }


    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        if(A == null && B == null) return true;
        if(A == null || B == null) return false;

        return  dfs(A,B);

    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if(a == null && b == null) return  true;
        if(a == null || b == null) return  false;

        if(a.val == b.val){
            return dfs(a.left,b.left) || dfs(a.right,b.right) ||
                    dfs(a.left,b) || dfs(a.right,b);
        }

        return dfs(a.left,b) || dfs(a.right,b);


    }


}
