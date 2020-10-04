package com.udeGames.easySwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class JEasyLayout extends JFrame {

    private ArrayList<_Components> _components;

    public JEasyLayout() {
        super();
        _components = new ArrayList<_Components>();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                onResize();
            }
        });
    }
    public JEasyLayout(String title) {
        super(title);
        _components = new ArrayList<_Components>();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                onResize();
            }
        });
    }
    public JEasyLayout(int width, int height) {
        super();
        setSize(width, height);
        _components = new ArrayList<_Components>();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                onResize();
            }
        });
    }
    public JEasyLayout(String title, int width, int height) {
        super(title);
        setSize(width, height);
        _components = new ArrayList<_Components>();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                onResize();
            }
        });
    }

    public void setup() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Component add(Component component, int width, int height, JEasyLayoutManager jEasyLayoutManager) {
        addImpl(component, null, -1);
        _components.add(new _Components(component, width, height, jEasyLayoutManager));

        setSize(component, width, height, jEasyLayoutManager);
        return component;
    }

    public Component add(Component component, int width, int height, JEasyAdvancedLayoutManager jEasyAdvancedLayoutManager) {
        addImpl(component, null, -1);
        _components.add(new _Components(component, width, height, jEasyAdvancedLayoutManager));

        setSize(component, width, height, jEasyAdvancedLayoutManager);
        return component;
    }

    private void setSize(Component component, int width, int height, JEasyLayoutManager jEasyLayoutManager) {
        switch (jEasyLayoutManager) {
            case TOP:
                component.setBounds(getWidth() / 2 - width / 2, 0, width, height);
                break;
            case NE:
                component.setBounds(getWidth() - width, 0, width, height);
                break;
            case LEFT:
                component.setBounds(getWidth() - width, getHeight() / 2 - height / 2, width, height);
                break;
            case SE:
                component.setBounds(getWidth() - width, getHeight() - height - 34, width, height);
                break;
            case BUTTON:
                component.setBounds(getWidth() / 2 - width / 2, getHeight() - height - 34, width, height);
                break;
            case SW:
                component.setBounds(0, getHeight() - height - 34, width, height);
                break;
            case RIGHT:
                component.setBounds(0,getHeight() / 2 - height / 2, width, height);
                break;
            case NW:
                component.setBounds(0, 0, width, height);
                break;
            case CENTER:
                component.setBounds(getWidth() / 2 - width / 2, getHeight() / 2 - height / 2, width, height);
                break;
        }
    }

    private void setSize(Component component, int width, int height, JEasyAdvancedLayoutManager jEasyAdvancedLayoutManager) {
        switch (jEasyAdvancedLayoutManager.get_jEasyLayoutManager()) {
            case TOP:
                component.setBounds(getWidth() / 2 - width / 2 + jEasyAdvancedLayoutManager.get_xOffset(), jEasyAdvancedLayoutManager.get_yOffset(), width, height);
                break;
            case NE:
                component.setBounds(getWidth() - width + jEasyAdvancedLayoutManager.get_xOffset(), jEasyAdvancedLayoutManager.get_yOffset(), width, height);
                break;
            case LEFT:
                component.setBounds(getWidth() - width + jEasyAdvancedLayoutManager.get_xOffset(), getHeight() / 2 - height / 2 + jEasyAdvancedLayoutManager.get_yOffset(), width, height);
                break;
            case SE:
                component.setBounds(getWidth() - width + jEasyAdvancedLayoutManager.get_xOffset(), getHeight() - height - 34 + jEasyAdvancedLayoutManager.get_yOffset(), width, height);
                break;
            case BUTTON:
                component.setBounds(getWidth() / 2 - width / 2 + jEasyAdvancedLayoutManager.get_xOffset(), getHeight() - height - 34 + jEasyAdvancedLayoutManager.get_yOffset(), width, height);
                break;
            case SW:
                component.setBounds(jEasyAdvancedLayoutManager.get_xOffset(), getHeight() - height - 34 + jEasyAdvancedLayoutManager.get_yOffset(), width, height);
                break;
            case RIGHT:
                component.setBounds(jEasyAdvancedLayoutManager.get_xOffset(),getHeight() / 2 - height / 2 + jEasyAdvancedLayoutManager.get_yOffset(), width, height);
                break;
            case NW:
                component.setBounds(jEasyAdvancedLayoutManager.get_xOffset(), jEasyAdvancedLayoutManager.get_yOffset(), width, height);
                break;
            case CENTER:
                component.setBounds(getWidth() / 2 - width / 2 + jEasyAdvancedLayoutManager.get_xOffset(), getHeight() / 2 - height / 2 + jEasyAdvancedLayoutManager.get_yOffset(), width, height);
                break;
        }
    }

    private void onResize() {
        for (_Components _component : _components) {
            if (_component.advanced)
                setSize(_component.get_component(), _component.get_width(), _component.get_height(), _component.get_jEasyAdvancedLayoutManager());
            else
                setSize(_component.get_component(), _component.get_width(), _component.get_height(), _component.get_jEasyLayoutManager());
        }
    }

    private class _Components {
        public boolean advanced;
        private Component _component;
        private int _width;
        private int _height;
        private JEasyLayoutManager _jEasyLayoutManager;
        private JEasyAdvancedLayoutManager _jEasyAdvancedLayoutManager;

        public _Components(Component component, int width, int height, JEasyLayoutManager jEasyLayoutManager) {
            advanced = false;
            _component = component;
            _width = width;
            _height = height;
            _jEasyLayoutManager = jEasyLayoutManager;
        }
        public _Components(Component component, int width, int height, JEasyAdvancedLayoutManager jEasyAdvancedLayoutManager) {
            advanced = true;
            _component = component;
            _width = width;
            _height = height;
            _jEasyAdvancedLayoutManager = jEasyAdvancedLayoutManager;
        }

        public Component get_component() {
            return _component;
        }

        public int get_width() {
            return _width;
        }

        public int get_height() {
            return _height;
        }

        public JEasyLayoutManager get_jEasyLayoutManager() {
            return _jEasyLayoutManager;
        }

        public JEasyAdvancedLayoutManager get_jEasyAdvancedLayoutManager() {
            return _jEasyAdvancedLayoutManager;
        }
    }
}
