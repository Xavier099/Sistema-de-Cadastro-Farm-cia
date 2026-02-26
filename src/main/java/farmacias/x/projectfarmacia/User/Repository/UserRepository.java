package farmacias.x.projectfarmacia.User.Repository;

import farmacias.x.projectfarmacia.User.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
