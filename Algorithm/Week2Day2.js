class BSTNode {
    constructor(value) {
        this.left = undefined;
        this.right = undefined;
        this.value = value;
    }
};

class BST {
    constructor() {
        this.root = undefined;
    }

    /* Worst Time Complexity: O(N) */
    /* Average Time Complexity: O(N) */
    /* Best Time Complexity: O(1) */
    /* Finds the smallest value in the tree ITERATIVELY */
    Min() {
        /* Your Code Here */
        let current = this.root; // start at root
        while (current.left) { // while there is a left node
            current = current.left; // move left
        }
        return current.value; // return the value
    }

    /* Worst Time Complexity: O(N) */
    /* Average Time Complexity: O(N) */
    /* Best Time Complexity: O(1) */
    /* Finds the largest value in the tree ITERATIVELY */
    Max() {
        /* Your Code Here */
        let current = this.root; // start at root
        while (current.right) { // while there is a right node
            current = current.right; // move right
        }
        return current.value; // return the value
    }

    /* Worst Time Complexity:  O(N) */
    /* Average Time Complexity: O(log N) */
    /* Best Time Complexity: O(1) */
    /* Space Complexity: O(1) */
    /* Determine whether the given value exists within the tree */
    Contains(value) {
        /* Your Code Here */
        let current = this.root; // start at root
        while (current) { // while there is a current node
            if (current.value === value) { // if the value is the same
                return true; 
            } else if (current.value > value) { // if the value is less than the current
                current = current.left; // move left
            } else { // if the value is greater than the current
                current = current.right; // move right
            }
        }
        return false; // if there is no node
    }

    /* Worst Time Complexity:  O(N) */
    /* Average Time Complexity: O(log N) */
    /* Best Time Complexity: O(1) */
    /* Space Complexity: O(1) */
    /* Determine whether the given value exists within the tree RECURSIVELY */
    ContainsRecursive(node, value) {
        /* Your Code Here */
        /* Call me recursively! */
        if (!node) return false; // if there is no node
        if (node.value === value) return true; // if the value is the same
        if (node.value > value) return this.ContainsRecursive(node.left, value); // if the value is less than the current
        return this.ContainsRecursive(node.right, value); // if the value is greater than the current
    }

    /* I'm just here to print your BST In-Order. */
    /* Could use me as an example to solve above algos, since I'm recursive and all. */
    Log(node, fmt = "") {
        if (!node) return fmt;
        fmt = this.Log(node.left, fmt);
        fmt += node.value + "->";
        fmt = this.Log(node.right, fmt);
        return fmt;
    }
};
/*****************************************************************************/
/* Code Tests Below */
/*****************************************************************************/
let bst = new BST();

bst.root = new BSTNode(100);
bst.root.left = new BSTNode(50);
bst.root.right = new BSTNode(150);

bst.root.left.left = new BSTNode(25);
bst.root.left.right = new BSTNode(75);

bst.root.right.left = new BSTNode(125);
bst.root.right.right = new BSTNode(175);

// console.log(bst.Log(bst.root)); 		  /* Uncomment me if you want to see your tree */
console.log(bst.Min())					  /* Expected: 25 */
console.log(bst.Max())					  /* Expected: 175 */
console.log(bst.Contains(200)) 	   		  /* Expected: false */
console.log(bst.Contains(125)) 	   		  /* Expected: true */
console.log(bst.ContainsRecursive(bst.root,15));   /* Expected: false */
console.log(bst.ContainsRecursive(bst.root,75));   /* Expected: true */