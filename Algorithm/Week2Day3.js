class BSTNode
{
    constructor(value)
    {
        this.left=undefined;
        this.right=undefined;
        this.value=value;
    }
};

class BST
{
    constructor()
    {
        this.root=undefined;
    }

    Insert(value)
    {
        /* Your Code Here */
        let node=this.root;
        while(node.left&&node.right)
        {
            if(value<node.value)
            {
                node=node.left;
            }
            else
            {
                node=node.right;
            }
        }
        if(value<node.value)
        {
            node.left=new BSTNode(value);
        }
        else
        {
            node.right=new BSTNode(value);
        }
    }

    InsertRecursive(node,value)
    {
        /* Your Code Here */
        /* CALL ME RECURSIVELY! */

        if(value<node.value)
        {
            if(!node.left)
            {
                node.left=new BSTNode(value);
                return;
            }
            this.InsertRecursive(node.left,value);
        }
        else
        {
            if(!node.right)
            {
                node.right=new BSTNode(value);
                return;
            }
            this.InsertRecursive(node.right,value);
        }
    }

    /* I'm just here to print your BST In-Order. */
    Log(node,fmt="")
    {
        if(!node) return fmt;
        fmt=this.Log(node.left,fmt);
        fmt+=node.value+"->";
        fmt=this.Log(node.right,fmt);
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


bst.Insert(44);
console.log(bst.Log(bst.root)); 	/* Expected: 25->44->50->75->100->125->150->175-> */
bst.InsertRecursive(bst.root, 22);
console.log(bst.Log(bst.root));		/* Expected: 22->25->44->50->75->100->125->150->175-> */