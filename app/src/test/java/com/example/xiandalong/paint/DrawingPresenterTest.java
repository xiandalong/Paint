package com.example.xiandalong.paint;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class DrawingPresenterTest {


    @Mock
    DrawingInterface mockView;

    DrawingPresenter mockPresenter;

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
        mockPresenter.colorPanelButtonClicked();
        verify(mockView).changeColorPanelVisibility();
    }

    @Test
    public void testBrushButtonClicked() throws Exception {
        mockPresenter.brushButtonClicked();
        verify(mockView).changeBrushSizePanelVisibility();
    }
}