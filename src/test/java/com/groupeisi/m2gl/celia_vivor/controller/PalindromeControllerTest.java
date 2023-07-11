package com.groupeisi.m2gl.celia_vivor.controller;

import com.groupeisi.m2gl.celia_vivor.model.PalindromeRequest;
import com.groupeisi.m2gl.celia_vivor.model.PalindromeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeControllerTest {
private PalindromeController palindromeController;
@BeforeEach
public void setup(){
    palindromeController = new PalindromeController();
}
@Test
    public void testPalindromeMot(){
    PalindromeRequest request= new PalindromeRequest();
    request.setMotAverifier("kayak");

    ResponseEntity<PalindromeResponse> responseEntity = palindromeController.checkPalindrome(request);

    assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
}
@Test
    public void testNonPalindromeMot(){
    PalindromeRequest request = new PalindromeRequest();
    request = new PalindromeRequest();
    request.setMotAverifier("genie");

    ResponseEntity<PalindromeResponse> responseEntity = palindromeController.checkPalindrome(request);
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(false, responseEntity.getBody().isPalindrome());
}

}