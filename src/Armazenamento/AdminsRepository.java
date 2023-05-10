package Armazenamento;
import java.util.ArrayList;
import Dados.Admin;

public class AdminsRepository {
    private static ArrayList<Admin> admins = new ArrayList<Admin>();

    public static void add(Admin admin) {
        admins.add(admin);
    }

    public static ArrayList<Admin> getAll() {
        return admins;
    }

    public static Admin getById(String id) {
        for (Admin admin : admins) {
            if (admin.getId().equals(id)) {
                return admin;
            }
        }
        return null;
    }

    public static Admin getAdminByEmail(String email) {
        for (Admin admin : admins) {
            if (admin.getEmail().equals(email)) {
                return admin;
            }
        }
        return null;
    }

    public static void removeById(String id) {
        for (Admin a: admins) {
            if (a.getId().equals(id)) {
                admins.remove(a);
                break;
            }
        }
    }
}