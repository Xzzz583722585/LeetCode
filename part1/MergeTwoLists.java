package part1;

public class MergeTwoLists {

	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(4);
//		l1.next.next.next=new ListNode(-4);
//		l1.next.next.next.next=new ListNode(1);
//		l1.next.next.next.next.next=new ListNode(6);
//		l1.next.next.next.next.next.next=new ListNode(6);
		
		ListNode l2=new ListNode(1);
		l2.next=new ListNode(3);
		l2.next.next=new ListNode(4);
		
		ListNode list=mergeTwoLists(l1,l2);
		while(list!=null)
		{
			System.out.println(list.val);
			list=list.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//空列表
		if(l1==null)
		{
			return l2;
		}
		else if(l2==null)
		{
			return l1;
		}
		
		//为了让空间复杂度降低到O(1)，使用已有的ListNode l1作为返回
		ListNode target=l1.val<=l2.val?l1:l2;//挑选一个作为目标列表，向其中添加元素
		ListNode result=target;//作为返回，target指针会后移
		ListNode src=l1.val<=l2.val?l2:l1;//src元素向target中添加
		ListNode prev=null;//记录target前驱
		
		while(target!=null && src!=null)//一个列表已空
		{
			//增序
			if(target.val<=src.val)//添加target元素只做后移操作
			{
				prev=target;
				target=target.next;
			}
			else//添加src元素做插入操作
			{
				ListNode node=src;
				src=src.next;
				//插入
				node.next=prev.next;
				prev.next=node;
				//后移
				prev=node;
			}
		}
		
		if(src!=null && src.next!=null)//src未完，直接全部连入目标列表
		{
			prev.next=src;
		}
		
        return result;
    }
	
}

class ListNode
{
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}