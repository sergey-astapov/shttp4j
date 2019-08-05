package io.shttp4j.config.dsl

import org.scalatest.FunSuite

class LexerTest extends FunSuite {
  test("Failover") {
    assertResult(
      Right(List(
        FailOverToken,
        UrlToken,
        List(SocketAddressToken("220.241.92.116", 50000), SocketAddressToken("23.102.224.158", 50000)),
        List(StatusCodeToken(200), StatusCodeToken(203))))
    )(Lexer("failover(http://pegasus.hkjc.com/webhook/scb,[220.241.92.116:50000,23.102.224.158:50000],[200,203])"))
  }
}
