class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int max = -1;
    int index = -1;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num > max) {
        max = num;
        index = i;
      }
    }
    TreeNode root = new TreeNode(max);
    TreeNode temp = root;
    constructRecur(temp, nums, index, set);
    return root;
  }

  public void constructRecur(TreeNode node, int[] nums, int index, Set<Integer> set) {
    int leftMax = -1, rightMax = -1, leftIndex = -1, rightIndex = -1, tempIndex = index - 1;
    set.add(node.val);
    while (tempIndex >= 0 && !set.contains(tempIndex)) {
      if (nums[tempIndex] > leftIndex) {
        leftMax = nums[tempIndex];
        leftIndex = tempIndex;
      }
      tempIndex--;
    }
    tempIndex = index + 1;
    while (tempIndex <= nums.length - 1 && !set.contains(tempIndex)) {
      if (nums[tempIndex] > rightMax) {
        rightMax = nums[tempIndex];
        rightIndex = tempIndex;
      }
      tempIndex++;
    }
    if (leftIndex != -1) {
      node.left = new TreeNode(leftMax);
      constructRecur(node.left, nums, leftIndex, set);
    }
    if (rightIndex != -1) {
      node.right = new TreeNode(rightMax);
      constructRecur(node.right, nums, rightIndex, set);
    }
  }
}