class Bowling:
    def calculate(self, input):
        result = 0
        for char in input:
            if (char == 'X'):
                result += 10
                continue
            result += int(char)
        return result
