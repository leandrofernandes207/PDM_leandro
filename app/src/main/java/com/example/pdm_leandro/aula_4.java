package com.example.pdm_leandro;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pdm_leandro.R;

public class aula_4 extends Activity {

    private final int sel_contato = 0;
    private final int pegar_foto = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_4);
    }

    public void web(View view) {
        Uri uri = Uri.parse("http://www.unisc.com.br");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }
    public void ligar(View view) {
        Uri uri = Uri.parse("tel: 99887766");
        Intent it = new Intent(Intent.ACTION_CALL, uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(it);
    }

    public void contatos(View view) {
        Uri uri = Uri.parse("content://com.android.contacts/contacts");
        Intent it = new Intent(Intent.ACTION_PICK, uri);
        startActivityForResult(it, sel_contato);

    }

    public void TakePicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, pegar_foto);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == sel_contato && resultCode == RESULT_OK) {
            Uri uri = data.getData();

            Cursor c = getContentResolver().query(uri, null, null, null, null);
            c.moveToNext();
            int nameCol = c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME);
            int idCol = c.getColumnIndexOrThrow(ContactsContract.Contacts._ID);
            String name = c.getString(nameCol);
            String id = c.getString(idCol);
            c.close();

            Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" = "+id, null, null);
            phones.moveToNext();
            String number=phones.getString(phones.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
            phones.close();
            TextView txtnome = (TextView) findViewById(R.id.nome);
            TextView txtfone = (TextView) findViewById(R.id.fone);
            txtnome.setText(name);
            txtfone.setText(number);


        }
        if (requestCode == pegar_foto && resultCode == RESULT_OK) {
            ImageView im = (ImageView)findViewById(R.id.imagem);
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            im.setImageBitmap(imageBitmap);
        }
    }

}

