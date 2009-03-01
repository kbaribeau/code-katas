class Bowling:
    def calculate(self, input):
        result = 0
        scoreSheet = ScoreSheet(input)
        frame = Frame(scoreSheet)
        result += frame.score()
        return result

class ScoreSheet:
    def __init__(self, scoreString):
        self.scoreString = scoreString

    def getRoll(self, rollIndex):
        return Roll(self.scoreString[rollIndex])

    def len(self):
        return len(self.scoreString)
        
class Frame:
    def __init__(self,scoreSheet):
        self.scoreSheet = scoreSheet

    def score(self):
        result = 0
        for index, char in enumerate(self.scoreSheet.scoreString):
            roll = self.scoreSheet.getRoll(index)
            result += roll.score()

            if (roll.isStrike() and not self.isLastFrame(index)):
                nextRoll = self.scoreSheet.getRoll(index+1)
                twoRollsLater = self.scoreSheet.getRoll(index+2)
                result += nextRoll.score()
                result += twoRollsLater.score()

        return result

    def isLastFrame(self, index):
        return self.scoreSheet.len() == index + 3

    def length(self):
        return self.scoreSheet.len()

class Roll:

    def __init__(self, value):
        self.value = value
    def isStrike(self):
        return self.value == 'X'

    def score(self):
        if (self.value == 'X'):
            return 10
        return int(self.value)

class GameBuilder:
    def __init__(self, frameStr):
        self.frameStr = frameStr

    def build(self):
        game = []
        index = 0
        while(index < len(self.frameStr)):
            if (Roll(self.frameStr[index]).isStrike()):
                game.append(Frame(ScoreSheet(self.frameStr[index:index+3])))        
                index += 3
            else:
                game.append(Frame(ScoreSheet(self.frameStr[index:index+2])))
                index += 2
        return game
