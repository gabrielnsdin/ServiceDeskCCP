package deswebmob.ftce.usjt.br.servicedesk.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

import deswebmob.ftce.usjt.br.servicedesk.R;

/**
 * Created by Gabriel on 22/03/2018.
 */

public class Util {
    public static Drawable getDrawableDinamic(Context contexto, String nomeImage){
        Class<?> c = R.drawable.class;
        try {
            Field idField = c.getDeclaredField(nomeImage);
            int id = idField.getInt(idField);
            return contexto.getResources().getDrawable(id, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
