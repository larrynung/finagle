package com.twitter.finagle.http

class ClassicHttp2AlpnTest extends AbstractHttp2AlpnTest {
  def implName: String = "alpn http/2"
  def useMultiplexCodec: Boolean = false
}

class MultiplexedHttp2AlpnTest extends AbstractHttp2AlpnTest {
  def implName: String = "alpn http/2-multiplex"
  def useMultiplexCodec: Boolean = true

  // Should be fixed when https://github.com/netty/netty/issues/8434 is fixed.
  override def featureImplemented(feature: Feature): Boolean =
    feature != MaxHeaderSize && super.featureImplemented(feature)
}
