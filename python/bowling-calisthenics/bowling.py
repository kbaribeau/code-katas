class Bowling:
    def calculate(self, input):
        result = 0
        for index, char in enumerate(input):
            roll = Roll(char)
            result += roll.score()
            if (char == 'X' and len(input) != index + 3):
                nextRoll = Roll(input[index+1])
                twoRollsLater = Roll(input[index+2])
                result += nextRoll.score()
                result += twoRollsLater.score()
        return result


class Roll:

    def __init__(self, value):
        self.value = value

    def score(self):
        if (self.value == 'X'):
            return 10
        return int(self.value)
