package pe.avp.registroproductos.dao;

import java.util.List;

import pe.avp.registroproductos.modelo.Producto;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class ProductoDAO extends SQLiteOpenHelper {
	private static final String DATABASE = "RegistroProducto";
	private static final int VERSION = 1 ;
	public ProductoDAO(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DATABASE, factory, VERSION);
		// TODO Auto-generated constructor stub
	}



	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put("nombre",producto.getNombre());
		values.put("descripcion", producto.getDescripcion());
		values.put("foto", producto.getFoto());
		values.put("rating", producto.getRating());
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String ddl= "CREATE TABLE Producto(id.PRIMARY KEY,"+
						"nombre TEXT UNIQUE NOT NULL, " +
						"descripcion TEXT," +
						"foto, " +
						"rating REAL),";
		db.execSQL(ddl);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String ddl= "DROP TABLE IF EXISTS Producto";
		db.execSQL(ddl);
		this.onCreate(db);
		
	}
	
//	public List<Producto> getLista() {
//		// TODO Auto-generated method stub
//		String[] columnas= {"id","nombre","descripcion","foto","rating"};
////		Cursor cursor = getWritableDatabase().query("Producto", columnas,null,null,null,null);
////		return productos;
//
//	}
}
