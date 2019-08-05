package io.shttp4j.config.dsl

import scala.util.parsing.input.Positional

sealed abstract trait Token extends Positional

case object OAuthToken extends Token

case object LoadBalanceToken extends Token

case object FailOverToken extends Token

case class UrlToken(value: String) extends Token

case class SocketAddressToken(ip: String, port: Int) extends Token

case class StatusCodeToken(value: Int) extends Token

case class HealthCheckToken() extends Token


