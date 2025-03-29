package app.dao.model.user

import com.google.gson.Gson

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class AppUser implements Serializable {

    private static final long serialVersionUID = 3327643027629528402L
    private static Gson gson = new Gson()

    @Id
    @GeneratedValue
    Long id;
    @Column(unique = true, nullable = false)
    String userName
    @Column(nullable = false)
    String password
    @Column(nullable = false)
    Role role
    @Column(nullable = false)
    String email
    @Column(nullable = false, columnDefinition = "int default 0")
    int loginCount
    @Column
    String sessionId

    @Override
    String toString() {
        gson.toJson(this)
    }
}