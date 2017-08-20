package com.libraryprojects.json_parsing.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anand-trisys on 18/8/17.
 */

public class Color
{



        @SerializedName("color")
        @Expose
        private String color;
        @SerializedName("category")
        @Expose
        private String category;
        @SerializedName("hex")
        @Expose
        private String hex;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getHex() {
            return hex;
        }

        public void setHex(String hex) {
            this.hex = hex;
        }

    }

