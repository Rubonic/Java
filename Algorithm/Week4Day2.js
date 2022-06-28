/* FIFO - First In First Out */

class Node
{
    constructor(value)
    {
        this.value=value;
        this.next=undefined;
        this.previous=undefined;
    }
};

class Queue
{
    constructor()
    {
        this.head=undefined;
        this.tail=undefined;
        this.length=0;
    }

    /* Time:O(1) */
    /* Space:O(1) */
    /* Adds the given value to the back of the queue. */
    Enqueue(value)
    {
        /* Your Code Here */
        let node=new Node(value);
        if(this.head===undefined)
        {
            this.head=node;
            this.tail=node;
        }
        else
        {
            this.tail.next=node;
            node.previous=this.tail;
            this.tail=node;
        }
        this.length++;
    }

    /* Time:O(1) */
    /* Space:O(1) */
    /* Removes and returns the value at the front of the queue. */
    Dequeue()
    {
        /* Your Code Here */
        let node=this.head;
        if(node===undefined)
        {
            return undefined;
        }
        else if(node.next===undefined)
        {
            this.head=undefined;
            this.tail=undefined;
        }
        else
        {
            this.head=node.next;
            this.head.previous=undefined;
        }
        this.length--;
        return node.value;
    }

    /* Time:O(1) */
    /* Space:O(1) */
    /* Returns but does NOT remove the value at the front of the queue. */
    Front()
    {
        /* Your Code Here */
        let node=this.head;
        if(node===undefined)
        {
            return undefined;
        }
        else
        {
            return node.value;
        }
    }

    /* Time:O(1) */
    /* Space:O(1) */
    /* Returns but does NOT remove the value at the back of the queue. */
    Back()
    {
        /* Your Code Here */
        let node=this.tail;
        if(node===undefined)
        {
            return undefined;
        }
        else
        {
            return node.value;
        }
    }

    /* Time:O(1) */
    /* Space:O(1) */
    /* Returns whether the queue is empty. */
    IsEmpty()
    {
        /* Your Code Here */
        return this.length===0;
    }

    /* Time:O(1) <- Yes, this should be constant time ;) */
    /* Space:O(1) */
    /* Returns the number of nodes or items in the queue. */
    Size()
    {
        /* Your Code Here */
        return this.length;
    }

    Log()
    {
        let str="";
        for(var node=this.head;node;node=node.next)
        {
            str+=node.value+"->";
        }
        console.log(str);
    }
};

let q=new Queue();
q.Enqueue(16);
q.Enqueue(32);
q.Enqueue(64);
q.Enqueue(128);
q.Enqueue(256);
q.Log();                     /* Expected: 16->32->64->128->256-> */
console.log(q.Dequeue());     /* Expected: 16 */
console.log(q.Dequeue());     /* Expected: 32 */
console.log(q.Front());     /* Expected: 64 */
console.log(q.Back());         /* Expected: 256 */
console.log(q.IsEmpty())     /* Expected: false */
console.log(q.Size());        /* Expected: 3 */