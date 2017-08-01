package iww.persec.security

import iww.persec.model.Role
import iww.persec.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


class JdbcUserDetails : UserDetails {

    var user: User

    var authorities: ArrayList<GrantedAuthority> = arrayListOf()

    constructor(user: User, roles:List<Role>) {
        this.user = user
        authorities.addAll(roles.map { role -> SimpleGrantedAuthority(role.name) })
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return authorities
    }

    override fun isEnabled(): Boolean {
        return user.enabled
    }

    override fun getUsername(): String {
        return user.userName
    }

    override fun isCredentialsNonExpired(): Boolean {
        return !user.credentialsExpired
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun isAccountNonExpired(): Boolean {
        return !user.expired
    }

    override fun isAccountNonLocked(): Boolean {
        return !user.locked
    }

}