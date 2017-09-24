package com.ylx.librarymanage.service.Impl;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.Assert.*;

@SpringBootTest
public class DeleteServiceImplTest {

    @Test
    public void testSplit(){
        String a = "1,2,3,";
        String[] sp = a.split(",");
        for (String r :
                sp) {
            System.out.println(r);
        }
    }

}