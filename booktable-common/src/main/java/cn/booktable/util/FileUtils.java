package cn.booktable.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

/**
 * @author ljc
 */
public class FileUtils {

    /**
     * 将文件转成base64字符串
     * @param filePath 文件位置
     * @return
     * @throws Exception
     */
    public static String fileToBase64(String filePath)throws Exception
    {
        File file=new File(filePath);
        FileInputStream inputFile=new FileInputStream(file);
        byte[] buffer=new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return Base64.getEncoder().encodeToString(buffer);
    }

    /**
     * base64字符串转文件
     * @param base64Code
     * @param filePath
     * @throws Exception
     */
    public static void base86ToFile(String base64Code,String filePath)throws Exception{
        byte[] buffer=Base64.getDecoder().decode(base64Code);
        FileOutputStream out=new FileOutputStream(filePath);
        out.write(buffer);
        out.close();
    }
}
