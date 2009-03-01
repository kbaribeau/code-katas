import unittest
import bowling

class BowlingTest(unittest.TestCase):
    bowl = bowling.Bowling()

    def test_bowling_shouldCalculateGameWithOneFrame(self):
        score = self.bowl.calculate('52')
        self.assertEquals(7, score)

    def test_bowling_shouldCalculateGameWithOneFrame2(self):
        score = self.bowl.calculate('27')
        self.assertEquals(9, score)

    def test_bowling_shouldCalculateGameWithStrike(self):
        score = self.bowl.calculate('X12')
        self.assertEquals(13, score)

    def test_bowling_shouldCalculateGameWithStrikeAndMore(self):
        score = self.bowl.calculate('X1234')
        self.assertEquals(23, score)

class GameBuilderTest(unittest.TestCase):
    def test_build_shouldSetLength_ForOneFrame(self):
        builder = bowling.GameBuilder('52')
        game = builder.build()
        self.assertEquals(2, game[0].length())

    def test_build_shouldSetLength_ForOneFrameWithAStrike(self):
        builder = bowling.GameBuilder('X12')
        game = builder.build()
        self.assertEquals(3, game[0].length())

    def test_build_shouldBuildTwoFrames(self):
        builder = bowling.GameBuilder('X1234')
        game = builder.build()

        self.assertEquals(3, game[0].length())
        self.assertEquals(2, game[1].length())

if __name__=='__main__':
    unittest.main()
