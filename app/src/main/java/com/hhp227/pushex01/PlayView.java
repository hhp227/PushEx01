package com.hhp227.pushex01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class PlayView extends View {
    int[][] map = { {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 2, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
                    {1, 1, 1, 1, 1, 1, 0, 2, 0, 0, 0, 0, 0, 1, 1},
                    {1, 1, 1, 1, 1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 1},
                    {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1} };
    Bitmap playerBitmap;
    Bitmap wallBitmap;
    Bitmap starBitmap;
    Bitmap goalBitmap;
    int x = 1, y = 1;

    public PlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        playerBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.player);
        wallBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wall);
        starBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.star);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = wallBitmap.getWidth();
        int h = wallBitmap.getHeight();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                    case 1:
                    case 2:
                        canvas.drawBitmap(map[i][j] == 1 ? wallBitmap : starBitmap, w * j, h * i, null);
                }
            }
        }
        canvas.drawBitmap(playerBitmap, w * x, h * y, null);
    }

    public void up() {
        if (map[y - 1][x] != 1) {
            if (map[y - 1][x] == 2) {
                if (map[y - 2][x] != 1) {
                    map[y - 1][x] = 0;
                    map[y - 2][x] = 2;
                }
            }
            y--;
            invalidate();
        }
    }

    public void left() {
        if (map[y][x - 1] != 1) {
            if (map[y][x - 1] == 2) {
                if (map[y][x - 2] != 1) {
                    map[y][x - 1] = 0;
                    map[y][x - 2] = 2;
                }
            }
            x--;
            invalidate();
        }
    }

    public void down() {
        if (map[y + 1][x] != 1) {
            if (map[y + 1][x] == 2) {
                if (map[y + 2][x] != 1) {
                    map[y + 1][x] = 0;
                    map[y + 2][x] = 2;
                }
            }
            y++;
            invalidate();
        }
    }

    public void right() {
        if (map[y][x + 1] != 1) {
            if (map[y][x + 1] == 2) {
                if (map[y][x + 2] != 1) {
                    map[y][x + 1] = 0;
                    map[y][x + 2] = 2;
                }
            }
            x++;
            invalidate();
        }
    }
}
