package edu.cninfo.effective.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {
    private Map<Class<?>,Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type,T instance){
        favorites.putIfAbsent(Objects.requireNonNull(type),instance);
    }

    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }


    public static void main(String[] args) {
        Favorites f=new Favorites();
        f.putFavorite(String.class,"Java");
        f.putFavorite(Integer.class,0xcafebabe);
        f.putFavorite(Class.class,Favorites.class);

        String favorite = f.getFavorite(String.class);
        Integer favoriteInteger = f.getFavorite(Integer.class);
        Class<?> fFavoriteClass = f.getFavorite(Class.class);

        System.out.printf("%s %x %s%n",favorite,favoriteInteger,fFavoriteClass);
    }
}
