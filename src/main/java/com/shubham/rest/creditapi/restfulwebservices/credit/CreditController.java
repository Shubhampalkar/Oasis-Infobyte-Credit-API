package com.shubham.rest.creditapi.restfulwebservices.credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    // Endpoint to get all credits
    @GetMapping
    public ResponseEntity<List<Credit>> getAllCredits() {
        List<Credit> credits = creditService.getAllCredits();
        return new ResponseEntity<>(credits, HttpStatus.OK);
    }

    // Endpoint to get credit by ID
    @GetMapping("/{creditId}")
    public ResponseEntity<Credit> getCreditById(@PathVariable Long creditId) {
        Credit credit = creditService.getCreditById(creditId);
        if (credit != null) {
            return new ResponseEntity<>(credit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to create a new credit
    @PostMapping
    public ResponseEntity<Credit> createCredit(@RequestBody Credit credit) {
        Credit createdCredit = creditService.createCredit(credit);
        return new ResponseEntity<>(createdCredit, HttpStatus.CREATED);
    }

    // Endpoint to update an existing credit
    @PutMapping("/{creditId}")
    public ResponseEntity<Credit> updateCredit(@PathVariable Long creditId, @RequestBody Credit credit) {
        Credit updatedCredit = creditService.updateCredit(creditId, credit);
        if (updatedCredit != null) {
            return new ResponseEntity<>(updatedCredit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete an existing credit
    @DeleteMapping("/{creditId}")
    public ResponseEntity<Void> deleteCredit(@PathVariable Long creditId) {
        creditService.deleteCredit(creditId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
