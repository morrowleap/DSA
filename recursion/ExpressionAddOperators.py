# https://leetcode.com/problems/expression-add-operators/description/
# https://algo.monster/liteproblems/282
# https://leetcode.com/problems/expression-add-operators/submissions/1498810068/

# https://youtu.be/WcgjFrZceU8 

# https://youtu.be/S6OG5pGWxIw 

# https://algo.monster/liteproblems/282

class Solution:
    def dfs(self, num, index, expressions, curr, result, target):
        if index == len(num):
            try:
                if eval(curr) == target:
                    result.append(curr)
            except:
                pass
            return

        for i in range(index, len(num)):
            if i > index and num[index] == "0":
                break
            part = num[index:i + 1]
            if index == 0:
                self.dfs(num, i + 1, expressions, part, result, target)
            else:
                for exp in expressions:
                    self.dfs(num, i + 1, expressions, curr + exp + part, result, target)

    def addOperators(self, num, target):
        result = []
        expressions = ["+", "-", "*"]
        self.dfs(num, 0, expressions, "", result, target)
        return result

if __name__ == "__main__":
    num = input("Enter the number string: ")
    target = int(input("Enter the target value: "))
    sol = Solution()
    results = sol.addOperators(num, target)
    print("Possible expressions:")
    for expr in results:
        print(expr)
