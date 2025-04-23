package app.dao.model.autosys

import app.dao.model.StaticUtils

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class AutosysJob {

    private static final long serialVersionUID = 3327643027629528402L

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    String jobName

    @Override
    String toString() {
        StaticUtils.GSON.toJson(this)
    }
}
