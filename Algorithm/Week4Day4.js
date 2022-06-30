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
    /******************************************************************************
    * Name: Queue.SumHalves()
    * Description: Whether the sum of the first half of the queue is equal to the sum of the second half.
    ******************************************************************************/
    SumHalves()
    {
        /* Your Code Here */
        let sum1=0;
        let sum2=0;
        let node=this.head;
        while(node.next!=this.tail)
        {
            sum1+=node.value;
            node=node.next;
        }
        sum1+=node.value;
        node=this.tail;
        while(node.previous!=this.head)
        {
            sum2+=node.value;
            node=node.previous;
        }
        sum2+=node.value;
        return sum1==sum2;
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
class Stack
{
    constructor()
    {
        this.top=undefined;
    }
};

class TwoStackQueue
{
    constructor()
    {
        this.stack1=new Stack();
        this.stack2=new Stack();
    }
    Enqueue(value)
    {
        /* Your Code Here */
        this.stack1.Push(value);
    }
    Dequeue()
    {
        /* Your Code Here */
        if(this.stack2.top==undefined)
        {
            while(this.stack1.top!=undefined)
            {
                this.stack2.Push(this.stack1.Pop());
            }
        }
        return this.stack2.Pop();
    }
};
let items1=[10,20,30,10,30,20];
let items2=[60,70,80,90,100,110];
let twoStackQueue=new TwoStackQueue();
for(let i=0;i<items1.length;i++)
{
    twoStackQueue.Enqueue(items1[i]);
}
console.log(twoStackQueue.Dequeue());
console.log(twoStackQueue.Dequeue());
console.log(twoStackQueue.Dequeue());
console.log(twoStackQueue.Dequeue());
console.log(twoStackQueue.Dequeue());
console.log(twoStackQueue.Dequeue());