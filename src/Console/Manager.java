package Console;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager <T extends Manageable>  {
    ArrayList<T> mList = new ArrayList<>();

    Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (IOException e) {
            System.out.println("파일 입력 오류");
            System.exit(0);
        }

        return filein;
    }

    public void readAll(String filename, Factory<T> fac){
        Scanner filein = openFile(filename);
        while(filein.hasNext()){
            T t = fac.create();
            t.read(filein);
            mList.add(t);
        }
    }

    public T getList(int idx) { return mList.get(idx); }
    public int getSize() { return mList.size(); }
}
