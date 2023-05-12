package Model.Repositories;

import java.util.ArrayList;

import Model.Entities.DonationRegistry;

public class DonationHistoryRepository {
    private ArrayList<DonationRegistry> donationsHistory = new ArrayList<DonationRegistry>();

    public void add(DonationRegistry newDonationRegistry){
        donationsHistory.add(newDonationRegistry);
    }
    
    public ArrayList<DonationRegistry> getAll() {
        return donationsHistory;
    }

    public DonationRegistry getById(String id) {
        for (DonationRegistry donationRegistry: donationsHistory) {
            if (donationRegistry.getId().equals(id)) {
                return donationRegistry;
            }
        }

        return null;
    }

    public DonationRegistry getByDonatorId(String donatorId) {
        for (DonationRegistry donationRegistry: donationsHistory) {
            if (donationRegistry.getdonatorID().equals(donatorId)) {
                return donationRegistry;
            }
        }

        return null;
    }

    public void deleteByID(String id) {
        for (DonationRegistry donationRegistry: donationsHistory) {
            if (donationRegistry.getdonatorID().equals(id)) {
                donationsHistory.remove(donationRegistry);
                break;
            }
        }
    }

    public void deleteByDonatorId(String donatorId) {
        for (DonationRegistry donationRegistry: donationsHistory) {
            if (donationRegistry.getdonatorID().equals(donatorId)) {
                donationsHistory.remove(donationRegistry);
            }
        }
    }
}
