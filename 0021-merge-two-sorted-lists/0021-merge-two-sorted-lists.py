# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode(-1) # 리스트 초기화
        cursor = head 

        while list1 != None and list2 != None:
            if list1.val < list2.val:
                cursor.next = list1
                list1 = list1.next # 다음 노드를 가리키도록
            else:
                cursor.next = list2
                list2 = list2.next
            cursor = cursor.next 
        
        if list1 != None:
            cursor.next = list1
        else:
            cursor.next = list2

        return head.next