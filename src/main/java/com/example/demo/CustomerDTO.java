package com.example.demo;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1L;
        private String name;

        public CustomerDTO() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

}
