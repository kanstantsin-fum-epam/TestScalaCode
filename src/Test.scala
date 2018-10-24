import java.io.File

object Test extends App {

  val fileChunk = Math.ceil(8368432 / 5242880).intValue()

  println("chunkSize "+fileChunk)
  }