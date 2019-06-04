package com.saxion.nl.ns.ithardwaremanager;

import com.saxion.nl.ns.ithardwaremanager.controllers.LoginController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LoginControllerTest {

    @Test
    public void thereIsALoginPage() {
        Assert.assertNotEquals("", (new LoginController()).index(null));
    }
}
