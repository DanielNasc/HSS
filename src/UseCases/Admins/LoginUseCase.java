package UseCases.Admins;

import Model.Entities.Admin;
import Model.Repositories.AdminsRepository;

// Login as Admin

public class LoginUseCase {
    public static String login(String email, String password) {
        Admin admin = AdminsRepository.getAdminByEmail(email);

        if (admin != null && admin.comparePassword(password)) {
            return admin.getId();
        }
        return null;
    }
}
