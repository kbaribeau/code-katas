class Bowling:
    def calculate(self, input):
        result = 0
        scoreSheet = ScoreSheet(input)
        for index, char in enumerate(input):
            frame = Frame(index, scoreSheet)
            result += frame.score()
        return result

class ScoreSheet:
    def __init__(self, scoreString):
        self.scoreString = scoreString

    def getRoll(self, frameIndex):
        return Roll(self.scoreString[frameIndex])

    def len(self):
        return len(self.scoreString)
        
class Frame:
    def __init__(self, frameIndex, scoreSheet):
        self.frameIndex = frameIndex
        self.scoreSheet = scoreSheet

    def score(self):
        roll = self.scoreSheet.getRoll(self.frameIndex)
        result = roll.score()

        if (roll.isStrike() and not self.isLastFrame()):
            nextRoll = self.scoreSheet.getRoll(self.frameIndex+1)
            twoRollsLater = self.scoreSheet.getRoll(self.frameIndex+2)
            result += nextRoll.score()
            result += twoRollsLater.score()

        return result

    def isLastFrame(self):
        return self.scoreSheet.len() == self.frameIndex + 3

class Roll:

    def __init__(self, value):
        self.value = value
    def isStrike(self):
        return self.value == 'X'

    def score(self):
        if (self.value == 'X'):
            return 10
        return int(self.value)
