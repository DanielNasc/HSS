package Model.Repositories;

import java.util.ArrayList;

import Model.Entities.DonationRegistry;

public class DonationHistoryRepository {
    private static ArrayList<DonationRegistry> donationsHistory = new ArrayList<DonationRegistry>();

    public static void add(DonationRegistry newDonationRegistry){
        if (donationsHistory.contains(newDonationRegistry)) {
            throw new Error("This donation already exist");
        }

        donationsHistory.add(newDonationRegistry);
    }
    
    public static ArrayList<DonationRegistry> getAll() {
        return donationsHistory;
    }

    public static DonationRegistry getById(String id) {
        for (DonationRegistry donationRegistry: donationsHistory) {
            if (donationRegistry.getId().equals(id)) {
                return donationRegistry;
            }
        }

        return null;
    }

    public static ArrayList<DonationRegistry> getByDonatorId(String donatorId) {
        ArrayList<DonationRegistry> registries = new ArrayList<DonationRegistry>();

        for (DonationRegistry donationRegistry: donationsHistory) {
            if (donationRegistry.getdonatorID().equals(donatorId)) {
                registries.add(donationRegistry);
            }
        }

        return registries;
    }

    public static void deleteByID(String id) {
        for (DonationRegistry donationRegistry: donationsHistory) {
            if (donationRegistry.getdonatorID().equals(id)) {
                donationsHistory.remove(donationRegistry);
                break;
            }
        }
    }

    public static void deleteByDonatorId(String donatorId) {
        for (DonationRegistry donationRegistry: donationsHistory) {
            if (donationRegistry.getdonatorID().equals(donatorId)) {
                donationsHistory.remove(donationRegistry);
            }
        }
    }
}
