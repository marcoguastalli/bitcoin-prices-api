package net.marco27.api.controller;

import static net.marco27.api.controller.ExceptionController.PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExceptionControllerTest {

    private ExceptionController exceptionController;

    @BeforeEach
    public void init() {
        exceptionController = new ExceptionController();
    }

    @Test
    public void testReleaseNotes() {
        assertEquals(PATH, exceptionController.getErrorPath());
    }
}
