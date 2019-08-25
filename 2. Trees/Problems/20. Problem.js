// Problem-20 Given a binary tree, print out all its root-to-leaf paths.

function Node(data, left, right) {
  this.data = data;
  this.left = left;
  this.right = right;
}

function rootToLeafPaths(node, path) {
  if (node === null) return null;
  path.push(node.data);
  if (node.left === null && node.right === null) {
    print(path);
  } else {
    const path1 = [...path];
    const path2 = [...path];
    rootToLeafPaths(node.left, path1);
    rootToLeafPaths(node.right, path2);
  }
}

function print(path) {
  console.log(path);
}

function main() {
  const node = new Node(
    1,
    new Node(2, new Node(4, null, null), new Node(5, null, null)),
    new Node(3, new Node(6, null, null), new Node(7, null, null))
  );
  rootToLeafPaths(node, []);
}

main();
