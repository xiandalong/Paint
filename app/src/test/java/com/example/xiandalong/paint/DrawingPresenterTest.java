package com.example.xiandalong.paint;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class DrawingPresenterTest {

    @Mock
    private DrawingInterface mockView;

    private DrawingPresenter mockPresenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockPresenter = new DrawingPresenter(mockView);
    }

    @Test
    public void testResetButtonClicked() throws Exception {
        mockPresenter.resetButtonClicked();
        verify(mockView).resetDrawing();
    }

    @Test
    public void testSaveButtonClicked() throws Exception {
        mockPresenter.saveButtonClicked();
        verify(mockView).saveDrawing();
    }

    @Test
    public void testColorPanelButtonClicked() throws Exception {
        verify(mockView).isColorPanelVisible();
    }

    @Test
    public void brushButtonClicked() throws Exception {

    }

    @Test
    public void colorBlackChosen() throws Exception {

    }

    @Test
    public void colorGreyChosen() throws Exception {

    }

    @Test
    public void brushSize1Chosen() throws Exception {

    }

    @Test
    public void brushSize2Chosen() throws Exception {

    }

    @Test
    public void brushSize3Chosen() throws Exception {

    }
}