class Bowling:
    def calculate(self, input):
        result = 0
        for char in input:
            result += self.calculateSingleRoll(char)
        return result

    def calculateSingleRoll(self, roll):
        if (roll == 'X'):
            return 10
        return int(roll)
