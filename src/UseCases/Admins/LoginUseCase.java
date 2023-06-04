package UseCases.Admins;

import Errors.NotFoundDataException;
import Model.Entities.Admin;
import Model.Repositories.AdminsRepository;

// Login as Admin

public class LoginUseCase {
    public static String login(String email, String password) throws NotFoundDataException {
        Admin admin = AdminsRepository.getAdminByEmail(email);

        if (admin != null && admin.comparePassword(password)) {
            return admin.getId();
        }
        
        throw new NotFoundDataException("Admin", "Email ou senha incorretos");
    }
}
