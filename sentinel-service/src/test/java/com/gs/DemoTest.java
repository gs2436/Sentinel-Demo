package com.gs;

import com.gs.cloudAlibaba.SentinelServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SentinelServiceApplication.class)
public class DemoTest {

    @Test
    public void say() {
        //String s = nacosConfig.getUserService();
        //System.out.println(s);
    }

}
