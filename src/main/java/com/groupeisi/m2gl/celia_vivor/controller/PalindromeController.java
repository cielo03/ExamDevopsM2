package com.groupeisi.m2gl.celia_vivor.controller;

import com.groupeisi.m2gl.celia_vivor.model.PalindromeRequest;
import com.groupeisi.m2gl.celia_vivor.model.PalindromeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PalindromeController {
    @PostMapping("/checkpalindrome/")
    public ResponseEntity<PalindromeResponse> checkPalindrome(@RequestBody PalindromeRequest request){
        String motAverifier = request.getMotAverifier();
        boolean isPalindrome = isPalindrome(motAverifier);
        PalindromeResponse response = new PalindromeResponse(isPalindrome);
        HttpStatus status = isPalindrome ? HttpStatus.ACCEPTED : HttpStatus.OK;
        return ResponseEntity.status(status).body(response);

}

private boolean isPalindrome(String mot) {
        int lenth = mot.length();
        for (int i = 0; i< lenth / 2; i++ ){
            if(mot.charAt(i) != mot.charAt(lenth - i - 1)){
                return false;
            }
        }
        return true;
}
}
