package com.example.folk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerateQRActivity extends AppCompatActivity {
    String folk_id;


    Button generate_QR_code;
    ImageView QR_code_image_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);

            Intent get_details_intent = getIntent();
            folk_id = get_details_intent.getStringExtra("folk_id");



            QR_code_image_view = findViewById(R.id.QR_code_image_view);

        generate_QR_code = findViewById(R.id.generate_QR_code);

        generate_QR_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode(folk_id, BarcodeFormat.QR_CODE,500,500);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    QR_code_image_view.setImageBitmap(bitmap);
                }catch (WriterException e){
                    e.printStackTrace();
                }


            }
        });
    }
}
