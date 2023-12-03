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
 * GraphQL schema for patching user input
 */
public data class PatchUserInput(
  /**
   * The unique identifier of the token.
   */
  public val id: String,
  /**
   * The user's username.
   */
  public val username: Optional<String?> = Optional.Absent,
  /**
   * The user's password.
   */
  public val password: Optional<String?> = Optional.Absent,
  /**
   * The user's email address.
   */
  public val email: Optional<String?> = Optional.Absent,
  /**
   * The user's avatar image.
   */
  public val avatar: Optional<String?> = Optional.Absent,
  /**
   * A set of groups that the user belongs to.
   */
  public val groups: Optional<List<String>?> = Optional.Absent,
  /**
   * A set of roles that the user has.
   */
  public val roles: Optional<List<String>?> = Optional.Absent,
  /**
   * A set of permissions that the user has.
   */
  public val permissions: Optional<List<String>?> = Optional.Absent,
)
