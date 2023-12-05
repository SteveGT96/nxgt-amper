//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.type

import com.apollographql.apollo3.api.Optional
import kotlin.String
import kotlin.collections.List

/**
 * Represents an input for updating a group.
 */
public data class PatchGroupInput(
  /**
   * The unique identifier of the group.
   */
  public val id: Optional<String?> = Optional.Absent,
  /**
   * The new name of the group.
   */
  public val name: Optional<String?> = Optional.Absent,
  /**
   * The new description of the group.
   */
  public val description: Optional<String?> = Optional.Absent,
  /**
   * The new unique identifiers of the associated roles.
   */
  public val roles: Optional<List<String>?> = Optional.Absent,
  /**
   * The new unique identifiers of the associated permissions.
   */
  public val permissions: Optional<List<String>?> = Optional.Absent,
)