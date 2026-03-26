package fil.example.dao.file;

import fil.example.model.Attach;

import java.util.Arrays;
import java.util.List;

public class ImageExtensions extends FileOperations {
    private static List<String> fileTypesList = Arrays.asList("BMP", "JPG", "PNG");

    public List<String> getFileTypes() {
        return fileTypesList;
    }

    public static boolean saveImage(String fileName, String fileType, Attach attach) {
        if (fileType.equalsIgnoreCase("BMP")) {
            return SaveAttachmentAsBMP(fileName, attach);
        } else if (fileType.equalsIgnoreCase("JPG")) {
            return SaveAttachmentAsJPG(fileName, attach);
        } else if (fileType.equalsIgnoreCase("png")) {
            return SaveAttachmentAsPNG(fileName, attach);
        } else return false;
    }
}
