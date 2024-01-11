package com.hieucodeg.api;

import com.hieucodeg.domain.entity.DatabaseCheck;
import com.hieucodeg.service.databaseCheck.IDatabaseCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/check-database")
public class DatabaseCheckAPI {


    @Autowired
    private IDatabaseCheckService databaseCheckService;

    @GetMapping
    public ResponseEntity<?> getDatabaseCheck() {

        DatabaseCheck databaseCheck = databaseCheckService.getDatabaseCheck();

        return new ResponseEntity<>(databaseCheck, HttpStatus.OK);
    }

    @GetMapping("update-table")
    public ResponseEntity<?> updateTableCheck(){
        DatabaseCheck databaseCheck = databaseCheckService.updateWithTableCheck();
        return new ResponseEntity<>(databaseCheck, HttpStatus.OK);
    }

    @GetMapping("update-product")
    public ResponseEntity<?> updateProductCheck(){
        DatabaseCheck databaseCheck = databaseCheckService.updateWithProductCheck();
        return new ResponseEntity<>(databaseCheck, HttpStatus.OK);
    }
}
