package tw.lan.my_notebook;

import android.graphics.Color;

/**
 * Created by MASERATI on 2017/2/20.
 */

public enum Colors {

    LIGHTGREY("#D3D3D3"), BLUE("#33B5E5"), PURPLE("#AA66CC"),
    GREEN("#99CC00"), ORANGE("#FFBB33"), RED("#FF4444");

    private String code;

    private Colors(String code) {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }

    public int parseColor()
    {
        return Color.parseColor(code);
    }
}
