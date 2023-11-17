import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "hikesGrw";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "hikes";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAME_COL = "name";

    // below variable id for our course duration column.
    private static final String LOCATION_COL = "location";

    // below variable for our course description column.
    private static final String DATE_COL = "date";
    // below variable is for our course tracks column.
    private static final String PARKING_COL = "packing";
    private static final String LENGTH_COL = "length";
    private static final String LEVEL_COL = "level";
    private static final String DESCRIPTION_COL = "description";
    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating 
        // an sqlite query and we are 
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + LOCATION_COL + " TEXT,"
                + DATE_COL + " TEXT,"
                + PARKING_COL + " TEXT,"
                + LENGTH_COL + " TEXT,"
                + LEVEL_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT)";


        // at last we are calling a exec sql 
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewHike(String hikeName, String hikeLocation,String hikeDate,String hikeParking,String hikeLength,String hikeLevel, String courseDescription) {

        // on below line we are creating a variable for 
        // our sqlite database and calling writable method 
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a 
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values 
        // along with its key and value pair.
        values.put(NAME_COL, hikeName);
        values.put(LOCATION_COL, hikeLocation);
        values.put(DATE_COL, hikeDate);
        values.put(PARKING_COL, hikeParking);
        values.put(LENGTH_COL, hikeLength);
        values.put(LEVEL_COL, hikeLevel);
        values.put(DESCRIPTION_COL, courseDescription);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}