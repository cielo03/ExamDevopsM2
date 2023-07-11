package com.groupeisi.m2gl.celia_vivor.model;

public class PalindromeResponse {
    private boolean isPalindrome;

    public PalindromeResponse(boolean isPalindrome) {
        this.isPalindrome = isPalindrome;
    }

    public boolean isPalindrome() {
        return isPalindrome;
    }

    public void setPalindrome(boolean palindrome) {
        isPalindrome = palindrome;
    }
}
