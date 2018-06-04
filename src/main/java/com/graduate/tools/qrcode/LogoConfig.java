package com.graduate.tools.qrcode;

import java.awt.*;

/**
 * @author xiyouquedongxing
 * @date 2018/4/24 15:28
 */
public class LogoConfig {
    //logo默认边框颜色
    public static final Color DEFAULT_BORDERCOLOR = Color.WHITE;
    //logo默认边框宽度
    public static final int DEFAULT_BORDER = 2;
    //logo大小默认为二维码大小的1/6
    public static final int DEFAULT_LOGOPART = 6;

    private final int border = DEFAULT_BORDER;
    private final Color borderColor;
    private final int logoPart;

    public LogoConfig() {
        this(DEFAULT_BORDERCOLOR, DEFAULT_LOGOPART);
    }

    public LogoConfig(Color borderColor, int logoPart) {
        this.borderColor = borderColor;
        this.logoPart = logoPart;
    }

    public int getBorder() {
        return border;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public int getLogoPart() {
        return logoPart;
    }
}
