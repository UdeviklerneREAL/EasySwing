package com.udeGames.easySwing;

public class JEasyAdvancedLayoutManager {
    private JEasyLayoutManager _jEasyLayoutManager;
    private int _xOffset;
    private int _yOffset;
    public JEasyAdvancedLayoutManager(JEasyLayoutManager jEasyLayoutManager, int xOffset, int yOffset) {
        _jEasyLayoutManager = jEasyLayoutManager;
        _xOffset = xOffset;
        _yOffset = yOffset;
    }

    public JEasyLayoutManager get_jEasyLayoutManager() {
        return _jEasyLayoutManager;
    }

    public int get_xOffset() {
        return _xOffset;
    }

    public int get_yOffset() {
        return _yOffset;
    }
}