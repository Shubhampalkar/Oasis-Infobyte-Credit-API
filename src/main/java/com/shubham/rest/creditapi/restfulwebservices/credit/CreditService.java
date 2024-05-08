package com.shubham.rest.creditapi.restfulwebservices.credit;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditService {

    private List<Credit> credits = new ArrayList<>();
    private Long nextId = 1L;

    public CreditService() {
        // Adding sample credits
        credits.add(new Credit(nextId++, 1000.0));
        credits.add(new Credit(nextId++, 2000.0));
        credits.add(new Credit(nextId++, 1500.0));
    }
    
    public List<Credit> getAllCredits() {
        return credits;
    }

    public Credit getCreditById(Long creditId) {
        for (Credit credit : credits) {
            if (credit.getId().equals(creditId)) {
                return credit;
            }
        }
        return null;
    }

    public Credit createCredit(Credit credit) {
        credit.setId(nextId);
        credits.add(credit);
        nextId++;
        return credit;
    }

    public Credit updateCredit(Long creditId, Credit updatedCredit) {
        for (Credit credit : credits) {
            if (credit.getId().equals(creditId)) {
                credit.setAmount(updatedCredit.getAmount());
                // Update other fields as needed
                return credit;
            }
        }
        return null;
    }

    public void deleteCredit(Long creditId) {
        credits.removeIf(credit -> credit.getId().equals(creditId));
    }
}
