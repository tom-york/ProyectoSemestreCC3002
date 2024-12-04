package model.patterns.observer

import scala.collection.mutable.ArrayBuffer

/** Abstract base class implementing the Subject interface for the Observer pattern.
 *
 * Manages a collection of observers and provides default implementations
 * for registering and notifying observers.
 *
 * @tparam T The type of data passed during notification
 */
abstract class Subject[T] extends ISubject[T] {
  /** Internal collection of registered observers. */
  private val observers: ArrayBuffer[Observer[T]] = ArrayBuffer()

  /** Registers an observer to the collection.
   *
   * @param o The observer to be added
   */
  def registerObserver(o: Observer[T]): Unit = observers += o

  /** Notifies all registered observers with the given response.
   *
   * @param response The data to pass to each observer
   */
  def notifyObservers(response: T): Unit = {
    for (o <- observers) {
      o.update(this, response)
    }
  }
}
