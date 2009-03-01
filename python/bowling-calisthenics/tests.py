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
    
if __name__=='__main__':
    unittest.main()
