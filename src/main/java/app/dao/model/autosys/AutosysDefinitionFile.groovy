package app.dao.model.autosys

import app.dao.model.user.Role
import com.google.gson.Gson

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class AutosysDefinitionFile implements Serializable{

    private static final long serialVersionUID = 3327643027629528402L
    private static Gson gson = new Gson()

    @Id
    @GeneratedValue
    Long id;
    @Column(unique = true, nullable = false)
    String absoluteFile
    @Column(nullable = false)

    @Override
    String toString() {
        gson.toJson(this)
    }

}
