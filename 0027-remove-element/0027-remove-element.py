class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        for i in range(len(nums)):
            if nums[0] != val:
                nums.append(nums[0])
                del nums[0] 
            else:
                del nums[0]
        return len(nums)
        
        # 큐 사용
        # 리스트 하나씩 체크하면 리스트길이 변경으로 out of index
        #  In-place Algorithm
        # 원소들의 개수에 비해 충분히 무시할 만한 저장 공간만을 더 사용하는 정렬 알고리즘