package iww.pspdf.persec.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Repository
interface UserRepository : JpaRepository<User, Long>

@Table(name = "USR")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "userName")
data class User constructor(

        @Id
        @SequenceGenerator(name = "usr_seq", sequenceName = "usr_seq", allocationSize = 1, initialValue = 100)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usr_seq")
        var id: Long = -1,

        @Temporal(TemporalType.TIMESTAMP)
        @Column
        var last_update_date: Date,

        @Column
        var modifiedBy: String = "",

        @Column(nullable = false)
        @NotNull
        var enabled: Boolean = false,

        @Column(nullable = false)
        @NotNull
        var firstName: String = "",

        @Column(nullable = false)
        @NotNull
        var lastName: String = "",

        @Column(nullable = false)
        @NotNull
        var userName: String = "",

        @Column(nullable = false)
        @NotNull
        var email: String = "",

        @Column(nullable = false)
        @NotNull
        var password: String = "",

        @Column(nullable = false)
        @NotNull
        var salt: String = "",

        @OneToMany(mappedBy = "user")
        var roles: List<UserRole>
)