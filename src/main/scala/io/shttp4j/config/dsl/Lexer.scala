package io.shttp4j.config.dsl

import scala.util.parsing.combinator.RegexParsers

object Lexer extends RegexParsers {

  private def oauth: Parser[Token] = "oauth" ^^ (_ => OAuthToken)

  private def loadbalance: Parser[Token] = "loadbalance" ^^ (_ => LoadBalanceToken)

  private def failover: Parser[Token] = "failover" ^^ (_ => FailOverToken)

  def tokens: Parser[List[Token]] = phrase(rep(oauth | loadbalance | failover))

  def apply(code: String): Either[LexerError, List[Token]] = {
    parse(tokens, code) match {
      case NoSuccess(msg, next) => Left(LexerError(Location(next.pos.line, next.pos.column), msg))
      case Success(result, _) => Right(result)
    }
  }
}
