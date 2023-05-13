package UseCases.Admins;

import Model.Entities.Admin;
import Model.Repositories.AdminsRepository;

// Login as Admin

public class LoginUseCase {
    public static boolean login(String email, String password) {
        Admin admin = AdminsRepository.getAdminByEmail(email);

        if (admin != null) {
            return admin.comparePassword(password);
        }
        return false;
    }
}
