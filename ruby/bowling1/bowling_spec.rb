#!/usr/bin/ruby
require 'bowling'

describe Bowling do
  before(:each) do
    @bowling = Bowling.new
  end

  it "should score 1 for 1 game" do
    @bowling.score('1').should == 1
  end
  
  it "should sum scores for game with 1 frame" do
    @bowling.score('12').should == 3
  end

  it "should account for a Strike in the last frame" do
    @bowling.score('X12').should == 13
  end

  it "should account for a strike in a frame other than the last" do
    @bowling.score('X1212').should == 19
  end

  it "should account for a strike as the last roll" do
    @bowling.score('X1X').should == 21
  end

  it "should account for a spare at the end of the game" do
    @bowling.score('1/1').should == 11
  end

  it "should account for a spare in an earlier frame" do
    @bowling.score('1/12').should == 14
  end

  it "should account for strike followed by spare" do
    @bowling.score('X1/5').should == 35
  end

  it "should account for spare followed by strike" do
    @bowling.score('5/X12').should == 33
  end

  it "should account for a spare in an earlier frame" do
    @bowling.score('5/5/5').should == 30
  end

  it "should score perfect game correctly" do
    @bowling.score('XXXXXXXXXXXX').should == 300
  end

  it "should score game with lots of spares correctly" do
    @bowling.score('5/5/5/5/5/5/5/5/5/5/5').should == 150
  end

end
