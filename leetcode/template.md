## DFS

### 递归
```$xslt
def recursion(level,param...)
    if terminator
        process result
        return
    process cur logic
    drill down
    clear state
```

### 树的遍历
1. 前序遍历
```$xslt
def preorder(TreeNode root)
    process(root.val)
    preorder(root.left)
    preorder(root.right)
```

2. 中序遍历
```$xslt
def inorder(TreeNode root)
    inorder(root.left)
    inorder(root.val)
    inorder(root.right)
```
3. 后序遍历
```$xslt
def postorder(TreeNode root)
    postorder(root.left)
    postorder(root.right)
    postorder(root.val)
```
### 迭代
1. 前序遍历
```$xslt
def preorder(TreeNode root)
    stack = []
    stack.push(root)
    while !stack
        node = stack.pop()
        if node is TreeNode:
            stack.push(root.right)
            stack.push(root.left)
            //关键步骤
            stack.push(root.val)
        else 
           //node is TreeNode.val
           process(node)
```
2. 中序遍历
```$xslt
def inorder(TreeNode root)
    stack = []
    stack.push(root)
    while !stack:
        node = stack.pop()
    if node is TreeNode:
        stack.push(root.right)
        stack.push(root.val)
        stack.push(root.left)
```
3. 后序遍历
```$xslt
def postorder(TreeNode root)
    stack = []
    stack.push(root)
    while !stack:
        node = stack.pop()
        if node is TreeNode:
            stack.push(root.val)
            stack.push(root.right)
            stack.push(root.left)
```

## 回溯
```$xslt
def backTrack(path,otherSelectList)
    //一般为path为结果之一时为终结条件
    if terminator:
        process path
        return
    for select in otherSelectList
        //process cur logic
        do select 
        path.add(selext)
        //otherSelect有时候也需要判断是否需要递归到下一层

        //drill down
        backTrack(path,otherSelectList)

        //clear state
        path.deleteLast
```

## 分治
```$xslt
def divideConquer(param)
```

## BFS
```
def bfs(TreeNode root)
    queue = []
    queue.offer(root)
    while !queue
        node = queue.pop
        process(node)
        for childNode in node:
            queue.offer(childNode)
```

## 贪心

## 二分搜索
```$xslt
def binarySearch(int[] nums,int lo,int hi,int target)
    lo = 0,hi=nums.length-1
    while lo<=hi
       mid = lo + (hi - lo)/2
       if nums[mid] < target:
           binarySearch(nums,mid+1,hi,target)
       else:
        binarySearch(nums,lo,mid,target)
```