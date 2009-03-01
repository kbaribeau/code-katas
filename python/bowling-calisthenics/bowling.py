class Bowling:
    def calculate(self, input):
        result = 0
        game = Game(input)
        for index, char in enumerate(input):
            frame = Frame(index, game)
            result += frame.score()
        return result

class Game:
    def __init__(self, input):
        self.input = input

    def getRoll(self, frameIndex):
        return Roll(self.input[frameIndex])
    def len(self):
        return len(self.input)
        
class Frame:
    def __init__(self, frameIndex, game):
        self.frameIndex = frameIndex
        self.game = game

    def score(self):
        roll = self.game.getRoll(self.frameIndex)
        result = roll.score()

        if (roll.isStrike() and self.game.len() != self.frameIndex + 3):
            nextRoll = self.game.getRoll(self.frameIndex+1)
            twoRollsLater = self.game.getRoll(self.frameIndex+2)
            result += nextRoll.score()
            result += twoRollsLater.score()

        return result

class Roll:

    def __init__(self, value):
        self.value = value
    def isStrike(self):
        return self.value == 'X'

    def score(self):
        if (self.value == 'X'):
            return 10
        return int(self.value)
