package model.exceptions

/**
 * Exception thrown when there's an incompatibility between a source and target entity.
 *
 * @param sourceName The name of the source entity.
 * @param targetName The name of the target entity.
 * @throws InvalidSourceTarget when attempting to interact between incompatible source and target entities.
 */
class InvalidSourceTarget(sourceName: String, targetName: String) extends Exception(s"The source $targetName isn't compatible with the target $sourceName"){
}
