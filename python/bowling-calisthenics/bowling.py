class Bowling:
    def calculate(self, input):
        result = 0
        for char in input:
            roll = Roll(char)
            result += roll.score()
        return result


class Roll:

    def __init__(self, value):
        self.value = value

    def score(self):
        if (self.value == 'X'):
            return 10
        return int(self.value)
