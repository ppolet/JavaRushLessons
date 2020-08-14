//// https://javarush.ru/quests/lectures/questcollections.level01.lecture03
package javarushlessons.questcollectionsLevel01Lecture03;

import com.sun.xml.internal.bind.api.impl.NameConverter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilesPath {
    public static void main(String[] args) {
        System.out.println("https://javarush.ru/quests/lectures/questcollections.level01.lecture03");
        
        byte[] fileInByte = null;
        System.out.println("--- readBytes ---");
        try {
            fileInByte = Solution1.readBytes("D:\\utils\\AndroidStudioProjects\\JAVA\\JavaRushLessons\\src\\javarushlessons\\questcollectionsLevel01Lecture03\\testfile.txt");
            System.out.println("Read bytes: " + fileInByte.length);
            fileInByte = Solution1.readBytes("D:\\utils\\AndroidStudioProjects\\JAVA\\JavaRushLessons\\src\\javarushlessons\\questcollectionsLevel01Lecture03\\NOfile.txt");
            System.out.println("Read bytes: " + fileInByte.length);
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        System.out.println();
        
        
        System.out.println("--- readLines ---");
        try {
            List<String> fileLines = Solution1.readLines("D:\\utils\\AndroidStudioProjects\\JAVA\\JavaRushLessons\\src\\javarushlessons\\questcollectionsLevel01Lecture03\\testfile.txt");
            for (String stLine: fileLines){
                System.out.println(stLine);
            }
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.toString());
        }
        System.out.println();

        
        //fileInByte = null;
        System.out.println("--- writeBytes ---");
        if (fileInByte != null){
            try {
                Solution1.writeBytes(fileInByte, "D:\\utils\\AndroidStudioProjects\\JAVA\\JavaRushLessons\\src\\javarushlessons\\questcollectionsLevel01Lecture03\\newTestFile.txt");
                System.out.println("Method writeBytes DONE!");
            } catch (IOException ex) {
                System.out.println("Exception: " + ex.toString() + " ---- " + ex.getStackTrace());
            }
        }
        System.out.println();

        
        System.out.println("--- copy ---");
        try {
            String resourceFile = "D:\\utils\\AndroidStudioProjects\\JAVA\\JavaRushLessons\\src\\javarushlessons\\questcollectionsLevel01Lecture03\\TestFile.txt";
            String destinationFile = "D:\\utils\\AndroidStudioProjects\\JAVA\\JavaRushLessons\\src\\javarushlessons\\questcollectionsLevel01Lecture03\\destTestFile.txt";
            Solution1.copy(resourceFile, destinationFile);
            System.out.println("Method - copy - DONE!");
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.toString() + " ---- " + ex.getStackTrace());
        }

        ///////////////// SOLUTION 2 ////////////////////
        System.out.println();
        System.out.println("        === Solution 2 ===");
        List<String> urlForDownloading = new ArrayList<>();
        urlForDownloading.add("https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png");
        urlForDownloading.add("http://abrakadabraaaa.com/files/rules.txt");
        urlForDownloading.add("https://github.com/TheAlgorithms/Java/blob/master/README.md");
        for(String urlString: urlForDownloading){
            try {
                Solution2.downloadFile(urlString, Paths.get("d:\\temp\\javatest"));
            } catch (IOException ex) {
                System.out.println("Exception (Solution 2) URL:" + urlString + "  -  " + ex.toString() + " ---- " + ex.getStackTrace());
            }
        }
        
        
        ////////////////// SOLUTION 3 /////////////////////
        System.out.println();
        System.out.println("        === Solution 3 ===");
        try {
            Solution3.getFolderInfo();
        } catch (IOException ex) {
            Logger.getLogger(FilesPath.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

/*
Своя реализация

Реализуй логику методов:
1. readBytes - должен возвращать все байты файла fileName.
2. readLines - должен возвращать все строки файла fileName. Используй кодировку по умолчанию.
3. writeBytes - должен записывать массив bytes в файл fileName.
4. copy - должен копировать файл resourceFileName на место destinationFileName.

ГЛАВНОЕ УСЛОВИЕ:
Никаких других импортов!


Требования:
1.	Импорты в классе Solution менять нельзя.
2.	Метод readBytes должен возвращать все байты файла fileName.
3.	Метод readLines должен возвращать все строки файла fileName с кодировкой по умолчанию.
4.	Метод writeBytes должен записывать массив bytes в файл fileName.
5.	Метод copy должен копировать файл resourceFileName на место destinationFileName.
*/
class Solution1{
    public static byte[] readBytes(String fileName) throws IOException{
        if (isFileOK(fileName)){
            System.out.println(fileName + " - exist, all OK");
        }
        return Files.readAllBytes(Paths.get(fileName));
    }
    
    public static List<String> readLines(String fileName) throws IOException{
        return Files.readAllLines(Paths.get(fileName));
    }
    
    public static void writeBytes(byte[] data, String fileName) throws IOException{
        Files.write(Paths.get(fileName), data);
    }
    
    public static void copy(String resourceFileName, String destinationFileName) throws IOException{
        Files.copy(Paths.get(resourceFileName), Paths.get(destinationFileName), StandardCopyOption.REPLACE_EXISTING);
    }
    
    //---проверка наличия файла
    public static boolean isFileOK(String fileName){
        return Files.exists(Paths.get(fileName));
    }
    
}


/*
Загрузчик файлов

Реализуй метод downloadFile(String urlString, Path downloadDirectory), на вход которого подается ссылка для скачивания файла и папка, куда нужно закачать файл.
Все ссылки имеют вид:
https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png
http://toogle.com/files/rules.txt
https://pacemook.com/photos/image1.jpg

Метод должен создать объект URL и загрузить содержимое файла на локальный диск.
Выкачивай сначала во временную директорию, чтобы в случае неуспешной загрузки в твоей директории не оставались недокачанные файлы.
Затем перемести файл в пользовательскую директорию. Имя для файла возьми из ссылки.
Используй только классы и методы из пакета java.nio.


Требования:
1.	Метод downloadFile должен создавать объект URL для переданной ссылки.
2.	Метод downloadFile должен создать временный файл с помощью метода Files.createTempFile.
3.	Метод downloadFile должен скачать файл по ссылке во временный файл, используя метод Files.copy.
4.	Метод downloadFile должен переместить файл из временной директории в пользовательскую, используя метод Files.move.
5.	Имя сохраненного файла должно быть таким же, как в URL-ссылке.

*/
class Solution2{
    public static void downloadFile(String urlString, Path downloadDirectory) throws IOException{
        URL url = new URL(urlString);
        String nameURLFile = urlString.substring(urlString.lastIndexOf('/'));
        Path tempFile = Files.createTempFile("tmp_", ".txt");
        Files.copy(url.openStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
        Path newFile = Paths.get(downloadDirectory.toString() + nameURLFile);
        Files.move(tempFile, newFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File: " + urlString + " downloaded to " + newFile + " SUCCESSFULLY");
    }
}


/*
Что внутри папки?

Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок - [количество папок в директории и поддиректориях]
Всего файлов - [количество файлов в директории и поддиректориях]
Общий размер - [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.
Квадратные скобки [] выводить на экран не нужно.


Требования:
1.	Метод main должен считывать путь к папке с консоли.
2.	Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.
3.	Используй только классы и методы из пакета java.nio.
4.	На консоль должна быть выведена следующая информация: "Всего папок - [количество папок в директории и поддиректориях]".
5.	На консоль должна быть выведена следующая информация: "Всего файлов - [количество файлов в директории и поддиректориях]".
6.	На консоль должна быть выведена следующая информация: "Общий размер - [общее количество байт, которое хранится в директории]".
*/

class Solution3 extends SimpleFileVisitor<Path>{
    public static void getFolderInfo() throws IOException{
        String pathFromConsole;
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Введите путь к папке: ");
            pathFromConsole = sc.nextLine();
        }
        
        Path path;
        try {
            path = Paths.get(pathFromConsole);
        } catch (InvalidPathException ex) {
            System.out.println("Exception: " + ex);
            System.out.println("[" + pathFromConsole + "] - не папка");
            return;
        }
        if (!Files.isDirectory(path)){
            System.out.println("[" + pathFromConsole + "] - не папка");
            return;
        }
        System.out.println("Path: " + path.toString());
        
        Files.walkFileTree(
            path,
            new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println(file.getFileName());
                    return FileVisitResult.CONTINUE;
                }
            });
                        
    }

}