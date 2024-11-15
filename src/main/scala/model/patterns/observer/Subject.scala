package model.patterns.observer

import scala.collection.mutable.ArrayBuffer

class Subject[T] extends ISubject[T]{
  private val observers: ArrayBuffer[Observer[T]] = ArrayBuffer()

  def registerObserver(o: Observer[T]): Unit = observers += o

  def notifyObservers(response: T): Unit = {
    for (o <- observers) {
      o.update(this, response)
    }
  }
}
