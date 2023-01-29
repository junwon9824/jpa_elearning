package io.sample.learn.controller;

import io.sample.learn.dto.Filebuyrequest;
import io.sample.learn.dto.Filesaverequest;
import io.sample.learn.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.sample.learn.service.FileService;

@RestController
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;
    private final SignService signService;
    @PostMapping(value = "/user/save/file")
    public ResponseEntity<String> save( @RequestBody Filesaverequest filesaverequest) {
        return new ResponseEntity<> (fileService.save(filesaverequest),HttpStatus.OK );

    }


    @PostMapping(value = "/user/buy/file")
    public ResponseEntity<String> buy(@RequestBody Filebuyrequest filebuyrequest)
    {
        return new ResponseEntity<>(fileService.buy(filebuyrequest) ,HttpStatus.OK);
    }

}
