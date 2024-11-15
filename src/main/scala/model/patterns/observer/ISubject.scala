package model.patterns.observer

trait ISubject[T] {
  def registerObserver(o: Observer[T]): Unit
  def notifyObservers(response: T): Unit
}
