package com.company;


import com.company.Controller.GuiController;

public class Main {
        public static GuiController controller;

        public static void main(String[] args) {
                controller = new GuiController();
                controller.regGui.setVisible(true);
        }
}