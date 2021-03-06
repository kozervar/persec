package iww.persec.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.*

@Repository
interface RoleRepository : JpaRepository<Role, Long>

@Table(name = "ROLE")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "name")
data class Role constructor(


        @Id
        @SequenceGenerator(name = "role_seq", sequenceName = "role_seq", allocationSize = 1, initialValue = 100)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
        var id: Long = -1,

        @Column
        var name: String = "",

        @JsonIgnore
        @OneToMany(mappedBy = "role")
        var users: List<UserRole> = arrayListOf()

)