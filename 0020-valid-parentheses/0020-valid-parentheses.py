class Solution:
    def isValid(self, s: str) -> bool:
        dic= {
            ')':'(',
            ']':'[',
            '}':'{'
        }
        
        stack = []
        for c in s:
            if c not in dic:
                stack.append(c)
            elif not stack or stack.pop() != dic[c]:
                return False
            
        
        return not stack