package iww.pspdf.persec.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.*

@Repository
interface PermissionRepository : JpaRepository<Permission, Long>

@Table(name = "PERMISSION")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.None::class)
data class Permission constructor(

        @Id
        @SequenceGenerator(name= "permission_seq", sequenceName = "permission_seq", allocationSize = 1, initialValue=100)
        @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "permission_seq")
        var id: Long = -1,

        @Column
        var name: String = "",

        @JsonIgnore
        @ManyToOne(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
        var parent:Permission,

        @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
        var subPermissions: List<Permission> = ArrayList()
)