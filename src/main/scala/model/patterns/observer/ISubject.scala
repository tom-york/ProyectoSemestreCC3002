package model.patterns.observer

/** Interface for implementing the Observer design pattern.
 *
 * Allows registration of observers and notifying them of state changes.
 *
 * @tparam T The type of data passed during notification
 */
trait ISubject[T] {
  /** Registers an observer to be notified of changes.
   *
   * @param o The observer to register
   */
  def registerObserver(o: Observer[T]): Unit

  /** Notifies all registered observers with a response.
   *
   * @param response The data to pass to observers
   */
  def notifyObservers(response: T): Unit
}
