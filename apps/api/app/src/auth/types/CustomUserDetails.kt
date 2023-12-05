package auth.types

import auth.models.Group
import auth.models.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class CustomUserDetails(val user: User, val groups: Set<Group> = setOf()) : UserDetails {
	override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
		return groups.map { "GROUP_${it.name}" }
			.plus(groups.flatMap { it.roles }.plus(user.roles).map { "ROLE_${it.name}" })
			.plus(groups.flatMap { it.roles.flatMap { role -> role.permissions } }
				.plus(user.roles.flatMap { it.permissions }.plus(user.permissions)).map { it.name })
			.map { SimpleGrantedAuthority(it) }.toMutableList()
	}

	override fun getPassword(): String = user.password

	override fun getUsername(): String = user.username

	override fun isAccountNonExpired(): Boolean = true

	override fun isAccountNonLocked(): Boolean = !user.locked

	override fun isCredentialsNonExpired(): Boolean = true

	override fun isEnabled(): Boolean = !user.disabled

}