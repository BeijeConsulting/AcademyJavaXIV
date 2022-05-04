package it.beije.turing.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class MyUtils {

    public String genName(){
        return RandomStringUtils.random((new Random()).nextInt(15),"abcdefghijklmnopqrstuvwxyz");
    }
    public String getSuranme(){
        return RandomStringUtils.random((new Random()).nextInt(15),"abcdefghijklmnopqrstuvwxyz");
    }


    public String genEmail() {
        return RandomStringUtils.random((new Random()).nextInt(15), "abcdefghijklmnopqrstuvwxyz") + "@" + RandomStringUtils.random((new Random()).nextInt(4), "abcdefghijklmnopqrstuvwxyz")+".com";
    }
    public String getTel() {
        return RandomStringUtils.random(10, "0123456789");
    }

    public String genNote() {
        return RandomStringUtils.random((new Random()).nextInt(100));
    }
}
