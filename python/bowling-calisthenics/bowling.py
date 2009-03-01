class Bowling:
    def calculate(self, input):
        result = 0
        for char in input:
            result += int(char)
        return result
