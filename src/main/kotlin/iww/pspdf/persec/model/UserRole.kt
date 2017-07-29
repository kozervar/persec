package iww.pspdf.persec.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.io.Serializable
import javax.persistence.*

@Repository
interface UserRoleRepository : JpaRepository<UserRole, Long> {

        @Query("SELECT ur.role FROM UserRole ur WHERE ur.user.id = ?1")
        fun findUserRoles(userId:Long):MutableList<Role>

        @Query("SELECT ur.user FROM UserRole ur WHERE ur.role.id = ?1")
        fun findRoleUsers(roleId:Long):MutableList<User>
}


@Table(name = "USR_ROLE")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.None::class)
data class UserRole constructor(

        @JsonIgnore
        @Id
        @SequenceGenerator(name= "usr_role_seq", sequenceName = "usr_role_seq", allocationSize = 1, initialValue=100)
        @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "usr_role_seq")
        var id: Long = -1,

        @JsonIgnore
        @ManyToOne(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name="usr_id", nullable=false)
        var user:User,
        
        @ManyToOne(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name="role_id", nullable=false)
        var role:Role

)