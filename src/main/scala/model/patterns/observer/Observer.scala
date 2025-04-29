package model.patterns.observer

/** Observer interface for receiving updates from a subject in the Observer design pattern.
 *
 * @tparam T The type of data received in updates
 */
trait Observer[T] {
  /** Processes updates from a subject.
   *
   * @param o The subject sending the update
   * @param arg The data passed in the update
   */
  def update(o: ISubject[T], arg: T): Unit
}
