package utils;

public class CategoryUtils {
    public static boolean isValidCategory(String category) {
        switch (category) {
            case "eletronicos":
            case "vestuario":
            case "alimentos":
                return true;
            default:
                return false;
        }
    }
}
