package com.example.mbp0626;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class LoggerTest {

    @Test
    void testLog(){
        log.debug("debug...");
        log.info("info...");
        log.error("error");
    }
}
