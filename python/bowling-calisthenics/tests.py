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

class FrameBuilderTest(unittest.TestCase):
    def test_build_shouldSetLength_ForOneFrame(self):
        builder = bowling.FrameBuilder('52')
        frame = builder.build()
        self.assertEquals(2, frame.length())

    def test_build_shouldSetLength_ForOneFrameWithAStrike(self):
        builder = bowling.FrameBuilder('X12')
        frame = builder.build()
        self.assertEquals(3, frame.length())

if __name__=='__main__':
    unittest.main()
