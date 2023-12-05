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
 * Represents an input for creating a role.
 */
public data class CreateRoleInput(
  /**
   * The name of the role.
   */
  public val name: String,
  /**
   * The description of the role.
   */
  public val description: Optional<String?> = Optional.Absent,
  /**
   * The unique identifiers of the associated permissions.
   */
  public val permissions: Optional<List<String>?> = Optional.Absent,
)