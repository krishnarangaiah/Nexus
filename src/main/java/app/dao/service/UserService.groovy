package app.dao.service


import app.dao.model.user.AppUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private UserRepo userRepo

    void save(AppUser user) {
        userRepo.save(user)
    }

    AppUser findById(Long id) {
        return userRepo.findById(id).orElse(null)
    }

    void delete(AppUser user) {
        userRepo.delete(user)
    }

    List<AppUser> findAll() {
        return userRepo.findAll()
    }

    List<AppUser> authenticate(String userName) {
        return userRepo.findByUserName(userName)
    }

}
