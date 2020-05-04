/* Problem-24 Give an algorithm for converting a tree to its mirror.
Mirror of a tree is another tree with left and right children of all non-leaf nodes interchanged.
The trees below are mirrors to each other. */

function Node(data, left, right) {
  this.data = data;
  this.left = left;
  this.right = right;
}

function toMirror(node) {
  if (node === null) return node;
  const tempNode = node.left;
  node.left = node.right;
  node.right = tempNode;
  toMirror(node.left);
  toMirror(node.right);
  return node;
}

function main() {
  const node = new Node(
    1,
    new Node(2, new Node(4, null, null), new Node(5, null, null)),
    new Node(3, new Node(6, null, null), new Node(7, null, null))
  );
  printPreOrder(node);
  const mNode = toMirror(node);
  console.log("_________________________");
  printPreOrder(mNode);
}

function printPreOrder(node) {
  if (node === null) return;
  console.log(node.data);
  printPreOrder(node.left);
  printPreOrder(node.right);
}

main();
