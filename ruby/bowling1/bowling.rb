require 'jcode'

class Bowling
  def score(gameString)
    result = 0
    for i in 0...gameString.length do
      roll = gameString[i].chr
      if (roll == 'X' and i == gameString.length - 3) then
        result += 10
        return result + getValue(gameString[i+1].chr) + getValue(gameString[i+2].chr)
      elsif (roll == 'X')
        result += 10
        if (gameString[i+2].chr == '/') then
          result += 10
        else
          result += getValue(gameString[i+1].chr) + getValue(gameString[i+2].chr)
        end
      elsif (roll == '/' and i == gameString.length - 2) 
        result -= getValue(gameString[i-1].chr)
        return result + calculateSpare(i, gameString, result)
      elsif (roll == '/')
        result -= getValue(gameString[i-1].chr)
        result += calculateSpare(i, gameString, result)
      else
        result += getValue(roll)
      end
    end 
    return result
  end

  def calculateSpare(i, gameString, currentScore) 
        result = 10
        result += getValue(gameString[i+1].chr)
        return result
  end

  def getValue(char)
    return 10 if (char == 'X') 
    return 10 if (char == '/') 
    return Integer(char)
  end
end
