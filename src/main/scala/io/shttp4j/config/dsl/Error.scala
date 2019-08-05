package io.shttp4j.config.dsl

sealed trait Error {
  def +(other: Error): Error
}

case class LexerError(location: Location, msg: String) extends Error {
  override def +(other: Error): Error = LexerError(location, s"$msg, $other")
}

case class ParserError(msg: String) extends Error {
  override def +(other: Error): Error = ParserError(s"$msg, $other")
}

case class Location(line: Int, column: Int) {
  override def toString = s"$line:$column"
}
