package jp.ac.shohoku.aporochoco.imgeditapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class CanvasView extends View {

    private final ArrayList<Path> pathList;  // 直線リスト
    private final Paint paint;

    //======================================================================================
    //--  コンストラクタ
    //======================================================================================
    public CanvasView(Context context) {
        super(context);

        //-- 初期化
        //- Path関連
        pathList = new ArrayList<Path>();   // リストの作成

        //- Paint関連
        paint = new Paint();
        paint.setColor(Color.RED);          // 色の指定
        paint.setStyle(Paint.Style.STROKE); // 描画設定を'線'に設定
        paint.setAntiAlias(true);           // アンチエイリアスの適応
        paint.setStrokeWidth(10);           // 線の太さ
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //-- 初期化
        //- Path関連
        pathList = new ArrayList<Path>();   // リストの作成

        //- Paint関連
        paint = new Paint();
        paint.setColor(Color.BLACK);          // 色の指定
        paint.setStyle(Paint.Style.STROKE); // 描画設定を'線'に設定
        paint.setAntiAlias(true);           // アンチエイリアスの適応
        paint.setStrokeWidth(10);           // 線の太さ
    }


    //======================================================================================
    //--  描画メソッド
    //======================================================================================
    @Override
    protected void onDraw(Canvas canvas) {
        for ( Path path : pathList ) {
            canvas.drawPath(path, paint);   // Pathの描画
        }

        invalidate();   // 再描画
    }

    //======================================================================================
    //--  タッチイベント
    //=====================================================================================
    private Path drawingPath;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch ( event.getAction() ) {
            case MotionEvent.ACTION_DOWN:                             //- 画面をタッチしたとき
                drawingPath = new Path();                         // 新たなPathのインスタンスの作成
                drawingPath.moveTo(event.getX(), event.getY());   // 始点を設定
                pathList.add(drawingPath);                        // リストにPathを追加
                break;
            case MotionEvent.ACTION_UP:                               //- 画面から指を離したとき
                drawingPath.moveTo(event.getX(), event.getY());   // 移動先の追加
                break;
            case MotionEvent.ACTION_MOVE:                             //- タッチしながら指をスライドさせたとき
                drawingPath.lineTo(event.getX(), event.getY());   // 移動先の追加
                break;
        }

        return true;   /* 返却値は必ず "true" にすること!! */
}

    //======================================================================================
    //--  削除メソッド
    //======================================================================================

    public void allDelete() {
        pathList.clear();   // リストが保持しているPathのインスタンスを全て削除
    }
}
