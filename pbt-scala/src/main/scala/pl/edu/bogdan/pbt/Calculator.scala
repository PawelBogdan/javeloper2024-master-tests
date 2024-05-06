package pl.edu.bogdan.pbt

class Calculator(value: Int) {

  def add(other: Int): Calculator = new Calculator(value + other)

  def sub(other: Int): Calculator = new Calculator(value - other)

  def mul(other: Int): Calculator = new Calculator(value * other)

  def div(other: Int): Calculator = new Calculator(value / other)

  def getCurrentValue: Int = value

}
