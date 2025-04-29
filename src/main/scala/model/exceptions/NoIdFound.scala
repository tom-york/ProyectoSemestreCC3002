package model.exceptions

/**
 * Exception thrown when attempting to fetch an entity using an invalid or non-existent ID.
 *
 * @param id The ID that couldn't be found in the system.
 * @throws NoIdFound when attempting to fetch an entity with an ID that doesn't exist.
 */
class NoIdFound(id: String) extends Exception(s"The id $id couldn't be found and fetched.") {
}