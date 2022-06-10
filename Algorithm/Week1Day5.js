class Node
{
    constructor(value)
    {
        this.next=undefined;
        this.value=value;
    }
};

class List
{
    constructor()
    {
        this.head=undefined;
    }

    Iterate()
    {
        let str="";
        for(let node=this.head;node;node=node.next)
        {
            str+=node.value+"->";
        }
        console.log(str);
    }

    PushBack(value)
    {
        if(!this.head)
        {
            this.head=new Node(value);
            return;
        }
        for(var node=this.head;node.next;node=node.next){}
        node.next=new Node(value);
    }

    PushBackN(arr)
    {
        for(let value of arr) this.PushBack(value);
    }
    
    /* Add all nodes of the supplied list to this list */
    Concat(other_list)
    {
        /* Your Code Here */
        for(var node=this.head;node.next;node=node.next){}
        node.next=other_list.head;
        return this;
    }

    /* Finds the node with the smallest value and moves it to the front. */
    MinToFront()
    {
        /* Your Code Here */
        let node=this.head;
        let min=this.head;
        let prev=undefined;
        let prevmin=undefined;
        while(node)
        {
            if(node.value<min.value)
            {
                prevmin=prev;
                min=node;
            }
            prev=node;
            node=node.next;
        }
        prevmin.next=prevmin.next.next;
        let temp=this.head;
        this.head=min;
        /* 5->38 */
        min.next=temp;
        /* 5->40->25-> */
    }
};