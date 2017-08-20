package com.libraryprojects.json_parsing.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anand-trisys on 18/8/17.
 */

public class colors
{
    @SerializedName("colors")
    @Expose
    private List<Color> colors = null;

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }
}
