package iww.persec.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.persistence.*

@Repository
interface RolePermissionRepository : JpaRepository<RolePermission, Long> {

        @Query("SELECT rp.permission FROM RolePermission rp WHERE rp.role.id = ?1")
        fun findRolePermissions(roleId:Long):MutableList<Permission>

        @Query("SELECT rp.role FROM RolePermission rp WHERE rp.permission.id = ?1")
        fun findPermissionRoles(permissionId:Long):MutableList<Role>
}


@Table(name = "ROLE_PERMISSION")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.None::class)
data class RolePermission constructor(

        @Id
        @SequenceGenerator(name= "role_permission_seq", sequenceName = "role_permission_seq", allocationSize = 1, initialValue=100)
        @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "role_permission_seq")
        var id: Long = -1,

        @ManyToOne(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name="role_id", nullable=false)
        var role: Role,

        @ManyToOne(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name="permission_id", nullable=false)
        var permission: Permission
)