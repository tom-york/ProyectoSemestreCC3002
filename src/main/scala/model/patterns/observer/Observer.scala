package model.patterns.observer

trait Observer[T] {
 def update(o: ISubject[T], arg: T): Unit
}
