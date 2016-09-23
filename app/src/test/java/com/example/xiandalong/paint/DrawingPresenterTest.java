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
        mockPresenter.colorPanelButtonClicked();
        verify(mockView).isColorPanelVisible();
    }

    @Test
    public void testBrushButtonClicked() throws Exception {
        mockPresenter.brushButtonClicked();
        verify(mockView).isBrushSizePanelVisible();
    }

    @Test
    public void testColorBlackChosen() throws Exception {
        mockPresenter.colorBlackChosen();
        verify(mockView).hideColorPanel();
    }

    @Test
    public void testColorGreyChosen() throws Exception {
        mockPresenter.colorGreyChosen();
        verify(mockView).hideColorPanel();
    }

    @Test
    public void testBrushSize1Chosen() throws Exception {
        mockPresenter.brushSize1Chosen();
        verify(mockView).hideBrushSizePanel();
    }

    @Test
    public void testBrushSize2Chosen() throws Exception {
        mockPresenter.brushSize2Chosen();
        verify(mockView).hideBrushSizePanel();
    }

    @Test
    public void testBrushSize3Chosen() throws Exception {
        mockPresenter.brushSize3Chosen();
        verify(mockView).hideBrushSizePanel();
    }
}