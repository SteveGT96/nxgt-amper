//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.type

import com.apollographql.apollo3.api.Optional
import kotlin.String

/**
 * Represents an input for creating a permission.
 */
public data class CreatePermissionInput(
  /**
   * The name of the permission.
   */
  public val name: String,
  /**
   * The description of the permission.
   */
  public val description: Optional<String?> = Optional.Absent,
)