package parallax.scroll.swipe.effect.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jiku on 2015-04-03.
 */
public class City implements Parcelable{
    private String name;
    private String description;
    private int imageResourceId;

    public City(String name, String description, int imageResourceId){
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return  this.description;
    }

    public int getImageResourceId(){
        return  this.imageResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    private City(Parcel in) {
        this.name  = in.readString();
        this.description = in.readString();
        this.imageResourceId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.imageResourceId);
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        public City[] newArray(int size) {
            return new City[size];
        }
    };
}
