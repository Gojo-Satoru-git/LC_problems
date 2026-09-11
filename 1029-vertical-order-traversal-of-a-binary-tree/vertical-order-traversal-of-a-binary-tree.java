/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        int val;
        int depth;
        Pair(int val,int depth){
            this.val = val;
            this.depth = depth;
        }
    }
    TreeMap<Integer,ArrayList<Pair>> mp;
    private void traverse(TreeNode root,int h,int d){
        if(root == null)return ;
        mp.computeIfAbsent(h, k -> new ArrayList<>()).add(new Pair(root.val,d));
        traverse(root.left,h-1,d+1);
        traverse(root.right,h+1,d+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        mp = new TreeMap<>();
        traverse(root,0,0);
        List<List<Integer>> res = new ArrayList<>();
        for(ArrayList<Pair> e:mp.values()){
            Collections.sort(e,(a,b) ->{
                if(a.depth != b.depth)return Integer.compare(a.depth,b.depth);
                else return Integer.compare(a.val,b.val);
            });
            List<Integer> temp = new ArrayList<>();
            for(Pair p:e){
                temp.add(p.val);
            }
            res.add(temp);
        }
        return res;
    }
}