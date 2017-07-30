package iww.pspdf.persec.security

import iww.pspdf.persec.model.UserRepository
import iww.pspdf.persec.model.UserRoleRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
class JdbcUserDetailsService(val userRepository: UserRepository, val userRoleRepository: UserRoleRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        if (username != null) {
            val user = userRepository.findByUserName(username) ?: throw UsernameNotFoundException("User $username not found!")
            val roles = userRoleRepository.findUserRoles(user.id)
            return JdbcUserDetails(user, roles)
        } else {
            throw UsernameNotFoundException("Wrong userName provided")
        }
    }
}