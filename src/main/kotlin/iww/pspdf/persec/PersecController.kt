package iww.pspdf.persec

import iww.pspdf.persec.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class PersecController {

    @Autowired
    lateinit var roleRepository: RoleRepository

    @Autowired
    lateinit var permissionRepository: PermissionRepository

    @Autowired
    lateinit var rolePermissionRepository: RolePermissionRepository

    @Autowired
    lateinit var userRoleRepository: UserRoleRepository

    @GetMapping("/roles")
    fun getAllRoles(): MutableList<Role>? {
        return roleRepository.findAll()
    }

    @GetMapping("/role/{roleId}/permissions")
    fun getAllRolePermissions(@PathVariable roleId:Long): MutableList<Permission>? {
        return rolePermissionRepository.findRolePermissions(roleId)
    }

    @GetMapping("/permissions")
    fun getAllPermissions(): MutableList<Permission>? {
        return permissionRepository.findAll()
    }

    @GetMapping("/permission/{permissionId}/roles")
    fun getAllPermissionoles(@PathVariable permissionId:Long): MutableList<Role>? {
        return rolePermissionRepository.findPermissionRoles(permissionId)
    }

    @GetMapping("/rp")
    fun getAllRolePermissions(): MutableList<RolePermission>? {
        return rolePermissionRepository.findAll()
    }

    @GetMapping("/user/{userId}/roles")
    fun getAllUserRoles(@PathVariable userId:Long): MutableList<Role>? {
        return userRoleRepository.findUserRoles(userId)
    }

    @GetMapping("/role/{roleId}/users")
    fun getAllRoleUsers(@PathVariable roleId:Long): MutableList<User>? {
        return userRoleRepository.findRoleUsers(roleId)
    }
}